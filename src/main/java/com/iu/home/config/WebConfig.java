package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.home.interceptors.StudyInterceptor;
import com.iu.home.interceptors.TestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration  // ***-context.xml
@Slf4j
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired  //IOC(Inversion Of Control)
	private TestInterceptor testInterceptor;
	
	@Autowired
	private StudyInterceptor studyInterceptor;
	
	@Value("${app.upload.base}")//spEl
	private String filePath;
	
	@Value("${app.url.path}")
	private String urlPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		log.info("=====================================");
		log.info("filePath {} ", filePath );
		log.info("urlPath {} ", urlPath);
		log.info("=====================================");
		
		//method 체인
//		registry.addInterceptor(testInterceptor)
//			//Interceptor를 적용할 URL등록
//				.addPathPattens("/qna/**")
//			 //제외할 URL등록
//				.excludePathPatterns("/qna/detail");
//		
//		//추가 Interceptor 등록
//		registry.addInterceptor(studyInterceptor)
//				.addPathPatterns("/qna/**");
				
	}

}
