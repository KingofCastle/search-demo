package com.qixu.es.search.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author castle
 * @date 2018/08/17
 */
@Entity
@Table(name = "goods")
public class GoodsEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "merchantid")
    private Long merchantId;
    @Column(name = "goodsid")
    private String goodsId;
    @Column(name = "barcode")
    private String barcode;
//    @Column(name = "custom_code")
//    private String customCode;
//    @Column(name = "pluno")
//    private String pluno;
//    @Column(name = "categoryid")
//    private String categoryId;
//    @Column(name = "category_name")
//    private String categoryName;
//    @Column(name = "brandid")
//    private String brandId;
//    @Column(name = "brand_name")
//    private String brandName;
//    @Column(name = "code_type")
//    private String codeType;
//    @Column(name = "goods_type")
//    private Integer goodsType;
//    @Column(name = "status")
//    private Integer status;
//    @Column(name = "pro_status")
//    private Integer proStatus;
//    @Column(name = "sale_status")
//    private Integer saleStatus;
//    @Column(name = "online_sale_status")
//    private Integer onlineSaleStatus;
//    @Column(name = "offline_sale_status")
//    private Integer offlineSaleStatus;
//    @Column(name = "price_mode")
//    private Integer priceMode;
//    @Column(name = "name")
//    private String name;
//    @Column(name = "description")
//    private String description;
//    @Column(name = "unit")
//    private String unit;
//    @Column(name = "specid")
//    private String specId;
//    @Column(name = "spec_info")
//    private String specInfo;
//    @Column(name = "content")
//    private Double content;
//    @Column(name = "price")
//    private Double price;
//    @Column(name = "member_price")
//    private Double memberPrice;
//    @Column(name = "price_round")
//    private Double priceRound;
//    @Column(name = "price_factor")
//    private Double priceFactor;
//    @Column(name = "fresh_days")
//    private Integer freshDays;
//    @Column(name = "keep_days")
//    private Integer keepDays;
//    @Column(name = "min_price")
//    private Double minPrice;
//    @Column(name = "max_price")
//    private Double maxPrice;
//    @Column(name = "min_rate")
//    private Double minRate;
//    @Column(name = "max_rate")
//    private Double maxRate;
//    @Column(name = "discount_rate")
//    private Double discountRate;
//    @Column(name = "member_rate")
//    private Double memberRate;
//    @Column(name = "tax")
//    private Double tax;
//    @Column(name = "lengths")
//    private Double lengths;
//    @Column(name = "width")
//    private Double width;
//    @Column(name = "height")
//    private Double height;
//    @Column(name = "weight")
//    private Double weight;
//    @Column(name = "max_layers")
//    private Integer maxLayers;
//    @Column(name = "color")
//    private Integer color;
//    @Column(name = "color_str")
//    private String colorStr;
//    @Column(name = "material")
//    private String material;
//    @Column(name = "environment")
//    private String environment;
//    @Column(name = "eat_method")
//    private String eatMethod;
//    @Column(name = "web_page")
//    private String webPage;
//    @Column(name = "picture")
//    private String picture;
//    @Column(name = "goods_size")
//    private String goodsSize;
//    @Column(name = "goods_no")
//    private String goodsNo;
//    @Column(name = "series")
//    private String series;
//    @Column(name = "style")
//    private String style;
//    @Column(name = "od_day")
//    private Integer odDay;
//    @Column(name = "produce")
//    private String produce;
//    @Column(name = "grade")
//    private String grade;
//    @Column(name = "is_spec")
//    private String isSpec;
//    @Column(name = "is_batch")
//    private String isBatch;
//    @Column(name = "is_discount")
//    private String isDiscount;
//    @Column(name = "is_vip_discount")
//    private String isVipDiscount;
//    @Column(
//            name = "is_check"
//    )
//    private String isCheck;
//    @Column(name = "is_stock")
//    private String isStock;
//    @Column(name = "is_weight")
//    private String isWeight;
//    @Column(
//            name = "have_accessory"
//    )
//    private String haveAccessory;
//    @Column(
//            name = "is_self_fetch"
//    )
//    private String isSelfFetch;
//    @Column(
//            name = "is_gift"
//    )
//    private String isGift;
//    @Column(
//            name = "memo"
//    )
//    private String memo;
//    @Column(
//            name = "created_at"
//    )
//    private Date createdAt;
//    @Column(
//            name = "updated_at"
//    )
//    private Date updatedAt;
//    @Column(name = "batch_no")
//    private String batchNo;
//
//    public GoodsEntity() {
//    }
//
//    public Long getId() {
//        return this.id;
//    }
//
//    public Integer getMerchantId() {
//        return this.merchantId;
//    }
//
//    public String getGoodsId() {
//        return this.goodsId;
//    }
//
//    public String getBarcode() {
//        return this.barcode;
//    }
//
//    public String getCustomCode() {
//        return this.customCode;
//    }
//
//    public String getPluno() {
//        return this.pluno;
//    }
//
//    public String getCategoryId() {
//        return this.categoryId;
//    }
//
//    public String getCategoryName() {
//        return this.categoryName;
//    }
//
//    public String getBrandId() {
//        return this.brandId;
//    }
//
//    public String getBrandName() {
//        return this.brandName;
//    }
//
//    public String getCodeType() {
//        return this.codeType;
//    }
//
//    public Integer getGoodsType() {
//        return this.goodsType;
//    }
//
//    public Integer getStatus() {
//        return this.status;
//    }
//
//    public Integer getProStatus() {
//        return this.proStatus;
//    }
//
//    public Integer getSaleStatus() {
//        return this.saleStatus;
//    }
//
//    public Integer getOnlineSaleStatus() {
//        return this.onlineSaleStatus;
//    }
//
//    public Integer getOfflineSaleStatus() {
//        return this.offlineSaleStatus;
//    }
//
//    public Integer getPriceMode() {
//        return this.priceMode;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//    public String getUnit() {
//        return this.unit;
//    }
//
//    public String getSpecId() {
//        return this.specId;
//    }
//
//    public String getSpecInfo() {
//        return this.specInfo;
//    }
//
//    public Double getContent() {
//        return this.content;
//    }
//
//    public Double getPrice() {
//        return this.price;
//    }
//
//    public Double getMemberPrice() {
//        return this.memberPrice;
//    }
//
//    public Double getPriceRound() {
//        return this.priceRound;
//    }
//
//    public Double getPriceFactor() {
//        return this.priceFactor;
//    }
//
//    public Integer getFreshDays() {
//        return this.freshDays;
//    }
//
//    public Integer getKeepDays() {
//        return this.keepDays;
//    }
//
//    public Double getMinPrice() {
//        return this.minPrice;
//    }
//
//    public Double getMaxPrice() {
//        return this.maxPrice;
//    }
//
//    public Double getMinRate() {
//        return this.minRate;
//    }
//
//    public Double getMaxRate() {
//        return this.maxRate;
//    }
//
//    public Double getDiscountRate() {
//        return this.discountRate;
//    }
//
//    public Double getMemberRate() {
//        return this.memberRate;
//    }
//
//    public Double getTax() {
//        return this.tax;
//    }
//
//    public Double getLengths() {
//        return this.lengths;
//    }
//
//    public Double getWidth() {
//        return this.width;
//    }
//
//    public Double getHeight() {
//        return this.height;
//    }
//
//    public Double getWeight() {
//        return this.weight;
//    }
//
//    public Integer getMaxLayers() {
//        return this.maxLayers;
//    }
//
//    public Integer getColor() {
//        return this.color;
//    }
//
//    public String getColorStr() {
//        return this.colorStr;
//    }
//
//    public String getMaterial() {
//        return this.material;
//    }
//
//    public String getEnvironment() {
//        return this.environment;
//    }
//
//    public String getEatMethod() {
//        return this.eatMethod;
//    }
//
//    public String getWebPage() {
//        return this.webPage;
//    }
//
//    public String getPicture() {
//        return this.picture;
//    }
//
//    public String getGoodsSize() {
//        return this.goodsSize;
//    }
//
//    public String getGoodsNo() {
//        return this.goodsNo;
//    }
//
//    public String getSeries() {
//        return this.series;
//    }
//
//    public String getStyle() {
//        return this.style;
//    }
//
//    public Integer getOdDay() {
//        return this.odDay;
//    }
//
//    public String getProduce() {
//        return this.produce;
//    }
//
//    public String getGrade() {
//        return this.grade;
//    }
//
//    public String getIsSpec() {
//        return this.isSpec;
//    }
//
//    public String getIsBatch() {
//        return this.isBatch;
//    }
//
//    public String getIsDiscount() {
//        return this.isDiscount;
//    }
//
//    public String getIsVipDiscount() {
//        return this.isVipDiscount;
//    }
//
//    public String getIsCheck() {
//        return this.isCheck;
//    }
//
//    public String getIsStock() {
//        return this.isStock;
//    }
//
//    public String getIsWeight() {
//        return this.isWeight;
//    }
//
//    public String getHaveAccessory() {
//        return this.haveAccessory;
//    }
//
//    public String getIsSelfFetch() {
//        return this.isSelfFetch;
//    }
//
//    public String getIsGift() {
//        return this.isGift;
//    }
//
//    public String getMemo() {
//        return this.memo;
//    }
//
//    public Date getCreatedAt() {
//        return this.createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return this.updatedAt;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setMerchantId(Integer merchantId) {
//        this.merchantId = merchantId;
//    }
//
//    public void setGoodsId(String goodsId) {
//        this.goodsId = goodsId;
//    }
//
//    public void setBarcode(String barcode) {
//        this.barcode = barcode;
//    }
//
//    public void setCustomCode(String customCode) {
//        this.customCode = customCode;
//    }
//
//    public void setPluno(String pluno) {
//        this.pluno = pluno;
//    }
//
//    public void setCategoryId(String categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public void setBrandId(String brandId) {
//        this.brandId = brandId;
//    }
//
//    public void setBrandName(String brandName) {
//        this.brandName = brandName;
//    }
//
//    public void setCodeType(String codeType) {
//        this.codeType = codeType;
//    }
//
//    public void setGoodsType(Integer goodsType) {
//        this.goodsType = goodsType;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public void setProStatus(Integer proStatus) {
//        this.proStatus = proStatus;
//    }
//
//    public void setSaleStatus(Integer saleStatus) {
//        this.saleStatus = saleStatus;
//    }
//
//    public void setOnlineSaleStatus(Integer onlineSaleStatus) {
//        this.onlineSaleStatus = onlineSaleStatus;
//    }
//
//    public void setOfflineSaleStatus(Integer offlineSaleStatus) {
//        this.offlineSaleStatus = offlineSaleStatus;
//    }
//
//    public void setPriceMode(Integer priceMode) {
//        this.priceMode = priceMode;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setUnit(String unit) {
//        this.unit = unit;
//    }
//
//    public void setSpecId(String specId) {
//        this.specId = specId;
//    }
//
//    public void setSpecInfo(String specInfo) {
//        this.specInfo = specInfo;
//    }
//
//    public void setContent(Double content) {
//        this.content = content;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public void setMemberPrice(Double memberPrice) {
//        this.memberPrice = memberPrice;
//    }
//
//    public void setPriceRound(Double priceRound) {
//        this.priceRound = priceRound;
//    }
//
//    public void setPriceFactor(Double priceFactor) {
//        this.priceFactor = priceFactor;
//    }
//
//    public void setFreshDays(Integer freshDays) {
//        this.freshDays = freshDays;
//    }
//
//    public void setKeepDays(Integer keepDays) {
//        this.keepDays = keepDays;
//    }
//
//    public void setMinPrice(Double minPrice) {
//        this.minPrice = minPrice;
//    }
//
//    public void setMaxPrice(Double maxPrice) {
//        this.maxPrice = maxPrice;
//    }
//
//    public void setMinRate(Double minRate) {
//        this.minRate = minRate;
//    }
//
//    public void setMaxRate(Double maxRate) {
//        this.maxRate = maxRate;
//    }
//
//    public void setDiscountRate(Double discountRate) {
//        this.discountRate = discountRate;
//    }
//
//    public void setMemberRate(Double memberRate) {
//        this.memberRate = memberRate;
//    }
//
//    public void setTax(Double tax) {
//        this.tax = tax;
//    }
//
//    public void setLengths(Double lengths) {
//        this.lengths = lengths;
//    }
//
//    public void setWidth(Double width) {
//        this.width = width;
//    }
//
//    public void setHeight(Double height) {
//        this.height = height;
//    }
//
//    public void setWeight(Double weight) {
//        this.weight = weight;
//    }
//
//    public void setMaxLayers(Integer maxLayers) {
//        this.maxLayers = maxLayers;
//    }
//
//    public void setColor(Integer color) {
//        this.color = color;
//    }
//
//    public void setColorStr(String colorStr) {
//        this.colorStr = colorStr;
//    }
//
//    public void setMaterial(String material) {
//        this.material = material;
//    }
//
//    public void setEnvironment(String environment) {
//        this.environment = environment;
//    }
//
//    public void setEatMethod(String eatMethod) {
//        this.eatMethod = eatMethod;
//    }
//
//    public void setWebPage(String webPage) {
//        this.webPage = webPage;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
//
//    public void setGoodsSize(String goodsSize) {
//        this.goodsSize = goodsSize;
//    }
//
//    public void setGoodsNo(String goodsNo) {
//        this.goodsNo = goodsNo;
//    }
//
//    public void setSeries(String series) {
//        this.series = series;
//    }
//
//    public void setStyle(String style) {
//        this.style = style;
//    }
//
//    public void setOdDay(Integer odDay) {
//        this.odDay = odDay;
//    }
//
//    public void setProduce(String produce) {
//        this.produce = produce;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//
//    public void setIsSpec(String isSpec) {
//        this.isSpec = isSpec;
//    }
//
//    public void setIsBatch(String isBatch) {
//        this.isBatch = isBatch;
//    }
//
//    public void setIsDiscount(String isDiscount) {
//        this.isDiscount = isDiscount;
//    }
//
//    public void setIsVipDiscount(String isVipDiscount) {
//        this.isVipDiscount = isVipDiscount;
//    }
//
//    public void setIsCheck(String isCheck) {
//        this.isCheck = isCheck;
//    }
//
//    public void setIsStock(String isStock) {
//        this.isStock = isStock;
//    }
//
//    public void setIsWeight(String isWeight) {
//        this.isWeight = isWeight;
//    }
//
//    public void setHaveAccessory(String haveAccessory) {
//        this.haveAccessory = haveAccessory;
//    }
//
//    public void setIsSelfFetch(String isSelfFetch) {
//        this.isSelfFetch = isSelfFetch;
//    }
//
//    public void setIsGift(String isGift) {
//        this.isGift = isGift;
//    }
//
//    public void setMemo(String memo) {
//        this.memo = memo;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getBatchNo() {
//        return batchNo;
//    }
//
//    public void setBatchNo(String batchNo) {
//        this.batchNo = batchNo;
//    }
}
