package com.prep.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  private Map<Integer, Integer> map = new HashMap<>();

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
}
