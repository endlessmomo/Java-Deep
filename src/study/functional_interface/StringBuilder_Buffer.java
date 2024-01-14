package study.functional_interface;

public class StringBuilder_Buffer {

  static StringBuilder sb = new StringBuilder();
  static final StringBuffer stringBuffer = new StringBuffer();

  public static void main(String[] args) {
    Runnable task = () -> {
        for (int i = 0; i < 10000; i++) {
          System.out.println(Thread.currentThread().getName() + "의 " + i + "번째 업무 수행");
          sb.append(1);
          sb.append(0);
          // 순서 보장을 위한 동기화 블럭 생성
          synchronized (stringBuffer) {
          stringBuffer.append(1);
          stringBuffer.append(0);
        }
      }
    };

    Thread thread = new Thread(task);
    Thread thread1 = new Thread(task);

    thread.start();
    thread1.start();

    try {
      thread.join();
      thread1.join();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(sb.length());
    System.out.println(stringBuffer.length());

    System.out.println(stringBuffer);
  }
}
