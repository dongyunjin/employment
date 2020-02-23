package com.cn.employment.course.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.cn.employment.base.entity.BaseEntity;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Course extends BaseEntity<Course> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程名
     */
    private String name;

    /**
     * 课程描述
     */
    private String desc;

    /**
     * 课程资料
     */
    private String url;

    /**
     * 资料类型
     */
    private String type;

    private int pid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
