package com.wangjie.jdbc.mybatis.genid;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * Created by wangjie on 2018/8/8.
 */
public class UUIdGenId implements GenId<String>{

    @Override
    public String genId(String table, String column) {
        return UUID.randomUUID().toString();
    }
}
