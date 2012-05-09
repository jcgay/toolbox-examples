package com.github.jcgay.example.spring;

import com.github.jcgay.example.spring.configuration.Generic;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.jcgay.example.matcher.ApplicationContextAssert.assertThat;

public class ConfigureProfileOnComponentAnnotationTest {

    private AnnotationConfigApplicationContext context;

    @BeforeMethod
    private void initializeSpringContext() {
        context = new AnnotationConfigApplicationContext();
    }

    @Test
    public void context_should_contains_only_bean_d_when_no_profile_is_activated() {

        context.register(Generic.class, BeanE.class);
        context.refresh();

        assertThat(context).containsBean(BeanD.class)
                           .notContainsBean(BeanE.class);
    }

    @Test
    public void context_should_contains_beans_d_e_when_profile_e_is_activated() {

        context.getEnvironment().setActiveProfiles("e");
        context.register(Generic.class, BeanE.class);
        context.refresh();

        assertThat(context).containsBean(BeanD.class)
                           .containsBean(BeanE.class);
    }
}
