package com.wangjie.jdbc.mybatis.mapper;

import com.wangjie.jdbc.mybatis.MyMapperProxy;
import com.wangjie.jdbc.mybatis.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by wangjie on 2018/9/4.
 */
public class MapperProxyTest extends BaseMapperTest{

    @Test
    public void mapperTest(){
        //使用jdk代理方式实现
        SqlSession sqlSession = getSqlSession();
        MyMapperProxy<UserMapper> userMapperMyMapperProxy = new MyMapperProxy<>(UserMapper.class,sqlSession);
        //MapperProxyTest.class.getClassLoader()
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{UserMapper.class},userMapperMyMapperProxy);
        List<SysUser> list = userMapper.selectAll();
        list.forEach(System.out::println);

    }

}
