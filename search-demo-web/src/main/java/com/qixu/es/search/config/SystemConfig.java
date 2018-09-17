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
    @Value("${index.bank}")
    private String indexBank;
    @Value("${index.goods}")
    private String indexGoods;

    @Value("${es.username}")
    private String esUserName;
    @Value("${es.password}")
    private String esPassword;

    @Value("${datasource.url}")
    private String dataSourceUrl;

    @Value("${datasource.username}")
    private String dataSourceUserName;

    @Value("${datasource.password}")
    private String dataSourcePassword;

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

    public String getIndexBank() {
        return indexBank;
    }

    public void setIndexBank(String indexBank) {
        this.indexBank = indexBank;
    }

    public String getIndexGoods() {
        return indexGoods;
    }

    public void setIndexGoods(String indexGoods) {
        this.indexGoods = indexGoods;
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

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
    }

    public String getDataSourceUserName() {
        return dataSourceUserName;
    }

    public void setDataSourceUserName(String dataSourceUserName) {
        this.dataSourceUserName = dataSourceUserName;
    }

    public String getDataSourcePassword() {
        return dataSourcePassword;
    }

    public void setDataSourcePassword(String dataSourcePassword) {
        this.dataSourcePassword = dataSourcePassword;
    }
}
