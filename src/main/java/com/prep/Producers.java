package com.prep;

import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Producers
 */
public class Producers implements Runnable {

  Queue<Integer> queue;
  int size;
  Semaphore consumer;
  Semaphore producer;

  public Producers(Queue<Integer> queue, int size,
      Semaphore consumer, Semaphore producer) {
    this.queue = queue;
    this.size = size;
    this.consumer = consumer;
    this.producer = producer;
  }

  @Override
  public void run() {
    while (true) {
      try {
        producer.acquire();
        if (queue.size() < size)
          queue.add(1);
        consumer.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(queue.size() + " thread name " + Thread.currentThread().getName());
    }
  }

}
