package com.github.jcgay.example.matcher;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

public class ApplicationContextAssert extends GenericAssert<ApplicationContextAssert, ApplicationContext> {

    public ApplicationContextAssert(ApplicationContext springContext) {
        super(ApplicationContextAssert.class, springContext);
    }

    public static ApplicationContextAssert assertThat(ApplicationContext springContext) {
        return new ApplicationContextAssert(springContext);
    }

    public ApplicationContextAssert containsBean(Class<?> beanClass) {

        isNotNull();

        String message = String.format("Expected Spring context containing bean of type <%s> but no one was found.", beanClass.getName());
        Assertions.assertThat(hasBean(beanClass)).overridingErrorMessage(message).isTrue();

        return this;
    }

    public ApplicationContextAssert notContainsBean(Class<?> beanClass) {

        isNotNull();

        String message = String.format("Expected Spring context not containing bean of type <%s> but found one.", beanClass.getName());
        Assertions.assertThat(hasBean(beanClass)).overridingErrorMessage(message).isFalse();

        return this;
    }

    private boolean hasBean(Class<?> beanClass) {
        boolean result;
        try {
            actual.getBean(beanClass);
            result = true;
        } catch (NoSuchBeanDefinitionException e) {
            result = false;
        }
        return result;
    }
}
