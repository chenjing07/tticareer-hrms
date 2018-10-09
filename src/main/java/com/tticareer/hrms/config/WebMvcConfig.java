package com.tticareer.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	/*
	@Value("${cbs.imagesPath}")
	private String mImagesPath;
	*/

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.tticareer")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo info = new ApiInfo("tticareer",
				"TTI创科集团人力资源管理系统", "0.01",
				"www.tticareer.com", "2565463364@qq.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html");
		return info;
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	        
		/*
		if(mImagesPath.equals("") || mImagesPath.equals("${cbs.imagesPath}")){
			String imagesPath = WebMvcConfig.class.getClassLoader().getResource("").getPath();
			if(imagesPath.indexOf(".jar")>0){
				imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
			}else if(imagesPath.indexOf("classes")>0){
				imagesPath = "file:"+imagesPath.substring(0, imagesPath.indexOf("classes"));
			}
			imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/"))+"/images/";
			mImagesPath = imagesPath;
		}
		LoggerFactory.getLogger(WebMvcConfig.class).info("imagesPath="+mImagesPath);
		registry.addResourceHandler("/images/**").addResourceLocations(mImagesPath);
		*/
	}

}
