package study.mutable_Immutable;

public class Resume {

  /* 변경 전
  private String name;
  private int age;
  private Job job;
  */

  private final String name;
  private final int age;
  private final Job job;

  public Resume(String name, int age, Job job) {
    this.name = name;
    this.age = age;
    this.job = job;
  }
 /* 변경 전
 public void setName(String name) {
    this.name = name;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public void setJob(Job job) {
    this.job = job;
  }
  */
  @Override
  public String toString() {
    return "Resume { " +
        "[name = " + name + "]" +
        ", [age = " + age +
        "], [job = " + job.getJob() +
        "] }";
  }
}
