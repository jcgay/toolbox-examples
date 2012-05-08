package com.github.jcgay.example.spring.configuration;

import com.github.jcgay.example.spring.BeanA;
import com.github.jcgay.example.spring.annotation.CustomProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@CustomProfile
public class CustomAnnotation {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }
}
