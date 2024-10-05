package com.prep;

import java.util.concurrent.Callable;

/**
 * ExecuterClient
 */
public class ExecuterClient implements Callable<String> {
  int count;

  public ExecuterClient(int num) {
    this.count = num;
  }

  @Override
  public String call() throws Exception {
    return "return value" + count++;
  }
}
