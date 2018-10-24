package com.qixu.es.search.impl;

import com.qixu.es.search.dto.PageDTO;
import com.qixu.es.search.dto.SearchAccountModel;
import com.qixu.es.search.dto.SearchGoodsModel;
import com.qixu.es.search.dto.SearchGoodsSet;

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

    PageDTO<SearchAccountModel> search(SearchGoodsSet searchGoodsSet);
}
