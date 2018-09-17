package com.qixu.es.search.repository;


import com.qixu.es.search.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsRepository extends JpaRepository<GoodsEntity, Long>, JpaSpecificationExecutor<GoodsEntity> {

    List<GoodsEntity> findBymerchantId(Long merchantId);
}
