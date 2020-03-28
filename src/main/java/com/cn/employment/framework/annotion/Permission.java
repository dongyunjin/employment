package com.cn.employment.framework.annotion;

import java.lang.annotation.*;

/**
 * 权限注解 用于检查权限 规定访问权限
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Permission {
    String[] value() default {};
    String[] roles() default {};
}
