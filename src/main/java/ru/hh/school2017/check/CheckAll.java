package ru.hh.school2017.check;

import ru.hh.school2017.decisions.InfiniteSequence;
import ru.hh.school2017.decisions.TropicalIsland;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import ru.hh.school2017.check.data.TestData;

public class CheckAll {

  public static void main(String[] str) throws IOException, ParseException {
    Task1Desc des1 = new TropicalIsland();
    Task2Desc des2 = new InfiniteSequence();

    TestData testData = ConfigReader.getTestData();

    Task1 task1 = new Task1();
    task1.check(des1, testData.getTask1Data());

    Task2 task2 = new Task2();
    task2.check(des2, testData.getTask2Data());
  }
}
