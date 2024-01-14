package study.functional_interface;

public class MRunnable {

  public static void main(String[] args) {

    Runnable task = new Thread(() -> {
      for (int j = 0; j < 5; j++) {
        System.out.println(Thread.currentThread().getName() + " : " + j);
      }
      System.out.println(Thread.currentThread().getName() + "Thread have done it task");
    });

    Thread thread1 = new Thread(task);
    Thread thread2 = new Thread(task);

    thread1.start();
    thread2.start();



  }
}
