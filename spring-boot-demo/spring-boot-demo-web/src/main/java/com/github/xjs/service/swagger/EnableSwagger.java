package com.github.xjs.service.swagger;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年11月28日 上午10:51:43<br/>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SwaggerImportSelector.class)
public @interface EnableSwagger {
	
}
