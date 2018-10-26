package com.qixu.es.search.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author castle
 * @date 2018/7/9
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EsSearch {
    boolean isFilter() default true;

    QueryMethod method();

    String queryName() default "";

    Range[] rangeInfo() default {};
}
