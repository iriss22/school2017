package ru.hh.school2017.check.data;

public class Task1Data extends Id {
  private Integer[][] island;
  private Integer answer;

  public Task1Data() {

  }

  public Task1Data(Integer id, int answer, Integer[][] island) {
    super(id);
    this.answer = answer;
    this.island = island;
  }

  public Integer[][] getIsland() {
    return island;
  }

  public Integer getAnswer() {
    return answer;
  }
}
