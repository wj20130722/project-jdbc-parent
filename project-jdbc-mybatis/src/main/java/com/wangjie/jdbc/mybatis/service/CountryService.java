package com.wangjie.jdbc.mybatis.service;

import com.wangjie.jdbc.mybatis.domain.Country;

import java.util.List;

/**
 * Created by wangjie on 2018/8/7.
 */
public interface CountryService {

    public Country selectByName(String countryName);

    public List<Country> getAll();

    public List<Country> getAllByPage(Country country);
}
