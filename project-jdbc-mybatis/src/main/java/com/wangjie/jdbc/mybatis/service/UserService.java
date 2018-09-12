package com.wangjie.jdbc.mybatis.service;

import com.wangjie.jdbc.mybatis.domain.User;

import java.util.List;

/**
 * Created by wangjie on 2018/8/6.
 */
public interface UserService {
    public User findUserByName(String username);

    public List<User> findUsersByLike(String keyword);

    public void saveUser(User user);
}
