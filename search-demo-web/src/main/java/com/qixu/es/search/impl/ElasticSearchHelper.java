package com.qixu.es.search.impl;

import com.qixu.es.search.annotation.EsSearch;
import com.qixu.es.search.annotation.QueryMethod;
import com.qixu.es.search.dto.SearchCondition;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Collection;

import static org.elasticsearch.index.query.QueryBuilders.*;
import static org.elasticsearch.index.query.QueryBuilders.termsQuery;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class ElasticSearchHelper {

    public static QueryBuilder queryBuilder(SearchCondition condition) {
        BoolQueryBuilder boolQueryBuilder = boolQuery();

        //构建查询条件
        for (Field field : condition.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(condition);
                if (null == value) {
                    continue;
                }
                QueryBuilder queryBuilder = null;
                EsSearch esSearchInfo = field.getAnnotation(EsSearch.class);
                String queryName = "".equals(esSearchInfo.queryName()) ? field.getName() : esSearchInfo.queryName();
                if (QueryMethod.MATCH == esSearchInfo.method()) {
                    queryBuilder = matchQuery(queryName, value);
                } else if (QueryMethod.TERM == esSearchInfo.method()) {
                    queryBuilder = termQuery(queryName, value);
                }else if (QueryMethod.TERMs == esSearchInfo.method()) {
                    if (value instanceof Collection) {
                        queryBuilder = termsQuery(queryName, (Collection) value);
                    } else {
                        queryBuilder = termsQuery(queryName, value);
                    }
                }
            } catch (Exception e) {

            }
        }
        return null;
    }
}
