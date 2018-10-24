package com.qixu.es.search;

import com.qixu.es.search.config.SystemConfig;
import com.qixu.es.search.impl.AccountSearchInitEsFactory;
import com.qixu.es.search.impl.AccountSearchService;
import com.qixu.es.search.impl.GoodsSearchService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author castle
 * @date 2018/7/9
 **/
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class SearchDemoApplication {
    @Autowired
    private SystemConfig systemConfig;

    public static void main(String[] args) {
        SpringApplication.run(SearchDemoApplication.class);
    }

    @Bean
    public AccountSearchService accountSearchService() {
        return AccountSearchInitEsFactory.elasticSearchAccountService(systemConfig);
    }

    @Bean
    public GoodsSearchService goodsSearchService() {
        return AccountSearchInitEsFactory.elasticSearchGoodsService(systemConfig);
    }
    @Bean
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(systemConfig.getDataSourceUrl());
        ds.setUsername(systemConfig.getDataSourceUserName());
        ds.setPassword(systemConfig.getDataSourcePassword());

        ds.setTestWhileIdle(true);
        ds.setTestOnBorrow(true);
        ds.setTestOnReturn(true);
        ds.setValidationQuery("SELECT 1");

        return ds;
    }
}
