package com.github.jcgay.example.exception;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

public class TryCatchTest {

    @Test
    public void should_trow_exception() throws Exception {
        try {
            asList(0, 1).get(2);
            failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
        } catch (IndexOutOfBoundsException e) {
            assertThat(e).hasNoCause()
                         .hasMessage("2");
        }
    }

    @Test
    public void should_fail_because_no_exception_is_thrown() throws Exception {
        try {
            asList(0, 1, 2).get(2);
            failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
        } catch (IndexOutOfBoundsException e) {
            assertThat(e).hasNoCause()
                         .hasMessage("2");
        }
    }
}
