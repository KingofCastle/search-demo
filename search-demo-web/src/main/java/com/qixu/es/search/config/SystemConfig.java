package com.qixu.es.search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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

    @Value("${log.es.address.host}")
    private String logEsAddressHost;

    @Value("${log.cluster.name}")
    private String logClusterName;

    @Value("${log.es.username}")
    private String logEsUsername;

    @Value("${log.es.password}")
    private String logEsPassword;

    @Value("${log.type.name}")
    private String logTypeName;

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

    public String getLogEsAddressHost() {
        return logEsAddressHost;
    }

    public void setLogEsAddressHost(String logEsAddressHost) {
        this.logEsAddressHost = logEsAddressHost;
    }

    public String getLogClusterName() {
        return logClusterName;
    }

    public void setLogClusterName(String logClusterName) {
        this.logClusterName = logClusterName;
    }

    public String getLogEsUsername() {
        return logEsUsername;
    }

    public void setLogEsUsername(String logEsUsername) {
        this.logEsUsername = logEsUsername;
    }

    public String getLogEsPassword() {
        return logEsPassword;
    }

    public void setLogEsPassword(String logEsPassword) {
        this.logEsPassword = logEsPassword;
    }

    public String getLogTypeName() {
        return logTypeName;
    }

    public void setLogTypeName(String logTypeName) {
        this.logTypeName = logTypeName;
    }
}
