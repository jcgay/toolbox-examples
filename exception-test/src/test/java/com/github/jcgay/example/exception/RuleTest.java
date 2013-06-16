package com.github.jcgay.example.exception;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.junit.rules.ExpectedException;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.containsString;

public class RuleTest {

    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    @Test
    public void should_throw_exception() throws Exception {
        thrownException.expect(IndexOutOfBoundsException.class);
        thrownException.expectMessage(containsString("2"));
        asList(0, 1).get(2);
    }

    @Test
    public void should_fail_because_no_exception_is_thrown() throws Exception {
        thrownException.expect(IndexOutOfBoundsException.class);
        asList(0, 1, 2).get(2);
    }
}
