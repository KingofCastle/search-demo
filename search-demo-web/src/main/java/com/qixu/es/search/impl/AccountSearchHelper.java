package com.qixu.es.search.impl;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author castle
 * @date 2018/7/12
 **/
public class AccountSearchHelper {
    public static String ACCOUNT_MAPPING;
    public static final String TYPE_NAME = "account";
    public static final String FULL_TEXT_NAME = "fullText";

    static {
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame("account_number", "long", "not_analyzed", null));
        frames.add(new Frame("balance", "long", "not_analyzed", null));
        frames.add(new Frame("firstname", "String", "not_analyzed", null));
        frames.add(new Frame("lastname", "String", "not_analyzed", null));
        frames.add(new Frame("age", "long", "not_analyzed", null));
        frames.add(new Frame("gender", "String", "not_analyzed", null));
        frames.add(new Frame("address", "String", "analyzed", "snowball"));
        frames.add(new Frame("employer", "String", "not_analyzed", null));
        frames.add(new Frame("email", "String", "not_analyzed", null));
        frames.add(new Frame("city", "String", "not_analyzed", null));
        frames.add(new Frame("state", "String", "not_analyzed", null));


        try {
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            builder.startObject("_all").field("enable","false").endObject();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private static class Frame {
        String name;
        String type;
        String index;
        String analyzer;

        public Frame(String name, String type, String index, String analyzer) {
            this.name = name;
            this.type = type;
            this.index = index;
            this.analyzer = analyzer;
        }
    }
}
