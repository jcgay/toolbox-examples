package com.github.jcgay.example.spring;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.jcgay.example.matcher.ApplicationContextAssert.assertThat;

public class ConfigureRootElementXmlTest {

    private GenericXmlApplicationContext context;

    @BeforeMethod
    private void initializeTest() {
        context = new GenericXmlApplicationContext();
    }

    @Test
    public void context_should_contains_only_bean_a_when_profile_a_is_activated() {

        setProfile("a");

        assertThat(context).containsBean(BeanA.class)
                           .notContainsBean(BeanB.class);
    }

    @Test
    public void context_should_contains_only_bean_b_when_profile_b_is_activated() {

        setProfile("b");

        assertThat(context).containsBean(BeanB.class)
                           .notContainsBean(BeanA.class);
    }

    private void setProfile(String profile) {
        context.getEnvironment().setActiveProfiles(profile);
        context.load("classpath:/com/github/jcgay/example/spring/ConfigureRootElementXmlTest-a.xml");
        context.load("classpath:/com/github/jcgay/example/spring/ConfigureRootElementXmlTest-b.xml");
        context.refresh();
    }

}
