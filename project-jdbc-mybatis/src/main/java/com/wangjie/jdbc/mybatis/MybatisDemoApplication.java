package com.wangjie.jdbc.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *
 * @author wangjie
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.wangjie.jdbc.mybatis.dao"})
@EnableTransactionManagement
public class MybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class,args);
    }

}
