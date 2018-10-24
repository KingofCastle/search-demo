package com.qixu.es.search.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qixu.es.search.dto.*;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class AccountSearchServiceImpl implements AccountSearchService, Closeable {
    private Logger logger = LoggerFactory.getLogger(AccountSearchServiceImpl.class);
    private String INDEX_NAME;
    private String TYPE_NAME;
    private TransportClient client;

    public AccountSearchServiceImpl(String INDEX_NAME, String TYPE_NAME, TransportClient client) {
        this.INDEX_NAME = INDEX_NAME;
        this.TYPE_NAME = TYPE_NAME;
        this.client = client;
    }
    public  static ObjectMapper objectMapper = new ObjectMapper();
    static{
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }
    @Override
    public PageDTO<SearchAccountModel> search(SearchSet searchSet) {
        logger.info("begin search account:{}", searchSet.toString());
        //取得搜索条件
        SearchAccountCondition condition = searchSet.getSearchAccountCondition();
        //暂时只分页
        SortModel sortModel = searchSet.getSortModel();

        //TODO
        SearchRequestBuilder requestBuilder = initSearch().setQuery(ElasticSearchHelper.queryBuilder(condition))
                .setFrom((sortModel.getPageNo() - 1) * sortModel.getPageSize()).setSize(sortModel.getPageSize());

        SearchResponse response = requestBuilder.get();
        List<SearchAccountModel> accountModels = new ArrayList<>();
        for (SearchHit hit : response.getHits()) {
            String source = hit.getSourceAsString();
            if (null != source && source.length() > 0) {
                try {
                    SearchAccountModel model =  objectMapper.readValue(source,SearchAccountModel.class);
                    accountModels.add(model);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("pageNo:{}, pageSize:{}, totalSize:{}",sortModel.getPageNo(), sortModel.getPageSize(), response.getHits().getTotalHits());
        return new PageDTO<>(sortModel.getPageNo(), sortModel.getPageSize(),response.getHits().getTotalHits(),accountModels);
    }


    private SearchRequestBuilder initSearch() {
        return client.prepareSearch(INDEX_NAME).setTypes(TYPE_NAME);
    }

    @Override
    public void close() throws IOException {
        if (client != null) {
            client.close();
        }
    }
}
