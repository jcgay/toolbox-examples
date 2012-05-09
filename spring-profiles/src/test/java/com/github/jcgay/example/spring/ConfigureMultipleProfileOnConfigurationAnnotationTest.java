package com.github.jcgay.example.spring;

import com.github.jcgay.example.spring.configuration.Generic;
import com.github.jcgay.example.spring.configuration.MultipleProfiles;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.jcgay.example.matcher.ApplicationContextAssert.assertThat;

public class ConfigureMultipleProfileOnConfigurationAnnotationTest {

    private AnnotationConfigApplicationContext context;

    @BeforeMethod
    private void initializeSpringContext() {
        context = new AnnotationConfigApplicationContext();
    }

    @Test
    public void context_should_contains_only_bean_d_when_no_profile_is_activated() {

        context.register(Generic.class, MultipleProfiles.class);
        context.refresh();

        assertThat(context).containsBean(BeanD.class)
                           .notContainsBean(BeanA.class);
    }

    @Test
    public void context_should_contains_beans_a_b_d_when_profile_a_is_activated() {

        context.getEnvironment().setActiveProfiles("a");
        context.register(Generic.class, MultipleProfiles.class);
        context.refresh();

        assertThat(context).containsBean(BeanA.class)
                           .containsBean(BeanB.class)
                           .containsBean(BeanD.class);
    }
}
