package study.mutable_Immutable;

import java.util.Arrays;

public enum Job {
  BE("백엔드 연구원"),
  FE("프론트 연구원"),
  INFRA("인프라 엔지니어"),
  TECH_SUPPORT("기술 지원");

  private final String job;

  Job(String job) {
    this.job = job;
  }

  public String getJob() {
    return job;
  }

  public static String from(Job job) {
    return Arrays.stream(Job.values())
        .filter(i -> i.equals(job))
        .findFirst()
        .map(Job::getJob)
        .orElseThrow(() -> new IllegalArgumentException("해당 직무는 존재하지 않습니다."));
  }
}
