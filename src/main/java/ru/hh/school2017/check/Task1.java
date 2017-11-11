package ru.hh.school2017.check;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.ParseException;
import ru.hh.school2017.check.data.Task1Data;

public class Task1 {

  private List<Task1Data> exampleData = new ArrayList<>();

  public Task1() {
    exampleData.add(new Task1Data(0, 2, new Integer[][]{{4, 5, 4}, {3, 1, 5}, {5, 4, 1}}));
    exampleData.add(new Task1Data(0, 7, new Integer[][]{{5, 3, 4, 5}, {6, 2, 1, 4}, {3, 1, 1, 4}, {8, 5, 4, 3}}));
    exampleData.add(new Task1Data(0, 0, new Integer[][]{{2, 2, 2}, {2, 1, 2}, {2, 1, 2}, {2, 1, 2}}));
  }

  public void check(Task1Desc app, List<Task1Data> task1Data) throws IOException, ParseException {
    int rightCntBase = 0;
    int rightCntConf = 0;

    for (Task1Data data: exampleData) {
      if (data.getAnswer().equals(app.getWaterVolume(data.getIsland()))) {
        rightCntBase++;
      }
    }

    System.out.println(String.format("right base task1: %s", (double)rightCntBase*100/exampleData.size()));

    for (Task1Data checkData: task1Data) {
      try {
        if (checkData.getAnswer().equals(app.getWaterVolume(checkData.getIsland()))) {
          rightCntConf++;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    System.out.println(String.format("right conf task1: %s", (double)rightCntConf*100/task1Data.size()));
  }
}
