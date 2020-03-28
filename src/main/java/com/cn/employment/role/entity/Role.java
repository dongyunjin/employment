package com.cn.employment.role.entity;

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
public class Role extends BaseEntity<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名
     */
    @TableField("roleName")
    private String roleName;

    /**
     * 角色描述
     */
    @TableField("roleDesc")
    private String roleDesc;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
