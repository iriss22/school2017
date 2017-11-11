package ru.hh.school2017.decisions;

import ru.hh.school2017.check.Task1Desc;
import java.util.Arrays;

public class TropicalIsland implements Task1Desc {
  @Override
  public int getWaterVolume(Integer[][] island) {
    // Определяем длину и ширину острова
    int length = island.length;
    int width = island[0].length;

    // Инициируем новый осторов и заливаем (кроме краев, остров затоплен водой по самую высокую точку)
    Integer[][] floodedIsland = new Integer[length][width];
    int max = Arrays.stream(island).flatMap(Arrays::stream).max(Integer::compareTo).get();

    for (int row = 0; row < length; row++) {
      for (int col = 0; col < width; col++) {
        if (row == 0 || row == length - 1 || col == 0 || col == width - 1){
          floodedIsland[row][col] = island[row][col];
        }else{
          floodedIsland[row][col] = max;
        }
      }
    }

    // "Сливаем" остров
    boolean isChange = true;
    while (isChange) {
      isChange = false;
      for (int row = 1; row < length - 1; row++) {
        for (int col = 1; col < width - 1; col++) {
          if (floodedIsland[row][col] != island[row][col]) {
            int minHeight = getMinHeight(floodedIsland, row, col);
            if (floodedIsland[row][col] > minHeight) {
              // учитываем высоту точки
              if (island[row][col] < minHeight) {
                floodedIsland[row][col] = minHeight;
              } else {
                floodedIsland[row][col] = island[row][col];
              }
              isChange = true;
            }
          }
        }
      }
    }

    int waterCnt = 0;
    for (int row = 1; row < length - 1; row++) {
      for (int col = 1; col < width - 1; col++) {
        waterCnt += floodedIsland[row][col] - island[row][col];
      }
    }

    return waterCnt;
  }

  private int getMinHeight(Integer[][] island, int row, int col) {
    return Arrays.stream(new int[]{
        island[row-1][col],
        island[row][col-1],
        island[row+1][col],
        island[row][col+1]
    }).min().getAsInt();
  }
}
