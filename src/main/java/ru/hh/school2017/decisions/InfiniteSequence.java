package ru.hh.school2017.decisions;

import ru.hh.school2017.check.Task2Desc;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InfiniteSequence implements Task2Desc {
  @Override
  public long findSequence(String str) {
    int strLen = str.length();
    int maxNumRank = strLen;

    if (new BigDecimal(str).equals(BigDecimal.ZERO)) {
      return getPosition(new BigDecimal("1"+str), 0, strLen) + 1;
    }

    for (int numLen = 1; numLen <= maxNumRank; numLen++) {
      List<Long> positions = new ArrayList<>();
      for (int shift = 0; shift < numLen; shift++) {
        // число не может начинаться с 0
        if (str.charAt(shift) == '0') {
          continue;
        }
        BigDecimal firstNum;
        if (numLen + shift <= maxNumRank) {
          firstNum = new BigDecimal(str.substring(shift, shift + numLen));
        } else {
          String greatRanks = str.substring(shift, maxNumRank);
          String lessRanksPrev = str.substring(maxNumRank - numLen, shift);
          DecimalFormat df = new DecimalFormat(String.format("%0" + numLen + "d", 0));
          String lessRanks = df.format(new BigDecimal(lessRanksPrev).add(BigDecimal.ONE))
              .substring(numLen - lessRanksPrev.length(), numLen);
          firstNum = new BigDecimal(greatRanks + lessRanks);
        }

        // сравниваю первое число и хвост предыдущего
        String firstNumMinus1 = String.valueOf(firstNum.subtract(BigDecimal.ONE));
        if (shift != 0 &&
            !firstNumMinus1.substring(firstNumMinus1.length() - shift).equals(str.substring(0, shift))) {
           continue;
        }

        boolean isFound = true;
        int j = shift;
        int numLenForIter = numLen;
        BigDecimal firstNumForIter = firstNum;

        // прохожусь по всей строке
        while (j < strLen - numLenForIter) {
          j += numLenForIter;
          if (firstNumForIter.equals(new BigDecimal(Math.pow(10, numLenForIter) - 1))) {
            numLenForIter += 1;
          }
          if (j + numLenForIter <= strLen) {
            // сравниваю два числа
            BigDecimal secondNum = new BigDecimal(str.substring(j, j + numLenForIter));
            if (!firstNumForIter.add(BigDecimal.ONE).equals(secondNum)) {
              isFound = false;
              break;
            }
            firstNumForIter = secondNum;
          } else {
            // сравниваю число и начало следующего числа
            DecimalFormat df = new DecimalFormat(String.format("%0" + numLenForIter + "d", 0));
            if (!df.format(firstNumForIter.add(BigDecimal.ONE)).substring(0, strLen - j).equals(str.substring(j))) {
              isFound = false;
              break;
            }
            return getPosition(firstNum, shift, numLen);
          }
        }
        if (isFound) {
          positions.add(getPosition(firstNum, shift, numLen));
        }
      }
      if (!positions.isEmpty()) {
        return Collections.min(positions);
      }
    }
    return -1;
  }

  private long getPosition(BigDecimal num, int shift, int numLen) {
    int minus = 0;
    for (int i = 1; i < numLen; i++) {
      minus += Math.pow(10, i);
    }
    return num.multiply(new BigDecimal(numLen)).subtract(new BigDecimal(minus)).subtract(new BigDecimal(shift)).longValue();
  }
}
