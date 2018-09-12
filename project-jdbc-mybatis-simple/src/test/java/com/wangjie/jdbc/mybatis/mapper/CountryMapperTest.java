package com.wangjie.jdbc.mybatis.mapper;

import com.wangjie.jdbc.mybatis.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by wangjie on 2018/9/3.
 */
public class CountryMapperTest extends BaseMapperTest{


    @Test
    public void selectAllTest(){
        SqlSession sqlSession = getSqlSession();
        try{
            //可以包含命名空间写全也支持简写 当方法名冲突的时候需要加上命名空间
            List<Country> list = sqlSession.selectList("com.wangjie.jdbc.mybatis.mapper.CountryMapper.selectAll");
            list.forEach(System.out::println);

        } finally {
            sqlSession.close();
        }

    }





}
