package com.github.jcgay.example.exception;

import org.testng.annotations.Test;

import static java.util.Arrays.asList;

public class TestNGExpectedTest {

    @Test(expectedExceptions = IndexOutOfBoundsException.class, expectedExceptionsMessageRegExp = "2")
    public void should_throw_exception() throws Exception {
        asList(0, 1).get(2);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void should_fail_because_no_exception_is_thrown() throws Exception {
        asList(0, 1, 2).get(2);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class, expectedExceptionsMessageRegExp = "2")
    public void should_fail_because_exception_message_is_not_the_expected_one() throws Exception {
        asList(0, 1, 2).get(3);
    }
}
