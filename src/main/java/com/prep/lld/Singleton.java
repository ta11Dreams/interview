package com.prep.lld;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Singleton
 */
public class Singleton {

  private static Singleton instance;
  private static ReentrantLock lock = new ReentrantLock();

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (instance == null) {
      // Double Check Locking DCL
      // synchronized (Singleton.class) {} this will also work
      lock.lock();
      if (instance == null) {
        instance = new Singleton();
      }
      lock.unlock();
    }

    return instance;
  }

}
