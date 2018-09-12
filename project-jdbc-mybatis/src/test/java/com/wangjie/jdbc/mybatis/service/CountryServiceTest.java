package com.wangjie.jdbc.mybatis.service;

import com.wangjie.jdbc.mybatis.domain.Country;
import com.wangjie.jdbc.mybatis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wangjie on 2018/8/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void selectAllTest(){
        List<Country> countries = countryService.getAll();
        System.out.println(countries);
        countries.forEach(System.out::println);
    }

    @Test
    public void selectByPageTest(){
        Country country = new Country();
//        country.setCountryname("Angola");
        country.setPage(2);
        List<Country> countries = countryService.getAllByPage(country);
        countries.forEach(System.out::println);
    }

    @Test
    public void selectByNameTest(){
        Country country = countryService.selectByName("Angola");
        System.out.println(country);
    }







}
