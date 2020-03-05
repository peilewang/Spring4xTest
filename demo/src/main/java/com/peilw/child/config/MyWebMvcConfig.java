
package com.peilw.child.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations ( "classpath:/static/") ;

    }
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/book/**").allowedHeaders("*").allowedMethods("*").maxAge(1800
        ).allowedOrigins("http://localhost/8080");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptorl()).addPathPatterns("/**").excludePathPatterns("/hello");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry){
        viewControllerRegistry.addViewController("/login").setViewName("login");
        viewControllerRegistry.addViewController("/index").setViewName("index");
    }
}

