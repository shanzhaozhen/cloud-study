package org.shanzhaozhen.eurekaclient.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {

//
//    1. 不能自动创建队列 @RabbitListener(queues = "myQueue")
//    2. 能自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
//    3. 创建Queue、Exchange，且相互绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MqReceiver:{}", message);
    }


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("targetExchange"),
            key = "kami",
            value = @Queue("kamiQueue")
    ))
    public void kamiProcess(String message) {
        log.info("MqReceiver:{}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("targetExchange"),
            key = "boss",
            value = @Queue("bossQueue")
    ))
    public void bossProcess(String message) {
        log.info("MqReceiver:{}", message);
    }

}
