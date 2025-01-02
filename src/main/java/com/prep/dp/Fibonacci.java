package com.prep.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  // TC: O(n) n number of function calls
  // SC: O(n) n number of function calls and dp array

  private final Map<Integer, Integer> map = new HashMap<>();
  private final int[] dp_array;

  public Fibonacci(int n) {
      dp_array = new int[n + 1];
      Arrays.fill(dp_array, -1);
  }

  public int fib(int n) {

    if (n == 0 || n == 1) {
      return n;
    }

    Integer val = map.get(n);
    if (val != null) {
      return val;
    }

    var result = fib(n - 1) + fib(n - 2);
    map.put(n, result);

    return result;
  }

  public int fib_with_dp_array(int n) {
    if ( n == 0 || n == 1 ) return n;

    if ( dp_array[n] != -1 ) return dp_array[n];

    dp_array[n] = fib(n - 1 ) + fib( n  - 2 );

    return dp_array[n];
  }
}
