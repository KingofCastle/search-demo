package com.qixu.es.search.api.request;

import java.io.Serializable;

/**
 * @author castle
 * @date 2018/10/31
 **/
public class SearchLogSet implements Serializable {
    private SearchLogCondition searchLogCondition;
    private SortModel sortModel;
    /**
     * 环境
     */
    private String env;

    public SearchLogSet() {
    }

    public SearchLogSet(SearchLogCondition searchLogCondition, SortModel sortModel, String env) {
        this.searchLogCondition = searchLogCondition;
        this.sortModel = sortModel;
        this.env = env;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public SearchLogCondition getSearchLogCondition() {
        return searchLogCondition;
    }

    public void setSearchLogCondition(SearchLogCondition searchLogCondition) {
        this.searchLogCondition = searchLogCondition;
    }

    public SortModel getSortModel() {
        return sortModel;
    }

    public void setSortModel(SortModel sortModel) {
        this.sortModel = sortModel;
    }

    @Override
    public String toString() {
        return "SearchLogSet{" +
                "searchLogCondition=" + searchLogCondition +
                ", sortModel=" + sortModel +
                ", env='" + env + '\'' +
                '}';
    }
}
