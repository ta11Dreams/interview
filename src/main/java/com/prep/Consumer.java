package com.prep;

import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Consumer
 */
public class Consumer implements Runnable {

  Queue<Integer> queue;
  int size;
  Semaphore producer;
  Semaphore consumer;

  public Consumer(Queue<Integer> queue, int size,
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
        consumer.acquire();
        if (queue.size() > 0)
          queue.remove();
        producer.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(queue.size() + " thread name " + Thread.currentThread().getName());
    }
  }

}
