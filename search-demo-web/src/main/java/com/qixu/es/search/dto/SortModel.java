package com.qixu.es.search.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class SortModel implements Serializable {
    @Min(value = 1, message = "pageNo 最小为1")
    private int pageNo = 1;
    @Range(min = 1, max = 500, message = "pageSize 取值范围是1到20")
    private int pageSize = 20;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SortModel{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
