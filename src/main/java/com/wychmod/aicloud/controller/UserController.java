package com.wychmod.aicloud.controller;

import cn.hutool.crypto.SecureUtil;
import com.wychmod.aicloud.util.ResponseEntity;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    // 登录 login 方法
    @RequestMapping("/login")
    public ResponseEntity login(String username, String password, String captcha, HttpServletRequest request) {
        // 1.非空判断
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)
                || !StringUtils.hasLength(captcha)) {
            return ResponseEntity.fail("参数有误！");
        }
        // 2.验证图片验证码
        String redisCaptchaKey = "captcha-" + SecureUtil.md5(request.getRemoteAddr());
        String redisCaptcha = (String) redisTemplate.opsForValue().get(redisCaptchaKey);
        if (!StringUtils.hasLength(redisCaptcha) || !redisCaptcha.equalsIgnoreCase(captcha)) {
            return ResponseEntity.fail("输入验证码错误！");
        }
        // 3.验证用户名密码
        if ("admin".equals(username) && "admin".equals(password)) {
            return ResponseEntity.success("登录成功！");
        }
        return ResponseEntity.fail("用户名或密码不正确！");
    }

}
