package com.qixu.es.search.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author castle
 * @date 2018/10/31
 **/
public class SearchLogModel implements Serializable {
    private String level;
    private List<String> tags;
    private String message;

    private Beat beat;

    @JsonProperty("@timestamp")
    private Date timestamp;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Beat getBeat() {
        return beat;
    }

    public void setBeat(Beat beat) {
        this.beat = beat;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SearchLogModel{" +
                "level='" + level + '\'' +
                ", tags=" + tags +
                ", message='" + message + '\'' +
                ", beat=" + beat +
                ", timestamp=" + timestamp +
                '}';
    }
}
