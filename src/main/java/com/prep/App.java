package com.prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.prep.lld.builder.CarBuilder;
import com.prep.lld.factory.AbstractUIFactory;
import com.prep.lld.factory.WindowsFactory;
import com.prep.lld.factory.ui.Button;
import com.prep.lld.factory.ui.Panel;
import com.prep.lld.factory.ui.TextBox;
import com.prep.lld.prototype.IntelligentStudent;
import com.prep.lld.prototype.Student;
import com.prep.lld.registry.StudentRegistry;
import com.prep.dp.Fibonacci;
import com.prep.lld.Singleton;

public class App {
  public static void main(String[] args) {
    // callable();
    // mergeSort();
    // syncProblem();
    // RecordCounter counter = new RecordCounter(2);
    // System.out.println(counter.value());
    // semaphore();
    // atomicDataStructure();
    // serverSocket();
    // java21Features();
    // singleton();
    // builder();
    // studentPrototype();
    // factory();
    dpFibonacci();
  }

  public static void dpFibonacci() {
    Fibonacci f = new Fibonacci();
    System.out.println(f.fib(5));
    System.out.println(f.fib(7));
    System.out.println(f.fib(10));
  }

  public static void factory() {
    WindowsFactory winFactory = (WindowsFactory) AbstractUIFactory.getFactory("windows");

    Button btn = winFactory.createButton();
    btn.click();
    TextBox txtBox = winFactory.createTextBox();
    Panel panel = winFactory.createPanel();
  }

  public static void studentPrototype() {
    Student student1 = new Student("rohit", "batch 1");
    Student student2 = new Student("rohan", "batch 1");
    Student student3 = new Student("ajay", "batch 2");
    IntelligentStudent student4 = new IntelligentStudent("anant", "batch 3", "100");
    IntelligentStudent student5 = new IntelligentStudent("raj", "batch 2", "110");
    IntelligentStudent student6 = new IntelligentStudent("zaed", "batch 1", "89");

    StudentRegistry registry = new StudentRegistry();
    registry.addStudent("s1", student1);
    registry.addStudent("s2", student2);
    registry.addStudent("s3", student3);
    registry.addStudent("s4", student4);
    registry.addStudent("s5", student5);
    registry.addStudent("s6", student6);

    ArrayList<Student> student = registry.getByClassname("batch 1");

    System.out.println(student);
  }

  public static void builder() {
    CarBuilder carBuilder = new CarBuilder();

    CarBuilder.Car car1 = carBuilder.setId(1)
        .setName("honda")
        .setBuildYear(2020)
        .setColor("blue")
        .setEngine("petrol")
        .build();

    System.out.println(car1.engine);
  }

  public static void singleton() {

    Thread t1 = new Thread(() -> {
      Singleton obj = Singleton.getInstance();
      for (int i = 0; i < 10_000; i++) {
        if (obj != Singleton.getInstance()) {
          System.out.println((obj == Singleton.getInstance()) + " : " + Thread.currentThread().getName());
        }
      }
    }, "t1");

    Thread t2 = new Thread(() -> {
      Singleton obj = Singleton.getInstance();
      for (int i = 0; i < 10_000; i++) {
        if (obj != Singleton.getInstance()) {
          System.out.println((obj == Singleton.getInstance()) + " : " + Thread.currentThread().getName());
        }
      }
    }, "t2");

    Thread t3 = new Thread(() -> {
      Singleton obj = Singleton.getInstance();
      for (int i = 0; i < 10_000; i++) {
        if (obj != Singleton.getInstance()) {
          System.out.println((obj == Singleton.getInstance()) + " : " + Thread.currentThread().getName());
        }
      }
    }, "t3");

    try {
      t1.start();
      t2.start();
      t3.start();

      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void java21Features() {
    Java21Features challenge = new Java21Features();
    System.out.println(challenge.pattern("1"));
    System.out.println(challenge.pattern("123"));
    System.out.println(challenge.ifPattern());
    challenge.recordPatternTest();
  }

  public static void serverSocket() {
    SocketServer socketServer = new SocketServer(5000);
  }

  public static void atomicDataStructure() {
    AtomicCounter counter = new AtomicCounter();

    Adder adder = new Adder(counter);
    Subtracter subtracter = new Subtracter(counter);

    Thread t1 = new Thread(adder, "adder");
    Thread t2 = new Thread(subtracter, "subtracter");

    t1.start();
    t2.start();

    try {
      t1.join(); // join will make the main thread wait for the child threads to complete
      t2.join();
      System.out.println(counter.getValue());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public static void semaphore() {
    Queue<Integer> queue = new ConcurrentLinkedQueue<>();
    int size = 5;
    Semaphore producerSemaphore = new Semaphore(size);
    Semaphore consumerSemaphore = new Semaphore(size);

    Producers producer1 = new Producers(queue, size, consumerSemaphore, producerSemaphore);
    Producers producer2 = new Producers(queue, size, consumerSemaphore, producerSemaphore);
    Producers producer3 = new Producers(queue, size, consumerSemaphore, producerSemaphore);
    Producers producer4 = new Producers(queue, size, consumerSemaphore, producerSemaphore);

    Consumer consumer1 = new Consumer(queue, size, consumerSemaphore, producerSemaphore);
    Consumer consumer2 = new Consumer(queue, size, consumerSemaphore, producerSemaphore);
    Consumer consumer3 = new Consumer(queue, size, consumerSemaphore, producerSemaphore);
    Consumer consumer4 = new Consumer(queue, size, consumerSemaphore, producerSemaphore);
    Consumer consumer5 = new Consumer(queue, size, consumerSemaphore, producerSemaphore);
    Consumer consumer6 = new Consumer(queue, size, consumerSemaphore, producerSemaphore);
    Consumer consumer7 = new Consumer(queue, size, consumerSemaphore, producerSemaphore);

    Thread t1 = new Thread(producer1, "producer 1");
    Thread t2 = new Thread(producer2, "producer 2");
    Thread t3 = new Thread(producer3, "producer 3");
    Thread t4 = new Thread(producer4, "producer 4");

    Thread ct1 = new Thread(consumer1, "consumer 1");
    Thread ct2 = new Thread(consumer2, "consumer 2");
    Thread ct3 = new Thread(consumer3, "consumer 3");
    Thread ct4 = new Thread(consumer4, "consumer 4");
    Thread ct5 = new Thread(consumer5, "consumer 5");
    Thread ct6 = new Thread(consumer6, "consumer 6");
    Thread ct7 = new Thread(consumer7, "consumer 7");

    ct1.start();
    t1.start();
    t2.start();
    ct2.start();
    t3.start();
    ct3.start();
    t4.start();

    ct4.start();
    ct5.start();
    ct6.start();
    ct7.start();

    System.out.println("thread name " + Thread.currentThread().getName());
  }

  public static void syncProblem() {
    Counter counter = new Counter();

    Lock lock = new ReentrantLock();

    Adder adder = new Adder(counter, lock);
    Subtracter subtracter = new Subtracter(counter, lock);

    Thread t1 = new Thread(adder, "adder");
    Thread t2 = new Thread(subtracter, "subtracter");

    t1.start();
    t2.start();

    try {
      t1.join(); // join will make the main thread wait for the child threads to complete
      t2.join();
      System.out.println(counter.getValue());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public static void mergeSort() {
    ExecutorService service = Executors.newCachedThreadPool();

    List<Integer> list = List.of(2, 4, 5, 1, 3);
    MergeSort sorter = new MergeSort(list, service);

    try {
      Future<List<Integer>> futureResult = service.submit(sorter);
      List<Integer> result = futureResult.get();
      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
    service.shutdown();

  }

  public static void callable() {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    List<Future<String>> futures = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      Future<String> future = executorService.submit(new ExecuterClient(i));
      futures.add(future);
    }

    for (int i = 0; i < futures.size(); i++) {

      try {
        System.out.println("future no." + i);
        // this is a blocking action. it waits until the thread has completed execution
        Future<String> future = futures.get(i);
        System.out.println(future.get());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    executorService.shutdown();
  }

  public static void executor() {

    // ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    for (int i = 0; i < 10; i++) {
      executorService.submit(new NumberPrinter(i));
    }

    executorService.shutdown();
  }

  public static void exercise2() {
    for (int i = 0; i < 100; i++) {
      NumberPrinter num = new NumberPrinter(i);
      Thread t1 = new Thread(num);
      t1.setName("anant");
      t1.start();
    }
  }

  static void exercise1() {

    System.out.println("Hello There!" + Thread.currentThread().getName());
    Thread thread = new Thread(new HelloWorldThread());
    thread.run(); // main thread will execute the task and won't create a new thread
    thread.start();
    Thread thread1 = new Thread(new HelloWorldThread());
    thread1.start();
    print();
  }

  public static void print() {

    System.out.println("Hello again There!" + Thread.currentThread().getName());
  }
}
