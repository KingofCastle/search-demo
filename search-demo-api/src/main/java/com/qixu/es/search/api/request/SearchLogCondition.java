package com.qixu.es.search.api.request;

import com.qixu.es.search.api.annotation.CompareOperation;
import com.qixu.es.search.api.annotation.EsSearch;
import com.qixu.es.search.api.annotation.QueryMethod;
import com.qixu.es.search.api.annotation.Range;

/**
 * @author castle
 * @date 2018/10/31
 **/
public class SearchLogCondition extends SearchCondition {
    @EsSearch(method = QueryMethod.TERM)
    private String tags;
    @EsSearch(method = QueryMethod.RANGE,
            rangeInfo = {@Range(queryName = "@timestamp", operation = CompareOperation.GREATER,include = true)})
    private String startDate;

    @EsSearch(method = QueryMethod.RANGE,
            rangeInfo = {@Range(queryName = "@timestamp", operation = CompareOperation.LESS,include = true)
            })
    private String endDate;
    /**
     * 主机
     */
    @EsSearch(method = QueryMethod.TERM,queryName = "beat.hostname")
    private String hostname;
    @EsSearch(method = QueryMethod.TERM, queryName = "level")
    private String logLevel;
    @EsSearch(method = QueryMethod.MATCH)
    private String message;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SearchLogCondition{" +
                "tags='" + tags + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", hostname='" + hostname + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
