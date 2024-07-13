package com.wychmod.aicloud.service.impl;

import com.wychmod.aicloud.entity.User;
import com.wychmod.aicloud.mapper.UserMapper;
import com.wychmod.aicloud.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wychmod
 * @since 2024-07-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
