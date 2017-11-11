package ru.hh.school2017.check.data;

import java.io.Serializable;
import java.util.List;

public class TestData implements Serializable {
  private List<Task1Data> task1Data;
  private List<Task2Data> task2Data;

  public TestData() {
  }

  public TestData(List<Task1Data> task1Data, List<Task2Data> task2Data) {
    this.task1Data = task1Data;
    this.task2Data = task2Data;
  }

  public List<Task1Data> getTask1Data() {
    return task1Data;
  }

  public List<Task2Data> getTask2Data() {
    return task2Data;
  }
}
