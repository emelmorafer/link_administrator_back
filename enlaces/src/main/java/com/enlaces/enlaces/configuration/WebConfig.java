package com.enlaces.enlaces.configuration;

import com.enlaces.enlaces.util.Utils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String IMAGES_DIR = Utils.getParentDir(System.getProperty("user.dir")) + "/imagesupload/";
    String frontendUrl = System.getenv("FRONTEND_URL");

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///" + IMAGES_DIR);
    }

    //Le doy permiso al frontendt que acceda al endpoint /uploadLogo
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                if (frontendUrl == null || frontendUrl.isEmpty()) {
                    frontendUrl = "http://localhost:5173"; // Default Value
                }
                registry.addMapping("/**")
                        .allowedOrigins(frontendUrl)
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}