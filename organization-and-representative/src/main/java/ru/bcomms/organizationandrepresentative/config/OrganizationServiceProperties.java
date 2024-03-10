package ru.bcomms.organizationandrepresentative.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "organization.service")
public class OrganizationServiceProperties {
    protected String addressServiceUri;
    protected String documentServiceUri;
}
