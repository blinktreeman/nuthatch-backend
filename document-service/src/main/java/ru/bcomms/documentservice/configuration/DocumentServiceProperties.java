package ru.bcomms.documentservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "document.service")
public class DocumentServiceProperties {
    private String awsAccessKeyId;
    private String awsSecretAccessKey;
    private String awsRegion;
    private String awsUri;
    private String awsBucket;
}