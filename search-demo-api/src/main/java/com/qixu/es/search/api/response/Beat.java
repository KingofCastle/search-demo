package com.qixu.es.search.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author castle
 * @date 2018/11/5
 **/
public class Beat implements Serializable {
    @JsonProperty("hostname")
    private String hostName;
    private String name;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Beat{" +
                "hostName='" + hostName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
