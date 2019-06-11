package com.lingyi.app.service.impl;

import com.lingyi.app.bean.User;
import com.lingyi.app.mapper.UserMapper;
import com.lingyi.app.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liu
 * @since 2019-05-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
