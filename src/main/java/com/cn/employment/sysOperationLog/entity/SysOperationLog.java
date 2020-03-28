package com.cn.employment.sysOperationLog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import com.cn.employment.framework.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统操作日志
 * </p>
 *
 * @author employment
 * @since 2020-03-28
 */
public class SysOperationLog extends BaseEntity<SysOperationLog> {

    private static final long serialVersionUID = 1L;

    // 实体编号（唯一标识）
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String logType;

    private String logName;

    private Integer userId;

    private String className;

    private String method;

    private String succeed;

    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//入参格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //出参格式化
    private Date createDate;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }
    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getSucceed() {
        return succeed;
    }

    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "SysOperationLog{" +
            "logType=" + logType +
            ", logName=" + logName +
            ", userId=" + userId +
            ", className=" + className +
            ", method=" + method +
            ", succeed=" + succeed +
            ", message=" + message +
            ", createDate=" + createDate +
        "}";
    }
}
