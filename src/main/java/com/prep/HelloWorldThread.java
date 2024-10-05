package com.prep;

class HelloWorldThread implements Runnable {

  @Override
  public void run() {
    System.out.println("From Hello class from " + Thread.currentThread().getName());

  }
}
