package com.wychmod.aicloud.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.crypto.SecureUtil;
import com.wychmod.aicloud.util.MinIoUtil;
import com.wychmod.aicloud.util.ResponseEntity;
import io.minio.errors.*;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Resource
    private MinIoUtil minIoUtil;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 生成验证码
     */
    @RequestMapping("/create")
    public ResponseEntity createCaptcha(HttpServletRequest request) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String url = "";
        // 定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(120, 40);
        String fileName = "captcha-" + SecureUtil.md5(request.getRemoteAddr());
        try (InputStream inputStream = new ByteArrayInputStream(lineCaptcha.getImageBytes())) {
            url = minIoUtil.upload(fileName, inputStream, "image/png");
             String code = lineCaptcha.getCode(); // 正确的验证码
             redisTemplate.opsForValue().set(fileName, code,60, TimeUnit.SECONDS); // 验证码存储到 Redis
        }
        return ResponseEntity.success(url);
    }

}
