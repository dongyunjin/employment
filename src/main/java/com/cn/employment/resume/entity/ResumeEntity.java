package com.cn.employment.resume.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.cn.employment.base.entity.BaseEntity;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 简历
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("resume")
public class ResumeEntity extends BaseEntity<ResumeEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 学历
     */
    private String education;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 个人优势
     */
    private String advantage;

    /**
     * 求职地点
     */
    private String place;

    /**
     * 期望薪资
     */
    private String money;

    /**
     * 工作经历
     */
    private String work;

    /**
     * 项目经理
     */
    private String poject;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
