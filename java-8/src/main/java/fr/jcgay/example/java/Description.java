package fr.jcgay.example.java;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Descriptions.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
    String value();
}
