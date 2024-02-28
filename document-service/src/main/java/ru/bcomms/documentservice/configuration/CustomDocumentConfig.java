package ru.bcomms.documentservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3ClientBuilder;

import java.net.URI;

@Configuration
public class CustomDocumentConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    private final AwsCredentials CREDENTIALS = AwsBasicCredentials.create(
            "YCAJEdGhfjXUkWvRP_6yuxham",
            "YCPCi5u-xfSGO-QdW0kemwH0ZjpKQ_4O9nfY9jjX");
    private final Region REGION = Region.of("ru-central1");

    @Bean
    public S3Client s3Client() {
        return S3Client
                .builder()
                .httpClientBuilder(ApacheHttpClient.builder())
                .region(REGION)
                .credentialsProvider(StaticCredentialsProvider.create(CREDENTIALS))
                .endpointOverride(URI.create("https://storage.yandexcloud.net"))
                .build();
    }
//    @Bean
//    public S3Client s3Client() {
//        S3Client client = S3ClientBuilder.
//        S3Client client = S3ClientBuilderS3ClientBuilder.builder()
//                .region(region)
//                .credentialsProvider(StaticCredentialsProvider.create(credentials))
//                .endpointOverride(URI.create("https://storage.yandexcloud.net"));
//        return client.build();
//    }
}
