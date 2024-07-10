package com.wychmod.aicloud.controller;

import com.wychmod.aicloud.util.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    // 登录login方法
    @RequestMapping("/login")
    public ResponseEntity login(String username, String password) {
        // 非空判断
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return ResponseEntity.fail("用户名或密码不能为空!");
        }
        if ("admin".equals(username) && "123456".equals(password)) {
            return ResponseEntity.success("登录成功!");
        }
        return ResponseEntity.fail("用户名或密码错误!");
    }
}
