package com.prep;

import java.util.concurrent.locks.Lock;

/**
 * Adder
 */
public class Adder implements Runnable {

  ICounter c;
  Lock lock;

  public Adder(Counter counter, Lock lock) {
    this.c = counter;
    this.lock = lock;
  }

  public Adder(AtomicCounter counter) {
    this.c = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100000; i++) {
      // lock.lock();
      // synchronized (c) {
      // System.out.println("Thread name " + Thread.currentThread().getName() + "
      // locked");
      // c.value = c.value + 1;
      c.increment(1);
      // System.out.println("Thread name " + Thread.currentThread().getName() + "
      // unlocked");
      // }
      // lock.unlock();
    }
  }

}
