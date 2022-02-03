package com.kt.caike.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport { /* 정적 자원을 제공하는 클래스 */

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/static/", "classpath:/public/",
            "classpath:/resource/"

    };

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Get 요청에 대해 추가 작업 없이 뷰만 리턴 해주는 경우에 사용하면 좋음
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // swagger-ui 접속 시 리소스 Not found 문제로 인한 리소스 위치 설정
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");

    }
}
