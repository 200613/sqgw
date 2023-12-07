package com.example.demo.hcontroller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * 资源映射路径
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path1 = System.getProperty("user.dir");//项目根目录
        File file2 = new File(path1);
        String parent = file2.getParent();//项目所在目录
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+path1+"\\src\\main\\resources\\static\\images\\");
    }
}
