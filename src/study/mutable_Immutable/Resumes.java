package study.mutable_Immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resumes {
  private final List<Resume> resumes;

  public Resumes(List<Resume> resumes) {
    this.resumes = new ArrayList<>(resumes);
  }

  public Resume getResume(int idx){
    return this.resumes.get(idx);
  }

  public List<Resume> getResumes(){
    return Collections.unmodifiableList(this.resumes);
  }
}
