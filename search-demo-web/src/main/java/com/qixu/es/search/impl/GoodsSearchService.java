package com.qixu.es.search.impl;

import com.qixu.es.search.dto.SearchGoodsModel;

import java.util.List;

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
}
