package com.github.jcgay.example.spring;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("e")
public class BeanE {
}
