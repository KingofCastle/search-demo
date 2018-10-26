package com.qixu.es.search.controller;

import com.qixu.es.search.api.dto.*;
import com.qixu.es.search.impl.AccountSearchService;
import com.qixu.es.search.impl.GoodsSearchService;
import com.qixu.es.search.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author castle
 * @date 2018/10/26
 **/
@RestController
public class SearchDemoControllerTest {
    @Autowired
    private AccountSearchService accountSearchService;
    @Autowired
    private GoodsSearchService goodsSearchService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 搜索商品
     */
    @PostMapping(value = "search/goods")
    public PageDTO<SearchAccountModel> searchGoods(@Valid @RequestBody SearchGoodsSet searchGoodsSet) {
        return goodsSearchService.search(searchGoodsSet);
    }

    /**
     * 搜索商品
     */
    @PostMapping(value = "search/account")
    public PageDTO<SearchAccountModel> search(@Valid @RequestBody SearchSet searchSet) {
        return accountSearchService.search(searchSet);
    }

    /**
     * s索引商品
     *
     * @param goods
     */
    @PostMapping(value = "/index/goods")
    public void indexGoods(@Valid @RequestBody SearchGoodsModel goods) {
        goodsSearchService.indexGoods(goods);
    }

    @GetMapping(value = "/index/db")
    public String indexGoodsFromDB(@RequestParam Integer merchantId) {
        //先找到所有的goodsId
//        List<String> goodsIds = goodsService.findGoodsId(merchantId);
        //对每个goodsid查找对应barcode
//        if (goodsIds != null && goodsIds.size() > 0) {
//            for (int i = 0; i < goodsIds.size(); i++) {
        List<SearchGoodsModel> models = goodsService.findFrameBarcode(merchantId);
        if (models != null) {
            models.stream().forEach(model -> {
                goodsSearchService.indexGoods(model);
            });
        }
//            }
//        }
        return "ok";
    }
}
