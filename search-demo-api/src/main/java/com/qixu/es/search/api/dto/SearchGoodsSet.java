package com.qixu.es.search.api.dto;

import java.io.Serializable;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class SearchGoodsSet implements Serializable {
    private SearchGoodsCondition searchGoodsCondition;
    private SortModel sortModel;

    public SearchGoodsSet() {
    }

    public SearchGoodsCondition getSearchGoodsCondition() {
        return searchGoodsCondition;
    }

    public void setSearchGoodsCondition(SearchGoodsCondition searchGoodsCondition) {
        this.searchGoodsCondition = searchGoodsCondition;
    }

    public SortModel getSortModel() {
        return sortModel;
    }

    public void setSortModel(SortModel sortModel) {
        this.sortModel = sortModel;
    }

    @Override
    public String toString() {
        return "SearchGoodsSet{" +
                "searchGoodsCondition=" + searchGoodsCondition +
                ", sortModel=" + sortModel +
                '}';
    }
}
