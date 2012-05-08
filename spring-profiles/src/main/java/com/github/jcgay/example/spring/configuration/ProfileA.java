package com.github.jcgay.example.spring.configuration;

import com.github.jcgay.example.spring.BeanA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("a")
public class ProfileA {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }
}
