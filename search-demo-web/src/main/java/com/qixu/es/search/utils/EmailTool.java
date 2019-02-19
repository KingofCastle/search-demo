package com.qixu.es.search.utils;

import com.qixu.es.search.api.response.SearchLogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @date 2018/11/06
 */
@Component
public class EmailTool {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMail(List<SearchLogModel> searchLogModels) {
        searchLogModels.stream().forEach(searchLogModel ->
                sendEmail(searchLogModel)
        );
    }

    private void sendEmail(SearchLogModel searchLogModel) {
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("cloudpos@mi-ya.com.cn");
            helper.setTo("jinxin@mi-ya.com.cn");
            StringBuffer subject = new StringBuffer();
            subject.append("日志ERROR告警：【").append(searchLogModel.getBeat().getName()).append("】，服务名：【").append(searchLogModel.getTags().get(0)).append("】");
            helper.setSubject(subject.toString());

            StringBuffer sb = new StringBuffer();
            sb.append("<h3>日志ERROR告警！</h3>")
                    .append("主机名：").append("<p style='color:#F00'>").append(searchLogModel.getBeat().getHostName()).append("</p>")
                    .append("时间：").append("<p style='color:#F00'>").append(new Date(searchLogModel.getTimestamp().getTime())).append("</p>")
                    .append("ERROR信息：").append("<p style='color:#F00'>").append(searchLogModel.getMessage()).append("</p>");
            helper.setText(sb.toString(), true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}