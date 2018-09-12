package com.wangjie.jdbc.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.wangjie.jdbc.mybatis.dao.CountryMapper;
import com.wangjie.jdbc.mybatis.domain.Country;
import com.wangjie.jdbc.mybatis.domain.User;
import com.wangjie.jdbc.mybatis.service.CountryService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

/**
 * Created by wangjie on 2018/8/7.
 */
@Service
@Transactional(readOnly = true)
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public Country selectByName(String countryName) {
        return countryMapper.selectByCountryName(countryName);
    }

    @Override
    public List<Country> getAll() {
        Weekend<Country> weekend = Weekend.of(Country.class);
        WeekendCriteria<Country, Object> criteria = weekend.weekendCriteria();
        criteria.andEqualTo(Country::getCountryname,"Angola").andEqualTo("id",1);
        List<Country> countries = countryMapper.selectByExample(weekend);
        return countries;
    }

    @Override
    public List<Country> getAllByPage(Country country) {

        //基于RowBounds 的内存分页
        //int offset = (country.getPage()-1)*country.getRows();
        RowBounds rowBounds = new RowBounds(country.getPage(),country.getRows());
        List<Country> countries = countryMapper.selectByRowBounds(country, rowBounds);

       //物理分页
       /* PageHelper.startPage(country.getPage(),country.getRows(),"id asc");
        List<Country> countries = countryMapper.select(country);*/
        return countries;
    }
}
