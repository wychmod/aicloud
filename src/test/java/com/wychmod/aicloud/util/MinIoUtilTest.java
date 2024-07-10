package com.wychmod.aicloud.util;

import io.minio.errors.*;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MinIoUtilTest {

    @Resource
    private MinIoUtil minIoUtil;


    @Test
    void upload() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        File file = new File("D:\\download\\苗苗\\DSC_2997.JPG");
        InputStream inputStream = new FileInputStream(file);
        System.out.println(minIoUtil.upload("DSC_2997.JPG",inputStream,"image/JPG"));
    }
}