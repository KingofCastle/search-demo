package com.qixu.es.search.mq;

import com.alibaba.fastjson.JSONObject;
import com.qixu.es.search.api.response.SearchLogModel;
import com.qixu.es.search.utils.EmailTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author castle
 * @date 2018/11/6
 **/
@Component
public class MessageService {
    private final static Logger logger = LoggerFactory.getLogger(MessageService.class);
    public static final String QUEUE = "search_log";
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private EmailTool emailTool;

    public void pushMessage(Object obj) {
        rabbitTemplate.convertAndSend(QUEUE, JSONObject.toJSONString(obj));
    }

//    @RabbitListener(queues = MessageService.QUEUE)
    public void onMessage(String jsonString) {
        try {
            List<SearchLogModel> searchLogModels = JSONObject.parseArray(jsonString, SearchLogModel.class);
            emailTool.sendSimpleMail(searchLogModels);
        } catch (Exception e) {
            logger.error("process fail,e:{}.", e.toString(), e);
        }

    }
}
