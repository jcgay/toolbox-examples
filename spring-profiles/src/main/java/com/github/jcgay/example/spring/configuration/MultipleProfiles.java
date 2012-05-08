package com.github.jcgay.example.spring.configuration;

import com.github.jcgay.example.spring.BeanA;
import com.github.jcgay.example.spring.BeanB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"a", "b"})
public class MultipleProfiles {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    public BeanB beanB() {
        return new BeanB();
    }
}
