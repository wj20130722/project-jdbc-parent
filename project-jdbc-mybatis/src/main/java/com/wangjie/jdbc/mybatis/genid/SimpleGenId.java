package com.wangjie.jdbc.mybatis.genid;

import tk.mybatis.mapper.genid.GenId;

/**
 * Created by wangjie on 2018/8/8.
 */
public class SimpleGenId implements GenId<Long>{

    private Long    time;
    private Integer seq;

    //使用同步方法简单实现Id生成
    @Override
    public synchronized Long genId(String table, String column) {
        long current = System.currentTimeMillis();
        if (time == null || time != current) {
            time = current;
            seq = 1;
        } else if (current == time) {
            seq++;
        }
        return (time << 20) | seq;
    }
}
