package com.qixu.es.search.api.request;


import com.qixu.es.search.api.annotation.EsSearch;
import com.qixu.es.search.api.annotation.QueryMethod;

/**
 * @author castle
 * @date 2018/10/22
 **/
public class SearchGoodsCondition extends SearchCondition {
    @EsSearch(method = QueryMethod.TERM)
    private Integer merchantId;
    @EsSearch(method = QueryMethod.TERM)
    private String goodsId;
    @EsSearch(method = QueryMethod.TERM)
    private Long storeId;
    @EsSearch(method = QueryMethod.TERM)
    private String barcode;
    @EsSearch(method = QueryMethod.MATCH)
    private String name;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SearchGoodsCondition{" +
                "merchantId=" + merchantId +
                ", goodsId='" + goodsId + '\'' +
                ", storeId=" + storeId +
                ", barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
