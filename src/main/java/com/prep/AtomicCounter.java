package com.prep;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicCounter
 */
public class AtomicCounter implements ICounter {

  private AtomicInteger value = new AtomicInteger();

  public int getValue() {
    return value.get();
  }

  public void increment(int incrementBy) {
    value.addAndGet(incrementBy);
  }

}
