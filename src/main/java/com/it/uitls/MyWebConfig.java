package com.it.uitls;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置浏览器能够访问本地路径的图片
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/images/");
    }
}
