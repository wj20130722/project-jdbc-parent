package com.wangjie.jdbc.mybatis.provider;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.List;

/**
 * Created by wangjie on 2018/8/7.
 */
public class CustomSelectProvider extends MapperTemplate {

    public CustomSelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String selectAllByCustom(MappedStatement ms){
        final Class<?> entityClass = getEntityClass(ms);
        //修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        //TODO 修改拼接sql 完成自定义的功能
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }

}
