package com.qixu.es.search.controller;

import com.qixu.es.search.api.dto.*;
import com.qixu.es.search.api.request.SearchLogSet;
import com.qixu.es.search.api.response.SearchLogModel;
import com.qixu.es.search.entity.GoodsEntity;
import com.qixu.es.search.impl.LogSearchHelper;
import com.qixu.es.search.impl.LogSearchService;
import com.qixu.es.search.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author castle
 * @date 2018/10/26
 **/
@RestController
public class SearchDemoControllerTest {
    //    @Autowired
//    private AccountSearchService accountSearchService;
//    @Autowired
//    private GoodsSearchService goodsSearchService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private LogSearchService logSearchService;

//    /**
//     * 搜索商品
//     */
//    @PostMapping(value = "search/goods")
//    public PageDTO<SearchGoodsModel> searchGoods(@Valid @RequestBody SearchGoodsSet searchGoodsSet) {
//        return goodsSearchService.search(searchGoodsSet);
//    }
//
//    /**
//     * 搜索商品
//     */
//    @PostMapping(value = "search/account")
//    public PageDTO<SearchAccountModel> search(@Valid @RequestBody SearchSet searchSet) {
//        return accountSearchService.search(searchSet);
//    }

    /**
     * 搜索日志
     */
    @PostMapping(value = "search/log")
    public PageDTO<SearchLogModel> search(@Valid @RequestBody SearchLogSet searchLogSet) {
        String indexName = LogSearchHelper.indexName(searchLogSet.getEnv());
        return logSearchService.search(searchLogSet, indexName);
    }

    @GetMapping(value = "find")
    public String search(@Valid @RequestParam long merchantId, @RequestParam String goodsId) {
        GoodsEntity goodsEntity = goodsService.findGoodsByGoodsId(merchantId, goodsId);
        System.out.println(goodsEntity);
        return "ok";
    }

//    /**
//     * s索引商品
//     *
//     * @param goods
//     */
//    @PostMapping(value = "/index/goods")
//    public void indexGoods(@Valid @RequestBody SearchGoodsModel goods) {
//        goodsSearchService.indexGoods(goods);
//    }
//
//    @GetMapping(value = "/index/db")
//    public String indexGoodsFromDB(@RequestParam Integer merchantId) {
//        //先找到所有的goodsId
////        List<String> goodsIds = goodsService.findGoodsId(merchantId);
//        //对每个goodsid查找对应barcode
////        if (goodsIds != null && goodsIds.size() > 0) {
////            for (int i = 0; i < goodsIds.size(); i++) {
//        List<SearchGoodsModel> models = goodsService.findFrameBarcode(merchantId);
//        if (models != null) {
//            models.stream().forEach(model -> {
//                goodsSearchService.indexGoods(model);
//            });
//        }
////            }
////        }
//        return "ok";
//    }
}
