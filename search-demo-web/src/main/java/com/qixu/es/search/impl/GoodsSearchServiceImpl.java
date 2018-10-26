package com.qixu.es.search.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qixu.es.search.api.dto.*;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
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
    public static ObjectMapper objectMapper = new ObjectMapper();

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

    @Override
    public PageDTO<SearchAccountModel> search(SearchGoodsSet searchGoodsSet) {
        logger.info("begin search goods:{}", searchGoodsSet.toString());
        //取得搜索条件
        SearchGoodsCondition condition = searchGoodsSet.getSearchGoodsCondition();
        //暂时只分页
        SortModel sortModel = searchGoodsSet.getSortModel();

        //TODO
        SearchRequestBuilder requestBuilder = initSearch().setQuery(ElasticSearchHelper.queryBuilder(condition))
                .setFrom((sortModel.getPageNo() - 1) * sortModel.getPageSize()).setSize(sortModel.getPageSize());

        SearchResponse response = requestBuilder.get();
        List<SearchGoodsModel> goodsModels = new ArrayList<>();
        for (SearchHit hit : response.getHits()) {
            String source = hit.getSourceAsString();
            if (null != source && source.length() > 0) {
                try {
                    SearchGoodsModel model = objectMapper.readValue(source, SearchGoodsModel.class);
                    goodsModels.add(model);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("search goods result,pageNo:{}, pageSize:{}, totalSize:{}", sortModel.getPageNo(), sortModel.getPageSize(), response.getHits().getTotalHits());
        return new PageDTO(sortModel.getPageNo(), sortModel.getPageSize(), response.getHits().getTotalHits(), goodsModels);

    }

    private SearchRequestBuilder initSearch() {
        return client.prepareSearch(INDEX_NAME).setTypes(TYPE_NAME);
    }

    private String goodToMap(SearchGoodsModel goods) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("merchantId", goods.getMerchantId());
        data.put("goodsId", goods.getGoodsId());
        data.put("unit", goods.getUnit());
        data.put("price", goods.getPrice());
        data.put("storeId", goods.getStoreId());
        data.put("name", goods.getName());
        data.put("barcode",goods.getBarcode());
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
