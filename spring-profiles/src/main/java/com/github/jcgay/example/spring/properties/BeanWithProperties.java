package com.github.jcgay.example.spring.properties;

import org.springframework.beans.factory.annotation.Value;

public class BeanWithProperties {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String property) {
        this.test = property;
    }
}
