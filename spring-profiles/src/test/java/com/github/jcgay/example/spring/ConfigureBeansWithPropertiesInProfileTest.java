package com.github.jcgay.example.spring;


import com.github.jcgay.example.spring.properties.BeanWithProperties;
import com.github.jcgay.example.spring.properties.BeanWithPropertiesAnnotated;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ConfigureBeansWithPropertiesInProfileTest {

    private GenericXmlApplicationContext context;

    @BeforeMethod
    private void initializeTest() {
        context = new GenericXmlApplicationContext();
    }

    @Test
    public void should_read_properties_file_from_profile_a() {

        context.getEnvironment().setDefaultProfiles("default");
        context.getEnvironment().setActiveProfiles("a");
        context.load("classpath:/com/github/jcgay/example/spring/ConfigureBeansWithPropertiesInProfileTest.xml");
        context.refresh();

        BeanWithProperties bean = context.getBean(BeanWithProperties.class);
        BeanWithPropertiesAnnotated annotated = context.getBean(BeanWithPropertiesAnnotated.class);

        assertThat(bean.getTest()).isEqualTo("a");
        assertThat(annotated.getTest()).isEqualTo("a");
    }
}
