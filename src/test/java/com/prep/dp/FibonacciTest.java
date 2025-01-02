package com.prep.dp;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FibonacciTest {

    Fibonacci fib = new Fibonacci(0);

    @Test
    public void test_fibonacci() {
        assertThat(fib.fib(2)).isEqualTo(1);
        assertThat(fib.fib(5)).isEqualTo(5);
        assertThat(fib.fib(6)).isEqualTo(8);
    }

    @Test
    public void test_fibonacci_with_dp_array() {
        fib = new Fibonacci(2);
        assertThat(fib.fib_with_dp_array(2)).isEqualTo(1);
        fib = new Fibonacci(5);
        assertThat(fib.fib_with_dp_array(5)).isEqualTo(5);
        fib = new Fibonacci(6);
        assertThat(fib.fib_with_dp_array(6)).isEqualTo(8);
    }
}
