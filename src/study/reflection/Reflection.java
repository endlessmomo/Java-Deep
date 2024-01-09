package study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException
      , InstantiationException, IllegalAccessException, NoSuchFieldException {

    System.out.println("== Heap 영역에 로드된 특정 Class 인스턴스 획득==");
    // 1번 - 직접 클래스를 통해 가지고 오는것
    Class<Student> aClass = Student.class;
    System.out.println(System.identityHashCode(aClass));

    // 2번 - 인스턴스의 getClass() 메소드를 활용하여 획득한다.
    Student student = new Student();
    Class<? extends Student> bClass = student.getClass();
    System.out.println(System.identityHashCode(bClass));

    // 3번 - 패키지 경로 + 클래스 명을 통한 인스턴스 가져오기
    Class<?> cClass = Class.forName("study.reflection.Student");
    System.out.println(System.identityHashCode(cClass));

    System.out.println("\n== 리플렉션을 사용하여 Constructor를 통해 객체를 인스턴스를 생성한다. ==");
    Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, String.class,
        int.class);
    Student s1 = (Student) constructor.newInstance("엄수혁", "소프트웨어공학", 4);
    System.out.println(s1);

    System.out.println("\n== 리플렉션을 사용하여 Method를 통해 객체 메소드에 직접 접근할 수 있도록한다. ==");
    // setAccessible을 통해 접근 제어자 상관없이 접근할 수 있도록 설정한다.
    Method sayMoreDetails = aClass.getDeclaredMethod("introduceDetail");
    sayMoreDetails.setAccessible(true);
    sayMoreDetails.invoke(s1);

    System.out.println("\n== 리플렉션을 사용하여 Field를 통해 객체 필드에 직접 접근할 수 있도록한다. ==");
    Field[] fieldDetails = aClass.getDeclaredFields();
    for (Field field : fieldDetails) {
      field.setAccessible(true);
      System.out.println(field.getType() + ", " + field.getName() + " = " + field.get(s1));
    }

    // reflection을 사용하면, Setter 메소드가 없어도 강제로 객체의 필드값을 변경할 수 있다.
    Field field = aClass.getDeclaredField("name");
    field.setAccessible(true);
    field.set(s1, "정하윤");

    System.out.println(s1.toString());
  }
}


