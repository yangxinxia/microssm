package org.boluo.utils.rpc.syslog;


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 拦截service的日志
 * @author yangxinxia 2019-01-14
 *
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)//生命周期运行时保存
@Target({ElementType.PARAMETER,ElementType.METHOD})//注解只用于方法
public @interface Servicelog {
	String sysName() default "";//系统名
	
    String module() default "";//模块名
    
}

