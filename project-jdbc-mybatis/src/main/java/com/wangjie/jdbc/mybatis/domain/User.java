package com.wangjie.jdbc.mybatis.domain;

import lombok.ToString;
import tk.mybatis.mapper.annotation.*;

import java.util.Date;
import javax.persistence.*;

@ToString(callSuper = true)
@Table(name = "user3")
public class User extends BaseEntity {

    /**
     * 名称
     */
    private String name;

    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @tk.mybatis.mapper.annotation.Version
    private Integer version;


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return department_id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}