package com.cn.employment.usersRole.entity;

import com.cn.employment.framework.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author employment
 * @since 2020-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UsersRole extends BaseEntity<UsersRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id外键
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 角色id外键
     */
    @TableField("roleId")
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
