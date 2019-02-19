package com.qixu.es.search.service;

import com.qixu.es.search.api.response.SearchGoodsModel;
import com.qixu.es.search.api.dto.PageDTO;
import com.qixu.es.search.entity.GoodsEntity;
import com.qixu.es.search.entity.GoodsFrameBarcodeEntity;
import com.qixu.es.search.repository.GoodsFrameBarcodeRepository;
import com.qixu.es.search.repository.GoodsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author castle
 * @date 2018/8/17
 **/
@Service
@Transactional(rollbackFor = Exception.class, readOnly = true)
public class GoodsService {
    private static final Logger logger = LoggerFactory.getLogger(GoodsService.class);
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsFrameBarcodeRepository barcodeRepository;

    public GoodsEntity findGoodsByGoodsId(Long merchantId,String goodsId) {
        return goodsRepository.findByMerchantIdAndGoodsId(merchantId,goodsId);
    }


    public List<GoodsEntity> findGoods(Long merchantId) {
        return goodsRepository.findBymerchantId(merchantId);
    }

    public PageDTO<SearchGoodsModel> findGoodsFrameBarcode(int pageSize, int pageNo, Long merchantId) {
        return getGoodsFrameBarcode(pageSize, pageNo, merchantId);
    }

    public PageDTO<SearchGoodsModel> getGoodsFrameBarcode(int pageSize, int pageNo, Long merchantId) {
//        PageRequest pageRequest = new PageRequest((pageNo - 1), pageSize, new Sort(Sort.Direction., "id"));

//        Page<GoodsFrameBarcodeEntity> page = barcodeRepository.findAll(where(merchantId), pageRequest);

//        List<SearchGoodsModel> list = new LinkedList<>();
//        if (page.hasContent()) {
//            for (GoodsFrameBarcodeEntity barcodeEntity : page) {
//                if (list)
//                    List<Price> prices = new ArrayList<>();
//                SearchGoodsModel model = new SearchGoodsModel();
//                model.setGoodsId(barcodeEntity.getGoodsId());
//                model.setMerchantId(barcodeEntity.getMerchantId());
//                model.setCategoryId(barcodeEntity.getSpecId());
//                model.setUnit(barcodeEntity.getUnit());
//                Price price = new Price();
//                price.setBarcode(barcodeEntity.getBarcode());
//                price.setStoreId(barcodeEntity.getStoreId());
//                price.setPrice(barcodeEntity.getPrice());
//                prices.add(price);
//                model.setPrices(prices);
//                list.add(model);
//            }
//        }

//        PageDTO<SearchGoodsModel> infoPage = new PageDTO<>(pageNo, pageSize, page.getTotalElements(), list);
//        return infoPage;
        return null;
    }

    private Specification<GoodsFrameBarcodeEntity> where(final Long merchantId) {
        return new Specification<GoodsFrameBarcodeEntity>() {
            @Override
            public Predicate toPredicate(Root<GoodsFrameBarcodeEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                list.add(cb.equal(root.get("merchantid").as(Long.class), merchantId));
                return query.where(list.toArray(new Predicate[list.size()])).getRestriction();
            }
        };
    }

    public List<String> findGoodsId(Integer merchantId) {
        List<GoodsFrameBarcodeEntity> barcodeEntities = barcodeRepository.findBymerchantIdGroupBygoodsId(merchantId);
//        List<GoodsFrameBarcodeEntity> barcodeEntities = barcodeRepository.findByMerchantId(merchantId);
//        GoodsFrameBarcodeEntity barcodeEntities = barcodeRepository.findBarcode(merchantId, "1057", "3001122", "6925303751395");
        List<String> goodsids = new ArrayList<>();
        barcodeEntities.stream().forEach(barcode -> {
            goodsids.add(barcode.getGoodsId());
        });
        return goodsids;
//        System.out.println(barcodeEntities);
//        return null;
    }

    public List<SearchGoodsModel> findFrameBarcode(Integer merchantId) {
        List<SearchGoodsModel> models = null;
        List<Object> barcodeEntities = barcodeRepository.findAllGoods(merchantId);
        if (barcodeEntities != null && barcodeEntities.size() > 0) {
            models = new ArrayList<>();
            for (int i = 0; i < barcodeEntities.size(); i++) {
                Object[] rowArray = (Object[]) barcodeEntities.get(i);
                SearchGoodsModel model = new SearchGoodsModel();
                model.setMerchantId((Integer) rowArray[0]);
                model.setGoodsId((String) rowArray[1]);
                model.setStoreId(Long.valueOf((String) rowArray[2]));
                model.setBarcode((String) rowArray[3]);
                model.setPrice(Double.valueOf(((BigDecimal) rowArray[4]).doubleValue()));
                model.setUnit((String) rowArray[5]);
                model.setName((String) rowArray[6]);
                models.add(model);
            }
        }


//        List<GoodsFrameBarcodeEntity> barcodeEntities = barcodeRepository.findBymerchantIdAndGoodsId(merchantId, goodsid);
//        if (barcodeEntities != null && barcodeEntities.size() > 0) {
//            models = new ArrayList<>();
//            for (int i = 0; i < barcodeEntities.size(); i++) {
//                GoodsFrameBarcodeEntity barcodeEntity = barcodeEntities.get(i);
//                SearchGoodsModel model = new SearchGoodsModel();
//                model.setMerchantId(barcodeEntity.getMerchantId());
//                model.setGoodsId(barcodeEntity.getGoodsId());
//                model.setCategoryId(barcodeEntity.getSpecId());
//                model.setUnit(barcodeEntity.getUnit());
//                model.setPrice(barcodeEntity.getPrice());
//                model.setBarcode(barcodeEntity.getBarcode());
//                model.setStoreId(Long.valueOf(barcodeEntity.getStoreId()));
//                model.setName(barcodeEntity.getName());
//                models.add(model);
//            }
//        }
        return models;
    }
}
