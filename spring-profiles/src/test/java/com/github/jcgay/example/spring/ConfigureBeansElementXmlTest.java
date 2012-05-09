package com.github.jcgay.example.spring;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.jcgay.example.matcher.ApplicationContextAssert.assertThat;

public class ConfigureBeansElementXmlTest {

    private GenericXmlApplicationContext context;

    @BeforeMethod
    private void initializeTest() {
        context = new GenericXmlApplicationContext();
    }

    @Test
    public void context_should_contains_only_bean_a_when_no_profile_is_activated() {

        loadContext();

        assertThat(context).containsBean(BeanA.class)
                           .notContainsBean(BeanB.class);
    }

    @Test
    public void context_should_contains_bean_a_and_bean_b_when_profile_b_is_activated() {

        context.getEnvironment().setActiveProfiles("b");
        loadContext();

        assertThat(context).containsBean(BeanA.class)
                           .containsBean(BeanB.class);
    }

    private void loadContext() {
        context.load("classpath:/com/github/jcgay/example/spring/ConfigureBeansElementXmlTest.xml");
        context.refresh();
    }
}
