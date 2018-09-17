package com.qixu.es.search.repository;


import com.qixu.es.search.entity.GoodsFrameBarcodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsFrameBarcodeRepository extends JpaRepository<GoodsFrameBarcodeEntity, Long>, JpaSpecificationExecutor<GoodsFrameBarcodeEntity> {

    List<GoodsFrameBarcodeEntity> findByMerchantId(Integer merchantId);

    @Query(value = "select * from goods_frame_barcode where merchantid = ?1 group by goodsid", nativeQuery = true)
    List<GoodsFrameBarcodeEntity> findBymerchantIdGroupBygoodsId(Integer merchantId);

    @Query(value = "SELECT * FROM goods_frame_barcode WHERE merchantid = ?1 AND goodsid = ?2", nativeQuery = true)
    List<GoodsFrameBarcodeEntity> findBymerchantIdAndGoodsId(Integer merchantId, String goodsid);

    @Query(value = "SELECT * FROM goods_frame_barcode WHERE merchantid = ?1 AND storeid = ?2 AND goodsid = ?3 AND barcode = ?4", nativeQuery = true)
    GoodsFrameBarcodeEntity findBarcode(Integer merchantId, String storeId, String goodsId, String barcode);
}
