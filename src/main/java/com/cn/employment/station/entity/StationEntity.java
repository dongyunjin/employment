package com.cn.employment.station.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cn.employment.framework.base.entity.BaseEntity;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 岗位表
 * </p>
 *
 * @author employment
 * @since 2020-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("station")
public class StationEntity extends BaseEntity<StationEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程名
     */
    private String name;

    /**
     * 课程描述
     */
    private String description;

    /**
     * 课程资料
     */
    private String url;

    /**
     * 资料类型
     */
    private String type;

    /**
     * 父级id
     */
    private Integer pid;

    private String size;

    private String filetype;

    private String caption;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
