package com.qixu.es.search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author castle
 * @date 2018/7/9
 **/
@Configuration
@PropertySource("classpath:systemConfig.properties")
public class SystemConfig {
    @Value("${es.address.host.ports}")
    private String esAddressHostPorts;
    @Value("${cluster.name}")
    private String clusterName;
    @Value("${index.name}")
    private String indexName;

    @Value("${es.username}")
    private String esUserName;
    @Value("${es.password}")
    private String esPassword;

    public String getEsAddressHostPorts() {
        return esAddressHostPorts;
    }

    public void setEsAddressHostPorts(String esAddressHostPorts) {
        this.esAddressHostPorts = esAddressHostPorts;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getEsUserName() {
        return esUserName;
    }

    public void setEsUserName(String esUserName) {
        this.esUserName = esUserName;
    }

    public String getEsPassword() {
        return esPassword;
    }

    public void setEsPassword(String esPassword) {
        this.esPassword = esPassword;
    }
}
