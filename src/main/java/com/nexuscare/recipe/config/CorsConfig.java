package com.nexuscare.recipe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a todos os endpoints
                .allowedOriginPatterns("*") // Permite todas as origens
                .allowedMethods("*") // Permite todos os métodos HTTP (GET, POST, etc.)
                .allowedHeaders("*") // Permite todos os headers
                .allowCredentials(true); // Permite cookies/credenciais (opcional)
    }
}
