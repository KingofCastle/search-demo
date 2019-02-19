package com.qixu.es.search.impl;

import com.qixu.es.search.api.response.SearchGoodsModel;
import com.qixu.es.search.api.request.SearchGoodsSet;
import com.qixu.es.search.api.dto.PageDTO;

/**
 * @author castle
 * @date 2018/7/9
 **/
public interface GoodsSearchService {
    /**
     * 索引商品信息
     *
     * @param goods
     */
    void indexGoods(SearchGoodsModel goods);

    PageDTO<SearchGoodsModel> search(SearchGoodsSet searchGoodsSet);
}
