package study.mutable_Immutable;

public class Resume {

  private String name;
  private int age;
  private Job job;

  public Resume(String name, int age, Job job) {
    this.name = name;
    this.age = age;
    this.job = job;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  @Override
  public String toString() {
    return "Resume { " +
        "[name = " + name + "]" +
        ", [age = " + age +
        "], [job = " + job.getJob() +
        "] }";
  }
}
