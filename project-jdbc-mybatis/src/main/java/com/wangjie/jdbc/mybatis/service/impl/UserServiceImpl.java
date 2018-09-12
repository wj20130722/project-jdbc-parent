package com.wangjie.jdbc.mybatis.service.impl;

import com.wangjie.jdbc.mybatis.dao.UserMapper;
import com.wangjie.jdbc.mybatis.domain.User;
import com.wangjie.jdbc.mybatis.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.util.List;

/**
 * Created by wangjie on 2018/8/6.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public User findUserByName(String username) {
        //Mapper 提供的通用Example
        //一般方式
       /* Example example = new Example(User.class);
        //example.setForUpdate(true);
        example.createCriteria().andEqualTo("name",username);
        example.and().andEqualTo("id",1);
        example.setDistinct(true);*/

       //Builder方式
       /* Example example = Example.builder(User.class)
                .select("id","name","departmentId")
                .where(Sqls.custom().andEqualTo("name",username).andEqualTo("id",1))
                .forUpdate()
                .build();*/

//        return userMapper.selectOneByExample(example);

        //java 8 weekend方式
       /* User user = userMapper.selectOneByExample(new Example.Builder(User.class)
                .where(WeekendSqls.<User>custom().andEqualTo(User::getName, username)
                        .andEqualTo(User::getId, 1))
                .build());*/

        Weekend<User> weekend = Weekend.of(User.class);
        WeekendCriteria<User, Object> criteria = weekend.weekendCriteria();
        criteria.andEqualTo(User::getName,username)/*.andEqualTo("id",1)*/;
        User user = userMapper.selectOneByExample(weekend);

        return user;
    }

    @Override
    public List<User> findUsersByLike(String keyword){
        Example example = new Example(User.class);
        example.selectProperties("id","name","departmentId");//设置查询属性--Bean的属性
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(keyword)){
            criteria.andLike("name","%"+keyword+"%");
        }
        example.orderBy("name").desc().orderBy("id").asc();//设置排序
        return userMapper.selectByExample(example);
    }

    @Override
    public void saveUser(User user) {
        //针对于主键自动生成的 插入之后返回的对象里面包含id
        if(user.getId()!=null){
            userMapper.updateByPrimaryKeyWithVersion(user);//乐观锁控制重复更新问题
        }
        else{
//            userMapper.insertUseGeneratedKeys(user); //使用jdbc的getGeneratedKey方式获取主键
            //使用注解配置的jdbc after方式获取自增主键
            userMapper.insert(user);
        }
    }

}
