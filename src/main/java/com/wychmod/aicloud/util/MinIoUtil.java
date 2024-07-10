package com.wychmod.aicloud.util;

import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MinIoUtil {
    @Resource
    private MinioClient minioClient;
    @Value("${minio.bucket}")
    private String bucketName;

    /**
     * 上传文件
     * @param fileName
     * @param inputStream
     * @param contentType
     * @return
     */
    public String upload(String fileName, InputStream inputStream, String contentType) throws ServerException, IOException, NoSuchAlgorithmException, InvalidKeyException, InternalException, InsufficientDataException, ErrorResponseException, InvalidResponseException, XmlParserException {
        boolean isExist = minioClient.bucketExists(
                BucketExistsArgs.builder().bucket(bucketName).build());
        if (!isExist) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
        // 文件上传
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .stream(inputStream, -1, 10485760)
                .contentType(contentType)
                .build());
        return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .method(Method.GET)
                .build());
    }
}
