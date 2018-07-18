package com.qixu.es.search.impl;

import com.qixu.es.search.annotation.CompareOperation;
import com.qixu.es.search.annotation.EsSearch;
import com.qixu.es.search.annotation.QueryMethod;
import com.qixu.es.search.annotation.Range;
import com.qixu.es.search.dto.SearchCondition;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Collection;

import static org.elasticsearch.index.query.QueryBuilders.*;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.termsQuery;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class ElasticSearchHelper {

    public static QueryBuilder queryBuilder(SearchCondition condition) {
        //构建查询条件
        BoolQueryBuilder boolQueryBuilder = boolQuery();
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
                } else if (QueryMethod.TERMs == esSearchInfo.method()) {
                    if (value instanceof Collection) {
                        queryBuilder = termsQuery(queryName, (Collection) value);
                    } else {
                        queryBuilder = termsQuery(queryName, value);
                    }
                } else if (QueryMethod.RANGE == esSearchInfo.method()) {
                    BoolQueryBuilder bool = boolQuery();
                    for (Range range : esSearchInfo.rangeInfo()) {
                        RangeQueryBuilder rangeQueryBuilder = rangeQuery(range.queryName());
                        if (CompareOperation.GREATER == range.operation()) {
                            rangeQueryBuilder.from(value).includeLower(range.include());
                        } else {
                            rangeQueryBuilder.to(value).includeUpper(range.include());
                        }
                        bool.filter(rangeQueryBuilder);
                    }
                    queryBuilder = bool.hasClauses() ? bool : null;
                }
                if (queryBuilder != null) {
                    if (esSearchInfo.isFilter()) {
                        boolQueryBuilder.filter(queryBuilder);
                    } else {
                        boolQueryBuilder.must(queryBuilder);
                    }
                }
            } catch (Exception e) {

            }
        }
        return boolQueryBuilder.hasClauses() ? boolQueryBuilder : matchAllQuery();
    }
}
