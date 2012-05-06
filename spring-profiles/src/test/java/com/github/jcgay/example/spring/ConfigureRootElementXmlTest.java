package com.github.jcgay.example.spring;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

public class ConfigureRootElementXmlTest {

    private GenericXmlApplicationContext context;

    @BeforeTest
    private void initializeTest() {
        context = new GenericXmlApplicationContext();
    }

    @Test
    public void context_should_contains_only_bean_a_when_profile_a_is_activated() {

        setProfile("a");

        assertNotNull(context.getBean(BeanA.class));

        try {
            context.getBean(BeanB.class);
            fail("BeanB should not be registered since it's only defined in profile b.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }
    }

    @Test
    public void context_should_contains_only_bean_b_when_profile_b_is_activated() {

        setProfile("b");

        assertNotNull(context.getBean(BeanB.class));

        try {
            context.getBean(BeanA.class);
            fail("BeanA should not be registered since it's only defined in profile a.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }
    }

    private void setProfile(String profile) {
        context.getEnvironment().setActiveProfiles(profile);
        context.load("classpath:/com/github/jcgay/example/spring/ConfigureRootElementXmlTest-a.xml");
        context.load("classpath:/com/github/jcgay/example/spring/ConfigureRootElementXmlTest-b.xml");
        context.refresh();
    }

}
