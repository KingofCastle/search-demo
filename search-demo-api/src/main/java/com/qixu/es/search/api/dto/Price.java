package com.qixu.es.search.api.dto;

/**
 * @author castle
 * @date 2018/8/16
 * 商品不同门店 不同条码对应不同价格
 **/
public class Price {
    private String storeId;
    private String barcode;
    private Double price;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
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
        return "Price{" +
                "storeId=" + storeId +
                ", barcode='" + barcode + '\'' +
                ", price=" + price +
                '}';
    }
}
