package ru.bcomms.address.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "dadata.client")
public class DadataClientProperties {

    protected String baseUrl;
    protected String token;
    protected String secretKey;

}
