package com.prep;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DiningPhilosphers
 */
public class DiningPhilosphers {
  AtomicInteger nextPhil = new AtomicInteger(2);
  Semaphore forkSet = new Semaphore(2);

  public void wantsToEat(int philospher,
      Runnable pickLeftFork,
      Runnable pickRightFork,
      Runnable eat,
      Runnable putRightFork,
      Runnable putLeftFork) throws InterruptedException {

    while (!nextPhil.compareAndSet(nextPhil.get(), philospher)) {

    }
    forkSet.acquire();

    nextPhil.set((philospher + 2) % 5);
    pickRightFork.run();
    pickLeftFork.run();
    eat.run();
    putRightFork.run();
    putLeftFork.run();
    forkSet.release();
  }
}
