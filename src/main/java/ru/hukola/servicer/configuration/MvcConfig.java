package ru.hukola.servicer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Babin Nikolay
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/orders").setViewName("orders/orders");
        registry.addViewController("/clients").setViewName("clients/clients");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
    }
}
