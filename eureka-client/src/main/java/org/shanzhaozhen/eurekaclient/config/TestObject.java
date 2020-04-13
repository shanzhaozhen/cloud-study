package org.shanzhaozhen.eurekaclient.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Configurable
@ConfigurationProperties("test-object")
@Data
@RefreshScope
public class TestObject {

    private String name;

    private Integer age;

}

