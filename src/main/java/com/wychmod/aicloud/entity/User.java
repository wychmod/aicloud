package com.wychmod.aicloud.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户实体类
 * </p>
 *
 * @author wychmod
 * @since 2024-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空!")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空!")
    private String password;

    /**
     * 头像
     */
    private String photo;

    /**
     * 状态，预留字段
     */
    private Integer state;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 更新时间
     */
    private String updatetime;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 每人每天能使用大模型次数
     */
    private Integer usecount;


}
