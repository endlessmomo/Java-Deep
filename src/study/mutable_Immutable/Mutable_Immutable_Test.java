package study.mutable_Immutable;

import java.util.ArrayList;
import java.util.List;

public class Mutable_Immutable_Test {

  public static void main(String[] args) {
    List<Resume> resumeList = new ArrayList<>();
    resumeList.add(new Resume("엄수혁", 29, Job.BE));
    resumeList.add(new Resume("김지운", 29, Job.INFRA));


    // 일급 컬렉션을 통해 불변 객체로 전환 -> 일급 컬렉션을 통해 객체가 생성된 이후에도 외부의 값 변경이 되지 않도록 하려한다.
    Resumes resumes = new Resumes(resumeList);

    // 일급 컬렉션으로 컬렉션을 불변 객체화 하더라도 두 변수는 동일한 주소를 바라본다.
    System.out.println(" === 일급 컬렉션의 내부 Collection과 외부 Collection이 바라보는 주소  ===");
    System.out.println("일급 콜렉션 내부 = " + System.identityHashCode(resumes.getResume(0)));
    System.out.println("외부 콜렉션 = " + System.identityHashCode(resumeList.get(0)));

    Resume applicant = new Resume("최창환", 27, Job.TECH_SUPPORT);
    resumeList.add(applicant);
    // 깊은 복사 전 -> 일급 컬렉션의 리스트와 resumeList는 같은 주소 공간을 사용하고 있기 때문에 외부의 값 변경이 허용됨
    System.out.println("\n === 깊은 복사 전 ===");
    System.out.println(resumes.getResume(1).toString()); // Resume { [name = 김지운], [age = 29], [job = 인프라 엔지니어] }
//    System.out.println(resumes.getResume(2).toString()); // Resume

    // 깊은 복사 후 -> 생성자에서 인자를 받으면서 new ArrayList<>()를 이용해 만든 복사본으로, 필드names 를 초기화하여,
    // 원하는 상태의 Collection을 불변 객체로 만든 후, 추가 변경이 불가능하게 한다.
    System.out.println("\n === 깊은 복사 후 ===");
    System.out.println(resumes.getResume(1).toString()); // Resume { [name = 김지운], [age = 29], [job = 인프라 엔지니어] }
    // System.out.println(resumes.getResume(2).toString()); // Index ? out of bounds for length ?

    // 일급 컬렉션으로 컬렉션을 불변 객체화 하더라도 두 변수는 동일한 주소를 바라본다.
    System.out.println("\n === 일급 컬렉션의 내부 Collection과 외부 Collection이 바라보는 주소  ===");
    System.out.println("일급 콜렉션 내부 = " + System.identityHashCode(resumes.getResume(0)));
    System.out.println("외부 콜렉션 = " + System.identityHashCode(resumeList.get(0)));

//    System.out.println("\n === 일급 커넥션 내부 Collection을 가져와 변경 시도한 경우 ===");
//    List<Resume> newResumes = resumes.getResumes();
//    newResumes.add(applicant);
//    System.out.println(resumes.getResume(2).toString());

    // 그렇다면 Resume이 불변 객체가 아니고 가변 객체일 경우 어떤 문제가 발생할까?
    // 실제 값이 변경되는 것을 알 수 있다. 따라서 외부로부터의 변경에 취약하지 않도록 객체를 불변으로 만들고자 한다면 내부 요소들 또한 불변이어야 한다.
    System.out.println("\n === Resume이 가변 객체일 경우 ===");
    resumes.getResume(1).setName("이다인");
    System.out.println(resumes.getResume(1).toString()); // Resume { [name = 이다인], [age = 29], [job = 인프라 엔지니어] }
  }
}
