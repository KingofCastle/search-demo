package com.qixu.es.search.impl;

import com.qixu.es.search.config.SystemConfig;
import com.qixu.es.search.constant.SearchDemoConstant;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author castle
 * @date 2018/7/11
 **/
@Service
public class AccountSearchInitEsFactory {
    public static AccountSearchService elasticSearchAccountService(SystemConfig systemConfig){
        TransportClient client;

        String esAddressHostPorts = systemConfig.getEsAddressHostPorts();
        String clusterName = systemConfig.getClusterName();
        String indexName = systemConfig.getIndexName();
        String xpackSecurityUserValue = null;
        if (StringUtils.isNotBlank(systemConfig.getEsUserName()) && StringUtils.isNotBlank(systemConfig.getEsPassword())){
            xpackSecurityUserValue = systemConfig.getEsUserName() + ":" + systemConfig.getEsPassword();
        }

        if (null == esAddressHostPorts || esAddressHostPorts.length() < 1) {
            throw new RuntimeException("esAddressHostPorts can not be empty.");
        }
        if (null == clusterName || clusterName.length() == 0) {
            throw new RuntimeException("clusterName is empty.");
        }

        if (null == indexName || indexName.length() == 0) {
            throw new RuntimeException("indexName is empty.");
        }

        try {
            Settings.Builder builder = Settings.builder()
                    .put(SearchDemoConstant.CLUSTER_NAME, clusterName)
                    .put(SearchDemoConstant.CLIENT_TRANSPORT_SNIFF, false);
            if (StringUtils.isNotBlank(xpackSecurityUserValue)){
                builder.put(SearchDemoConstant.XPACK_SECURITY_USER, xpackSecurityUserValue);
            }
            Settings settings = builder.build();

            client = new PreBuiltXPackTransportClient(settings);

            String[] addressArray = esAddressHostPorts.split(",");
            for (String esAddressHostPort : addressArray) {
                String[] a = esAddressHostPort.split(":");
                client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(a[0]), Integer.valueOf(a[1])));
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        return null;

    }
}
