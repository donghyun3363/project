package com.kt.caike.common.config;

import com.kt.caike.common.interceptor.WebInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport { /* 정적 자원을 제공하는 클래스 */

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebInterceptor())
                .addPathPatterns("/*") // 해당 경로에 접근하기 전에 인터셉터가 가로챔
                .excludePathPatterns("/tests"); // 해당 경로는 인터셉터가 가로채지 않음
    }
}
