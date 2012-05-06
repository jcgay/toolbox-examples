package com.github.jcgay.example.spring;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

public class ConfigureBeansElementXmlTest {

    private GenericXmlApplicationContext context;

    @BeforeMethod
    private void initializeTest() {
        context = new GenericXmlApplicationContext();
    }

    @Test
    public void context_should_contains_only_bean_a_when_no_profile_is_activated() {

        loadContext();

        assertNotNull(context.getBean(BeanA.class));

        try {
            context.getBean(BeanB.class);
            fail("BeanB should not be registered since it's only defined in profile b.");
        } catch (NoSuchBeanDefinitionException e) {
            // looks good !
        }
    }

    @Test
    public void context_should_contains_bean_a_and_bean_b_when_profile_b_is_activated() {

        context.getEnvironment().setActiveProfiles("b");
        loadContext();

        assertNotNull(context.getBean(BeanA.class));
        assertNotNull(context.getBean(BeanB.class));
    }

    private void loadContext() {
        context.load("classpath:/com/github/jcgay/example/spring/ConfigureBeansElementXmlTest.xml");
        context.refresh();
    }
}
