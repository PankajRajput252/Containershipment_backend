package com.sgmprime.service.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

@Service
public class ImageUploadService {
    @Value("${aws.s3.bucket-name}")
    private String bucketName;
    private final S3Client s3Client;
    private final S3Presigner s3Presigner;

    public ImageUploadService(S3Client s3Client, S3Presigner s3Presigner) {
        this.s3Client = s3Client;
        this.s3Presigner = s3Presigner;
    }


    public String uploadFile(MultipartFile file) throws IOException {
        String fileKey = UUID.randomUUID() + "_" + file.getOriginalFilename();


        PutObjectRequest putRequest = (PutObjectRequest) PutObjectRequest.builder().bucket(this.bucketName).key(fileKey).contentType(file.getContentType()).build();

        this.s3Client.putObject(putRequest, RequestBody.fromBytes(file.getBytes()));


        return fileKey;
    }


    public String generatePresignedUrl(String fileKey) {
        GetObjectRequest getObjectRequest = (GetObjectRequest) GetObjectRequest.builder().bucket(this.bucketName).key(fileKey).build();


        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder().signatureDuration(Duration.ofMinutes(15L)).getObjectRequest(getObjectRequest).build();

        return this.s3Presigner.presignGetObject(presignRequest).url().toString();
    }
}
