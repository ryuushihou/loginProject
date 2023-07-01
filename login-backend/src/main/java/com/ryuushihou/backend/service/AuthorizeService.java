package com.ryuushihou.backend.service;

import com.ryuushihou.backend.entity.UserBean;
import com.ryuushihou.backend.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService implements UserDetailsService {

    public UserMapper userMapper;

    public AuthorizeService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null){
            throw new UsernameNotFoundException("用户名不能为空!!!");
        }
        UserBean userBean = userMapper.getUserByUsername(username);
        if(userBean == null){
            throw new UsernameNotFoundException("用户名或密码错误!!!");
        }

        return User.withUsername(userBean.getUsername())
                .password(userBean.getPassword())
                .roles("user")
                .build();
    }
}
