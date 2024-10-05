package com.prep;

import java.util.concurrent.locks.Lock;

/**
 * Subtracter
 */
public class Subtracter implements Runnable {
  ICounter c;
  Lock lock;

  public Subtracter(Counter counter, Lock lock) {
    this.lock = lock;
    this.c = counter;
  }

  public Subtracter(AtomicCounter counter) {
    this.c = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100000; i++) {
      // lock.lock();
      // synchronized (c) {
      // System.out.println("Thread name " + Thread.currentThread().getName() + "
      // locked");
      // c.value = c.value - 1;
      c.increment(-1);
      // System.out.println("Thread name " + Thread.currentThread().getName() + "
      // unlocked");
      // }
      // lock.unlock();
    }
  }

}
