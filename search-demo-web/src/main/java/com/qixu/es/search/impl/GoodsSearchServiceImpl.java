package com.qixu.es.search.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qixu.es.search.dto.Price;
import com.qixu.es.search.dto.SearchGoodsModel;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author castle
 * @date 2018/8/16
 **/
public class GoodsSearchServiceImpl implements GoodsSearchService {
    private static Logger logger = LoggerFactory.getLogger(GoodsSearchServiceImpl.class);
    private TransportClient client;
    private String INDEX_NAME;
    private String TYPE_NAME;

    public GoodsSearchServiceImpl(TransportClient client, String INDEX_NAME, String TYPE_NAME) {
        this.client = client;
        this.INDEX_NAME = INDEX_NAME;
        this.TYPE_NAME = TYPE_NAME;
    }

    @Override
    public void indexGoods(SearchGoodsModel goods) {
        logger.info("索引商品：{}", goods.toString());
//        XContentBuilder builder = goodToXContentBuilder(goods);
        String data = goodToMap(goods);
        prepareUpdate(getDocumentId(goods)).setDoc(data).setDocAsUpsert(true).get();
    }

    private String goodToMap(SearchGoodsModel goods) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("merchantId", goods.getMerchantId());
        data.put("goodsId", goods.getGoodsId());
        data.put("categoryId", goods.getCategoryId());
        data.put("unit", goods.getUnit());
        data.put("price", goods.getPrice());
        String json = JSON.toJSONString(goods);
        return json;
    }

    private UpdateRequestBuilder prepareUpdate(String id) {
        return client.prepareUpdate(INDEX_NAME, TYPE_NAME, id);
    }

    private XContentBuilder goodToXContentBuilder(SearchGoodsModel goods) {
        XContentBuilder builder = null;
        try {
            builder = XContentFactory.jsonBuilder();
            builder.startObject(); // root
            // map the fields of searchGoods
            mapGoodsFields(goods, builder);
            builder.endObject();// root
            return builder;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mapGoodsFields(SearchGoodsModel goods, XContentBuilder builder) {
        Field[] fields = SearchGoodsModel.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                String name = field.getName();
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object value = field.get(goods);
                if (null != value) {
                    builder.field(name, value);
                }
            } catch (IllegalAccessException | IOException e) {
                // just ignore the failed field.
            }
        }
    }

    private String getDocumentId(SearchGoodsModel goods) {
        return (new StringBuilder()).append(goods.getMerchantId()).append("_").append(goods.getStoreId()).append("_").append(goods.getGoodsId()).append("_").append(goods.getBarcode()).toString();
    }
}
