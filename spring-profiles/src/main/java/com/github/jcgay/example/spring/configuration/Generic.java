package com.github.jcgay.example.spring.configuration;

import com.github.jcgay.example.spring.BeanD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Generic {

    @Bean
    public BeanD beanD() {
        return new BeanD();
    }
}
