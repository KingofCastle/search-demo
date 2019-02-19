package com.qixu.es.search;

import com.qixu.es.search.mq.MessageService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


/**
 * @author castle
 * @date
 */
@Configuration
@EnableRabbit
@Service
public class RabbitmqSpringConfig {

    @Bean
    public Queue callbackReqQueue() {
        return new Queue(MessageService.QUEUE);
    }
}
