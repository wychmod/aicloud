package com.wychmod.aicloud.entity.dto;

import com.wychmod.aicloud.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserDTO extends User implements Serializable {
    @Serial
    private static final long serialVersionUID = -3283328906330311223L;
    @NotBlank(message = "验证码不能为空！")
    private String captcha;
}
