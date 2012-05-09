package com.github.jcgay.example.spring;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.jcgay.example.matcher.ApplicationContextAssert.assertThat;

public class ConfigureBeansForMultipleProfileXmlTest {

    private GenericXmlApplicationContext context;

    @BeforeMethod
    private void initializeTest() {
        context = new GenericXmlApplicationContext();
    }

    @Test
    public void context_should_contains_nothing_when_no_profile_is_activated() {

        loadContext();

        assertThat(context).notContainsBean(BeanA.class)
                           .notContainsBean(BeanB.class)
                           .notContainsBean(BeanC.class)
                           .notContainsBean(BeanD.class);
    }

    @Test
    public void context_should_contains_beans_a_b_c_when_profile_a_is_activated() {

        context.getEnvironment().setActiveProfiles("a");
        loadContext();

        assertThat(context).containsBean(BeanA.class)
                           .containsBean(BeanB.class)
                           .containsBean(BeanC.class)
                           .notContainsBean(BeanD.class);
    }

    @Test
    public void context_should_contains_beans_a_b_d_when_profile_b_is_activated() {

        context.getEnvironment().setActiveProfiles("b");
        loadContext();

        assertThat(context).containsBean(BeanA.class)
                           .containsBean(BeanB.class)
                           .notContainsBean(BeanC.class)
                           .containsBean(BeanD.class);
    }

    @Test
    public void context_should_contains_beans_a_b_c_d_when_profile_a_b_are_activated() {

        context.getEnvironment().setActiveProfiles("a", "b");
        loadContext();

        assertThat(context).containsBean(BeanA.class)
                           .containsBean(BeanB.class)
                           .containsBean(BeanC.class)
                           .containsBean(BeanD.class);
    }

    private void loadContext() {
        context.load("classpath:/com/github/jcgay/example/spring/ConfigureBeansForMultipleProfileXmlTest.xml");
        context.refresh();
    }
}
