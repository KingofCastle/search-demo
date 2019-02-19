package com.qixu.es.search.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qixu.es.search.api.dto.*;
import com.qixu.es.search.api.request.SearchLogCondition;
import com.qixu.es.search.api.request.SearchLogSet;
import com.qixu.es.search.api.request.SortModel;
import com.qixu.es.search.api.response.SearchLogModel;
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
public class LogSearchServiceImpl implements LogSearchService, Closeable {
    private Logger logger = LoggerFactory.getLogger(LogSearchServiceImpl.class);
    private String INDEX_NAME;
    private String TYPE_NAME;
    private TransportClient client;

    public LogSearchServiceImpl(String TYPE_NAME, TransportClient client) {
        this.TYPE_NAME = TYPE_NAME;
        this.client = client;
    }

    public static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public PageDTO<SearchLogModel> search(SearchLogSet searchLogSet, String indexName) {
        this.INDEX_NAME = indexName;
        long current = System.currentTimeMillis();
        logger.info("begin search log:{} ,begin:{}", searchLogSet.toString(),current);
        //取得搜索条件
        SearchLogCondition condition = searchLogSet.getSearchLogCondition();
        //暂时只分页
        SortModel sortModel = searchLogSet.getSortModel();

        //TODO
        SearchRequestBuilder requestBuilder = initSearch().setQuery(ElasticSearchHelper.queryLogBuilder(condition))
                .setFrom((sortModel.getPageNo() - 1) * sortModel.getPageSize()).setSize(sortModel.getPageSize());

        SearchResponse response = requestBuilder.get();
        List<SearchLogModel> logModels = new ArrayList<>();
        for (SearchHit hit : response.getHits()) {
            String source = hit.getSourceAsString();
            if (null != source && source.length() > 0) {
                try {
                    SearchLogModel model = objectMapper.readValue(source, SearchLogModel.class);
                    logModels.add(model);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("search log result,pageNo:{}, pageSize:{}, totalSize:{},end:{}", sortModel.getPageNo(), sortModel.getPageSize(), response.getHits().getTotalHits(),System.currentTimeMillis()-current);
        return new PageDTO(sortModel.getPageNo(), sortModel.getPageSize(), response.getHits().getTotalHits(), logModels);

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
