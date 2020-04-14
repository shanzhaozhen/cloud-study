package org.shanzhaozhen.eurekaclient;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class MqSenderTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "abc:" + new Date());
    }

    @Test
    public void kamiSend() {
        amqpTemplate.convertAndSend("targetExchange", "kami", "kami:" + new Date());
    }


}
