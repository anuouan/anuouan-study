package com.anuouan.service.impl;

import com.anuouan.entity.User;
import com.anuouan.mapper.UserMapper;
import com.anuouan.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anuouan
 * @since 2024-12-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
