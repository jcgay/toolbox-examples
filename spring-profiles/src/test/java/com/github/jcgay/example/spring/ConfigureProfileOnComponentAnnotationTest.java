package com.github.jcgay.example.spring;

import com.github.jcgay.example.spring.configuration.Generic;
import com.github.jcgay.example.spring.configuration.MultipleProfiles;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

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

        assertNotNull(context.getBean(BeanD.class));

        try {
            context.getBean(BeanE.class);
            fail("BeanE should not be registered since it's only defined in profile b.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }
    }

    @Test
    public void context_should_contains_beans_d_e_when_profile_e_is_activated() {

        context.getEnvironment().setActiveProfiles("e");
        context.register(Generic.class, BeanE.class);
        context.refresh();

        assertNotNull(context.getBean(BeanD.class));
        assertNotNull(context.getBean(BeanE.class));
    }
}
