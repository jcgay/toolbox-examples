package com.github.jcgay.example.exception;

import org.junit.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class CatchExceptionTest {

    @Test
    public void should_throw_exception() throws Exception {

        catchException(asList(0, 1)).get(2);

        assertThat(caughtException())
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("2")
                .hasNoCause();
    }

    @Test
    public void should_fail_because_no_exception_is_thrown() throws Exception {

        catchException(asList(0, 1, 2)).get(2);

        assertThat(caughtException())
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("2")
                .hasNoCause();
    }
}
