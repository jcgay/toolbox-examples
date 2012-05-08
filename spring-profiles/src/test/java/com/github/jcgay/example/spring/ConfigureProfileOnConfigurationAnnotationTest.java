package com.github.jcgay.example.spring;

import com.github.jcgay.example.spring.configuration.Generic;
import com.github.jcgay.example.spring.configuration.ProfileA;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

public class ConfigureProfileOnConfigurationAnnotationTest {

    private AnnotationConfigApplicationContext context;

    @BeforeMethod
    private void initializeSpringContext() {
        context = new AnnotationConfigApplicationContext();
    }

    @Test
    public void context_should_contains_only_bean_d_when_no_profile_is_activated() {

        context.register(Generic.class, ProfileA.class);
        context.refresh();

        assertNotNull(context.getBean(BeanD.class));

        try {
            context.getBean(BeanA.class);
            fail("BeanA should not be registered since it's only defined in profile a.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }
    }

    @Test
    public void context_should_contains_beans_a_d_when_profile_a_is_activated() {

        context.getEnvironment().setActiveProfiles("a");
        context.register(Generic.class, ProfileA.class);
        context.refresh();

        assertNotNull(context.getBean(BeanA.class));
        assertNotNull(context.getBean(BeanD.class));
    }
}
