package com.interest.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "interest.other")
@Configuration
public class OtherProperties {

    /**
     * 文件上传临时路径
     */
    private String temporaryPath;

    public String getTemporaryPath() {
        return temporaryPath;
    }

    public void setTemporaryPath(String temporaryPath) {
        this.temporaryPath = temporaryPath;
    }
}
