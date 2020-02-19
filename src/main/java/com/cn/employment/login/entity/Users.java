package com.cn.employment.login.entity;

import com.cn.employment.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author employment
 * @since 2020-02-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Users extends BaseEntity<Users> {

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
    private LocalDateTime joinTime;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
