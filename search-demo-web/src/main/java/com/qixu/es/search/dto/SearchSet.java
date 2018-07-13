package com.qixu.es.search.dto;

import java.io.Serializable;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class SearchSet implements Serializable {
    private SearchCondition searchCondition;
    private SortModel sortModel;

    public SearchSet() {
    }

    public SearchCondition getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(SearchCondition searchCondition) {
        this.searchCondition = searchCondition;
    }

    public SortModel getSortModel() {
        return sortModel;
    }

    public void setSortModel(SortModel sortModel) {
        this.sortModel = sortModel;
    }

    @Override
    public String toString() {
        return "SearchSet{" +
                "searchCondition=" + searchCondition +
                ", sortModel=" + sortModel +
                '}';
    }
}
