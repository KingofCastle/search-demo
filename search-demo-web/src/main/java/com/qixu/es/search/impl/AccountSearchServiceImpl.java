package com.qixu.es.search.impl;

import com.qixu.es.search.dto.*;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Closeable;
import java.io.IOException;

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

    @Override
    public PageDTO<SearchAccountModel> search(SearchSet searchSet) {
        logger.info("begin search account:{}", searchSet.toString());
        //取得搜索条件
        SearchCondition condition = searchSet.getSearchCondition();
        SortModel sortModel = searchSet.getSortModel();

        //TODO
        SearchRequestBuilder requestBuilder = null;
        return null;
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
