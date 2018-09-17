package com.qixu.es.search.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author castle
 * @date 2018/08/17
 */
@Entity
@Table(name = "goods_frame_barcode")
public class GoodsFrameBarcodeEntity implements Serializable {
    @Column(
            name = "id"
    )
    @Id
    @GeneratedValue
    private Long id;
    @Column(
            name = "merchantid"
    )
    private Integer merchantId;
    @Column(
            name = "goodsid"
    )
    private String goodsId;
    @Column(
            name = "storeid"
    )
    private String storeId;
    @Column(
            name = "barcode"
    )
    private String barcode;
    @Column(
            name = "name"
    )
    private String name;
    @Column(
            name = "code_type"
    )
    private String codeType;
    @Column(
            name = "unit"
    )
    private String unit;
    @Column(
            name = "spec_info"
    )
    private String specInfo;
    @Column(
            name = "content"
    )
    private Double content;
    @Column(
            name = "price"
    )
    private Double price;
    @Column(
            name = "member_price"
    )
    private Double memberPrice;
    @Column(
            name = "memo"
    )
    private String memo;
    @Column(
            name = "created_at"
    )
    private Date createdAt;
    @Column(
            name = "updated_at"
    )
    private Date updatedAt;
    @Column(
            name = "specid"
    )
    private String specId;

    public GoodsFrameBarcodeEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public String getGoodsId() {
        return this.goodsId;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public String getName() {
        return this.name;
    }


    public String getUnit() {
        return this.unit;
    }

    public String getSpecInfo() {
        return this.specInfo;
    }

    public Double getContent() {
        return this.content;
    }

    public Double getPrice() {
        return this.price;
    }

    public Double getMemberPrice() {
        return this.memberPrice;
    }

    public String getMemo() {
        return this.memo;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public String getSpecId() {
        return this.specId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setSpecInfo(String specInfo) {
        this.specInfo = specInfo;
    }

    public void setContent(Double content) {
        this.content = content;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setMemberPrice(Double memberPrice) {
        this.memberPrice = memberPrice;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

}
