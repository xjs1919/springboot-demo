package com.github.xjs.service.swagger;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年11月28日 上午10:59:41<br/>
 */
@Configuration
public class SwaggerImportSelector implements ImportSelector, EnvironmentAware{
	
	private boolean isProduct;
	
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		if(!isProduct) {
			return new String[] {Swagger2DocumentationConfiguration.class.getName()};
		}else {
			return new String[0];
		}
	}

	@Override
	public void setEnvironment(Environment env) {
		this.isProduct = "product".equals(env.getProperty("spring.profiles.active"));
	}

}
