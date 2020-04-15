package org.shanzhaozhen.eurekaclient.controller;

import org.shanzhaozhen.eurekaclient.config.TestObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestObject testObject;

    public TestController(TestObject testObject) {
        this.testObject = testObject;
    }

    @GetMapping("/test")
    public Object test() {
        return testObject;
    }

    @GetMapping("/ignore")
    public Object ignore() {
        return "禁用的链接";
    }

}
