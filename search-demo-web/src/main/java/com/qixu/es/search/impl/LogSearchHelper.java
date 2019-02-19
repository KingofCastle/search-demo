package com.qixu.es.search.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author castle
 * @date 2018/10/31
 **/
public class LogSearchHelper {
    private static String INDEX_NAME_PREFIX = "cpos-";
    private static String INDEX_NAME_SUFFIX = "-filebeat-6.2.2-";

    public static String indexName(String environment) {
        StringBuilder builder = new StringBuilder();
        builder.append(INDEX_NAME_PREFIX).append(environment).append(INDEX_NAME_SUFFIX);
        String date = getNowDate();
        builder.append(date);
        return builder.toString();
    }

    private static String getNowDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        return sdf.format(d);
    }

}
