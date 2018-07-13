package com.qixu.es.search.impl;

import com.qixu.es.search.dto.*;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class AccountSearchServiceImpl implements AccountSearchService, Closeable {
    private Logger logger = LoggerFactory.getLogger(AccountSearchServiceImpl.class);
    public static String INDEX_NAME = "bank";
    public static String TYPE_NAME = "account";
    private TransportClient client;

    public AccountSearchServiceImpl(TransportClient client) {
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
