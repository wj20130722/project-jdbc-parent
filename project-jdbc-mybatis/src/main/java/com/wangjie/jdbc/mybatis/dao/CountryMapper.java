package com.wangjie.jdbc.mybatis.dao;

import com.wangjie.jdbc.mybatis.domain.Country;
import com.wangjie.jdbc.mybatis.util.MyMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface CountryMapper extends MyMapper<Country> {

    /**
     * 基于注解方式增加自定义的方法
     * @param countryname
     * @return
     */
    @Select("select * from country where countryname = #{countryname}")
    /*@Results(id = "countryResult", value = {
            @Result(property = "id", column = "id",jdbcType = JdbcType.INTEGER,id = true),
            @Result(property = "countryname", column = "countryname",jdbcType = JdbcType.VARCHAR),
            @Result(property = "countrycode", column = "countrycode",jdbcType = JdbcType.VARCHAR)
    })*/
    Country selectByCountryName(String countryname);





}