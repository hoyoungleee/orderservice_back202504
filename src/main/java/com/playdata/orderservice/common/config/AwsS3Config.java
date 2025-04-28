package com.playdata.orderservice.common.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

//AWS에 연결해서 S3에 관련된 서비스를 실행하는 전용 객체
@Component
@Slf4j
public class AwsS3Config {

    //S3 버킷을 제어하는 객체
    private S3Client s3Client;

    @Value("${spring.clout.aws.credentials.accessKey}")
    private String accessKey;
    @Value("${spring.clout.aws.credentials.secretKey}")
    private String secretKey;
    @Value("${spring.clout.aws.region.static}")
    private String region;
    @Value("${spring.clout.aws.s3.bucket}")
    private String bucketName;

    //S3에서 연결해서 인증을 처리하는 로직
    @PostConstruct //클래스 기반으로 객체가 생성된 이후 1번만 자동으로 실행될 내용이라고 지정
    private void initializeAmazonS3Client(){
        // 엑세스 키와 시크릿 키를 이용해서 계정 인증 받기
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        // 지역 설정 및 인증 정보를 담은 S3Client 객체를 위의 변수에 세팅
        this.s3Client = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

    }
}
