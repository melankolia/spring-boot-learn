package com.ageng.belajar_springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// Inject Value from application.properties
@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
    private String name;
    private String currency;

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
