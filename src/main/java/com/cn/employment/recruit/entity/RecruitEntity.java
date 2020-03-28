package com.cn.employment.recruit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cn.employment.framework.base.entity.BaseEntity;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 招聘信息
 * </p>
 *
 * @author employment
 * @since 2020-03-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("recruit")
public class RecruitEntity extends BaseEntity<RecruitEntity> {

    private static final long serialVersionUID = 1L;

    private String company;

    private String job;

    private String salary;

    /**
     * 位置
     */
    private String position;

    /**
     * 工作年限
     */
    private String year;

    /**
     * 学历
     */
    private String education;

    /**
     * 招聘详情
     */
    private String detail;

    /**
     * 岗位id
     */
    private Integer pid;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
