package com.wangjie.jdbc.mybatis.util;

import com.wangjie.jdbc.mybatis.provider.CustomSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

import java.util.List;

/**
 * 自定义通用接口
 * Created by wangjie on 2018/8/7.
 */
@RegisterMapper
public interface CustomMapper<T> {
    @SelectProvider(
            type = CustomSelectProvider.class,
            method = "dynamicSQL"
    )
    List<T> selectAllByCustom();
}
