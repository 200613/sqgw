package com.example.demo.hcontroller;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传配置类
 *
 * @Author mashanghaoyun
 * @Date 2020/11/11 01:34
 * @Version 1.0
 **/
@Configuration
public class FileUploadConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        DataSize dataSize = DataSize.ofBytes(10485760L);
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(dataSize);
//设置允许上传文件的最大size
        factory.setMaxRequestSize(dataSize);
        return factory.createMultipartConfig();
    }

}
