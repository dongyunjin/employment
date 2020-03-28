package com.cn.employment.framework.annotion;

import java.lang.annotation.*;

/**
 * 标记需要做业务日志的方法
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface BussinessLog {
    /**
     * 业务的名称,例如:"修改菜单"
     */
    String value() default "";

}
