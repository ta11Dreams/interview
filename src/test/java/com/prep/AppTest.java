package com.prep;

import org.junit.Test;

/**
 * AppTest
 */
public class AppTest {

  @Test
  public void verifyNoException() {
    App.main(new String[] {});
  }

  @Test
  public void testDiningPhilosphers() throws InterruptedException {
    DiningPhilosphers phil = new DiningPhilosphers();
    int n = 1;

    Runnable pickLeftFork = () -> {
      System.out.println("Left fork picked: " + Thread.currentThread().getName());
    };

    Runnable pickRightFork = () -> {
      System.out.println("Right fork picked: " + Thread.currentThread().getName());
    };

    Runnable eat = () -> {
      System.out.println("eat: " + Thread.currentThread().getName());
    };

    Runnable putLeftFork = () -> {
      System.out.println("Left fork put: " + Thread.currentThread().getName());
    };

    Runnable putRightFork = () -> {
      System.out.println("Left fork put: " + Thread.currentThread().getName());
    };

    Runnable phil1 = () -> {
      for (int i = 0; i < n; i++) {
        try {
          phil.wantsToEat(0, pickLeftFork, pickRightFork, eat, putRightFork, putLeftFork);
        } catch (Exception e) {
          System.out.println("phil0 ran into error");
          e.printStackTrace();
        }
      }
    };

    Runnable phil2 = () -> {
      for (int i = 0; i < n; i++) {
        try {
          phil.wantsToEat(1, pickLeftFork, pickRightFork, eat, putRightFork, putLeftFork);
        } catch (Exception e) {
          System.out.println("phil1 ran into error");
          e.printStackTrace();
        }
      }
    };

    Runnable phil3 = () -> {
      for (int i = 0; i < n; i++) {
        try {
          phil.wantsToEat(2, pickLeftFork, pickRightFork, eat, putRightFork, putLeftFork);
        } catch (Exception e) {
          System.out.println("phil2 ran into error");
          e.printStackTrace();
        }
      }
    };

    Runnable phil4 = () -> {
      for (int i = 0; i < n; i++) {
        try {
          phil.wantsToEat(3, pickLeftFork, pickRightFork, eat, putRightFork, putLeftFork);
        } catch (Exception e) {
          System.out.println("phil3 ran into error");
          e.printStackTrace();
        }
      }
    };

    Runnable phil5 = () -> {
      for (int i = 0; i < n; i++) {
        try {
          phil.wantsToEat(4, pickLeftFork, pickRightFork, eat, putRightFork, putLeftFork);
        } catch (Exception e) {
          System.out.println("phil4 ran into error");
          e.printStackTrace();
        }
      }
    };

    Thread t1 = new Thread(phil1, "phil1");
    Thread t2 = new Thread(phil2, "phil2");
    Thread t3 = new Thread(phil3, "phil3");
    Thread t4 = new Thread(phil4, "phil4");
    Thread t5 = new Thread(phil5, "phil5");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();

  }
}
