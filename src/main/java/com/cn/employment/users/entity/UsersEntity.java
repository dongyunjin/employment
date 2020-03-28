package com.cn.employment.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cn.employment.framework.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author employment
 * @since 2020-03-07
 */
@TableName("users")
public class UsersEntity extends BaseEntity<UsersEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 手机号
     */
    private String phonenum;

    /**
     * 状态 0表示启用 1表示该用户停用
     */
    private Integer state;

    /**
     * 加入时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//入参格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //出参格式化
    private Date joinTime;

    /**
     * 上次登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//入参格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //出参格式化
    private Date lastTime;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    private String sex;
    /**
     * 学历
     */
    private String education;

    /**
     * 毕业院校
     */
    private String school;

    private String major;
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
    private String project;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
            "email=" + email +
            ", username=" + username +
            ", pwd=" + pwd +
            ", phonenum=" + phonenum +
            ", state=" + state +
            ", joinTime=" + joinTime +
            ", lastTime=" + lastTime +
        "}";
    }
}
