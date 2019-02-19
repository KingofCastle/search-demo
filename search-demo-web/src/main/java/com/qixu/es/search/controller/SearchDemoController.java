//package com.qixu.es.search.controller;
//
//import com.qixu.es.search.api.SearchDemoApi;
//import com.qixu.es.search.api.dto.*;
//import com.qixu.es.search.impl.AccountSearchService;
//import com.qixu.es.search.impl.GoodsSearchService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author castle
// * @date 2018/7/9
// **/
//@RestController
//public class SearchDemoController implements SearchDemoApi {
//    @Autowired
//    private AccountSearchService accountSearchService;
//    @Autowired
//    private GoodsSearchService goodsSearchService;
//
//
//    @Override
//    public PageDTO<SearchGoodsModel> searchGoods(SearchGoodsSet searchGoodsSet) {
//        return goodsSearchService.search(searchGoodsSet);
//    }
//
//    @Override
//    public PageDTO<SearchAccountModel> search(SearchSet searchSet) {
//        return accountSearchService.search(searchSet);
//    }
//
//    @Override
//    public void indexGoods(SearchGoodsModel goods) {
//        goodsSearchService.indexGoods(goods);
//    }
//}
