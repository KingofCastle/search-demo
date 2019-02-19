package com.qixu.es.search.impl;


import com.qixu.es.search.api.dto.*;
import com.qixu.es.search.api.request.SearchLogSet;
import com.qixu.es.search.api.response.SearchLogModel;

/**
 * @author castle
 * @date 2018/10/31
 **/
public interface LogSearchService {
    /**
     * 搜素日志信息
     * @param searchLogSet
     * @param indexName
     * @return
     */
    PageDTO<SearchLogModel> search(SearchLogSet searchLogSet, String indexName);
}
