package com.github.jcgay.example.exception;

import org.junit.Test;

import static java.util.Arrays.asList;

public class JUnitExpectedTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_exception() throws Exception {
        asList(0, 1).get(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_fail_because_no_exception_is_thrown() throws Exception {
        asList(0, 1, 2).get(2);
    }
}
