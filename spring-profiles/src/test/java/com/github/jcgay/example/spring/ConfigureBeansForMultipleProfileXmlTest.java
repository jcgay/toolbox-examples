package com.github.jcgay.example.spring;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

public class ConfigureBeansForMultipleProfileXmlTest {

    private GenericXmlApplicationContext context;

    @BeforeMethod
    private void initializeTest() {
        context = new GenericXmlApplicationContext();
    }

    @Test
    public void context_should_contains_nothing_when_no_profile_is_activated() {

        loadContext();

        try {
            context.getBean(BeanA.class);
            fail("BeanA should not be registered since it's only defined in profile a.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }

        try {
            context.getBean(BeanB.class);
            fail("BeanB should not be registered since it's only defined in profile b.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }

        try {
            context.getBean(BeanC.class);
            fail("BeanC should not be registered since it's only defined in profile a.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }

        try {
            context.getBean(BeanD.class);
            fail("BeanD should not be registered since it's only defined in profile b.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }
    }

    @Test
    public void context_should_contains_beans_a_b_c_when_profile_a_is_activated() {

        context.getEnvironment().setActiveProfiles("a");
        loadContext();

        assertNotNull(context.getBean(BeanA.class));
        assertNotNull(context.getBean(BeanB.class));
        assertNotNull(context.getBean(BeanC.class));

        try {
            context.getBean(BeanD.class);
            fail("BeanD should not be registered since it's only defined in profile b.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }
    }

    @Test
    public void context_should_contains_beans_a_b_d_when_profile_b_is_activated() {

        context.getEnvironment().setActiveProfiles("b");
        loadContext();

        assertNotNull(context.getBean(BeanA.class));
        assertNotNull(context.getBean(BeanB.class));
        assertNotNull(context.getBean(BeanD.class));

        try {
            context.getBean(BeanC.class);
            fail("BeanC should not be registered since it's only defined in profile a.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }
    }

    @Test
    public void context_should_contains_beans_a_b_c_d_when_profile_a_b_are_activated() {

        context.getEnvironment().setActiveProfiles("a", "b");
        loadContext();

        assertNotNull(context.getBean(BeanA.class));
        assertNotNull(context.getBean(BeanB.class));
        assertNotNull(context.getBean(BeanC.class));
        assertNotNull(context.getBean(BeanD.class));
    }

    private void loadContext() {
        context.load("classpath:/com/github/jcgay/example/spring/ConfigureBeansForMultipleProfileXmlTest.xml");
        context.refresh();
    }
}
