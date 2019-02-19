package com.qixu.es.search.impl;


import com.qixu.es.search.api.response.SearchAccountModel;
import com.qixu.es.search.api.request.SearchSet;
import com.qixu.es.search.api.dto.PageDTO;

/**
 * @author castle
 * @date 2018/7/9
 **/
public interface AccountSearchService {
    /**
     * 搜素账号信息
     * @param searchSet
     * @return
     */
    PageDTO<SearchAccountModel> search(SearchSet searchSet);
}
