package com.prep;

/**
 * Counter
 */
public class Counter implements ICounter {
  private int value;

  public int getValue() {
    return value;
  }

  // public synchronized void increment(int incrementBy) Also a valid signature
  synchronized public void increment(int incrementBy) {
    value += incrementBy;
  }

}
