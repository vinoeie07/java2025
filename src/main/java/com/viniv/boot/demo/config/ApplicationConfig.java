package com.viniv.boot.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "emp.details")
@Data
@Configuration
public class ApplicationConfig {

    private String company;
    private String branch;

}
