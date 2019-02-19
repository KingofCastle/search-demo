package com.qixu.es.search.api.request;

import com.qixu.es.search.api.request.SearchAccountCondition;
import com.qixu.es.search.api.request.SortModel;

import java.io.Serializable;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class SearchSet implements Serializable {
    private SearchAccountCondition searchAccountCondition;
    private SortModel sortModel;

    public SearchSet() {
    }

    public SearchAccountCondition getSearchAccountCondition() {
        return searchAccountCondition;
    }

    public void setSearchAccountCondition(SearchAccountCondition searchAccountCondition) {
        this.searchAccountCondition = searchAccountCondition;
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
                "searchAccountCondition=" + searchAccountCondition +
                ", sortModel=" + sortModel +
                '}';
    }
}
