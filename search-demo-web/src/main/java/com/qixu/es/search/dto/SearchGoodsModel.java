package com.qixu.es.search.dto;

import java.util.List;

/**
 * @author castle
 * @date 2018/8/16
 * 商品good
 **/
public class SearchGoodsModel {
    private Integer merchantId;
    private String goodsId;
    private String categoryId;
    private String unit;
    private Long storeId;
    private String barcode;
    private Double price;

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SearchGoodsModel{" +
                "merchantId=" + merchantId +
                ", goodsId='" + goodsId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", unit='" + unit + '\'' +
                ", storeId='" + storeId + '\'' +
                ", barcode=" + barcode +
                ", price=" + price +
                '}';
    }
}
