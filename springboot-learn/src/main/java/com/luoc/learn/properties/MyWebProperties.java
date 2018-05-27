package com.luoc.learn.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/5/27 16:21
 */
@ConfigurationProperties(prefix = "web")
@PropertySource("classpath:config/web.properties")
@Component
public class MyWebProperties {
    private String author;
    private String version;
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
