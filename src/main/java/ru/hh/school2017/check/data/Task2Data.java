package ru.hh.school2017.check.data;

public class Task2Data extends Id {
  private String str;
  private Long answer;

  public Task2Data() {
  }

  public Task2Data(int id, long answer, String str) {
    super(id);
    this.answer = answer;
    this.str = str;
  }

  public String getStr() {
    return str;
  }

  public Long getAnswer() {
    return answer;
  }
}
