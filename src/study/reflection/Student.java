package study.reflection;

public class Student {

  private String name;
  private String major;
  private int grade;


  public Student() {};

  public Student(String name, String major, int grade) {
    this.name = name;
    this.major = major;
    this.grade = grade;
  }

  public void introduce() {
    System.out.printf("나의 이름은 %s야! 잘 부탁해\n", this.name);
  }

  private void introduceDetail() {
    System.out.printf("나는 %s이고, %s과, %d학년이야.\n", this.name, this.major, this.grade);
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", major='" + major + '\'' +
        ", grade=" + grade +
        '}';
  }
}
