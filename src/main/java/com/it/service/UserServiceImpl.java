package com.it.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.entity.User;
import com.it.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(User user) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",user.getUsername()).eq("password",user.getPassword());
        User user1 = userMapper.selectOne(wrapper);
        return user1;
    }
}
