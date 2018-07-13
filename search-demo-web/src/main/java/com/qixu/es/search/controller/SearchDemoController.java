package com.qixu.es.search.controller;

import com.qixu.es.search.dto.PageDTO;
import com.qixu.es.search.dto.SearchAccountModel;
import com.qixu.es.search.dto.SearchSet;
import com.qixu.es.search.impl.AccountSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author castle
 * @date 2018/7/9
 **/
@RestController
public class SearchDemoController {
    @Autowired
    private AccountSearchService accountSearchService;
    /**
     * 搜索商品
     */
    @PostMapping(value = "search/account")
    PageDTO<SearchAccountModel> search(@Valid @RequestBody SearchSet searchSet){
        return accountSearchService.search(searchSet);
    }
}
