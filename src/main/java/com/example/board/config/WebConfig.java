package com.example.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String[] assetLocations = { "classpath:/static/assets/" };
        registry.addResourceHandler("/assets/**").addResourceLocations(assetLocations);
        registry.addResourceHandler("/board/assets/**").addResourceLocations(assetLocations);
        registry.addResourceHandler("/board/update/assets/**").addResourceLocations(assetLocations);

        String[] htmlLocations = {"classpath:/static/html/"};
        registry.addResourceHandler("/html/**").addResourceLocations(htmlLocations);
    }
}
