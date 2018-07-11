package org.onnuri.springboot;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by minah on 2017-01-25.
 */
@SpringBootApplication
@Configuration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

}
