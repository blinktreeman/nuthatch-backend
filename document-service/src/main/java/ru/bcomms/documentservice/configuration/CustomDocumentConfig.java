package ru.bcomms.documentservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
public class CustomDocumentConfig {

    @Autowired
    private DocumentServiceProperties documentServiceProperties;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public S3Client s3Client() {
        String ACCESS_KEY_ID = documentServiceProperties.getAwsAccessKeyId();
        String SECRET_ACCESS_KEY = documentServiceProperties.getAwsSecretAccessKey();
        String REGION = documentServiceProperties.getAwsRegion();
        String AWS_URI = documentServiceProperties.getAwsUri();

        AwsCredentials CREDENTIALS = AwsBasicCredentials.create(
                ACCESS_KEY_ID,
                SECRET_ACCESS_KEY);
        final Region region = Region.of(REGION);

        return S3Client
                .builder()
                .httpClientBuilder(ApacheHttpClient.builder())
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(CREDENTIALS))
                .endpointOverride(URI.create(AWS_URI))
                .build();
    }
}
