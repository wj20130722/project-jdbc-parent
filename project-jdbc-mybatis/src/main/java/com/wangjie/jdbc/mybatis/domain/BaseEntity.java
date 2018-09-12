/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.wangjie.jdbc.mybatis.domain;

import com.wangjie.jdbc.mybatis.genid.SimpleGenId;
import com.wangjie.jdbc.mybatis.genid.UUIdGenId;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.*;

/**
 * 基础信息
 *
 * @author liuzh
 * @since 2016-01-31 21:42
 */
@ToString
public class BaseEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @KeySql(useGeneratedKeys = true)
//    @GeneratedValue(generator = "JDBC")
//    @KeySql(dialect = IdentityDialect.MYSQL) //插入后调用获取自增主键
//    @KeySql(sql = "select SEQ_ID.nextval from dual", order = ORDER.BEFORE) //oracle 主键生成
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_ID.nextval from dual") //oracle 主键生成
//    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()") //使用uuid当做主键 id必须是String类型
//    @KeySql(genId = UUIdGenId.class) //使用自定义的Id生成方式 使用uuid作为主键 对应String
//    @KeySql(genId = SimpleGenId.class) //对应Long
    private String id;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
