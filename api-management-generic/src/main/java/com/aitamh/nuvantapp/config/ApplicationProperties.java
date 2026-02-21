package com.aitamh.nuvantapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.application")
public class ApplicationProperties {
    private String name;
    private String version;
}