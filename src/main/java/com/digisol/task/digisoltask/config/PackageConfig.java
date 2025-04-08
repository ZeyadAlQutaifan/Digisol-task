package com.digisol.task.digisoltask.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "package")
@Component
@Getter
@Setter
public class PackageConfig {
    String baseUrl;
    String scenario;
    String uid;
    String productType;
    String clientId;
    String page;
}