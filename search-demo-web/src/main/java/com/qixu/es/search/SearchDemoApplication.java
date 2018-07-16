package com.qixu.es.search;

import com.qixu.es.search.config.SystemConfig;
import com.qixu.es.search.impl.AccountSearchInitEsFactory;
import com.qixu.es.search.impl.AccountSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    @Primary
    public AccountSearchService accountSearchService(){
        return AccountSearchInitEsFactory.elasticSearchAccountService(systemConfig);
    }
}
