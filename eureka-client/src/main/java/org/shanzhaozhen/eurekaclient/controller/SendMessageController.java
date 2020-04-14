package org.shanzhaozhen.eurekaclient.controller;

import org.shanzhaozhen.eurekaclient.message.StreamClient;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

    private final StreamClient streamClient;

    public SendMessageController(StreamClient streamClient) {
        this.streamClient = streamClient;
    }

    @GetMapping("/send-message")
    public void process() {
        streamClient.output().send(MessageBuilder.withPayload("now " + new Date()).build());
    }

}
