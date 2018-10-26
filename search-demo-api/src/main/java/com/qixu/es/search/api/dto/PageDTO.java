package com.qixu.es.search.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class PageDTO<T> implements Serializable {
    private int pageNo;
    private int pageSize;
    private long totalSize;

    private List<T> list = new ArrayList<>();

    public PageDTO() {
    }

    public PageDTO(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageDTO(int pageNo, int pageSize, long totalSize, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.list = list;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
