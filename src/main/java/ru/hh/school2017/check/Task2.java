package ru.hh.school2017.check;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import ru.hh.school2017.check.data.Task2Data;

public class Task2 {

  private List<Task2Data> exampleData = new ArrayList<>();
  public Task2() {
    exampleData.add(new Task2Data(0, 6, "6789"));
    exampleData.add(new Task2Data(1, 12, "111"));
  }

  public void check(Task2Desc app, List<Task2Data> task2Data) throws IOException, ParseException {
    int rightCntBase = 0;
    int rightCntConf = 0;

    for (Task2Data data: exampleData) {
      if (data.getAnswer().equals(app.findSequence(data.getStr()))) {
        rightCntBase++;
      }
    }

    System.out.println(String.format("right base task2: %s", (double)rightCntBase*100/exampleData.size()));

    Long t1 = System.currentTimeMillis();
    for (Task2Data testData: task2Data) {
      try {
        if (testData.getAnswer().equals(app.findSequence(testData.getStr()))) {
          rightCntConf++;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    Long t2 = System.currentTimeMillis();

    System.out.println(String.format("right conf task2: %s", (double)rightCntConf*100/task2Data.size()));
    System.out.println(String.format("time conf tests task2: %s", (t2-t1)/1000));
  }
}
