package com.qixu.es.search.api;

import com.qixu.es.search.api.dto.*;
import com.qixu.es.search.api.request.SearchGoodsSet;
import com.qixu.es.search.api.request.SearchSet;
import com.qixu.es.search.api.response.SearchAccountModel;
import com.qixu.es.search.api.response.SearchGoodsModel;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author castle
 * @date 2018/10/26
 **/
//@FeignClient(value = "search-demo")
public interface SearchDemoApi {
    /**
     * 商品搜索
     *
     * @param searchGoodsSet
     * @return
     */
    @PostMapping(value = "search/goods")
    PageDTO<SearchGoodsModel> searchGoods(SearchGoodsSet searchGoodsSet);

    /**
     * 账号搜索
     *
     * @param searchSet
     * @return
     */
    @PostMapping(value = "search/account")
    PageDTO<SearchAccountModel> search(SearchSet searchSet);

    /**
     * 索引商品
     *
     * @param goods
     */
    @PostMapping(value = "/index/goods")
    void indexGoods(SearchGoodsModel goods);
}
