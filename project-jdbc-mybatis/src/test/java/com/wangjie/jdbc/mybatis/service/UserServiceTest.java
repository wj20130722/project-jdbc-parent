package com.wangjie.jdbc.mybatis.service;

import com.wangjie.jdbc.mybatis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by wangjie on 2018/8/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectTest(){
        User user = userService.findUserByName("hello");
        System.out.println(user);
    }

    @Test
    public void selectLikeTest(){
        List<User> users = userService.findUsersByLike("hel");
        users.stream().forEach(System.out::println);
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setName("小明");
        user.setVersion(1);
        user.setDepartmentId(1);
        user.setCreateTime(new Date());
        userService.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void updateTest(){
        //获取当前用户版本号
        User user = userService.findUserByName("小明");
        //业务处理....
        user.setName("小明11");
        //根据当前版本号更新用户信息
        userService.saveUser(user);
        System.out.println(user);
    }





}
