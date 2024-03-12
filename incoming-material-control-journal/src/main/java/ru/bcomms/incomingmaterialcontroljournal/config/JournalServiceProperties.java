package ru.bcomms.incomingmaterialcontroljournal.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "journal.service")
public class JournalServiceProperties {
    protected String organizationServiceUri;
    protected String documentServiceUri;
    protected String buildingObjectServiceUri;
}
