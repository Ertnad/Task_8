package ru.vsu.sc.tretyakov_d_s.Solution;

public class Solution {

  ArrayDirection arrayDirection;

  public boolean checkArrayForSequence(int[][] array) {

    int i;
    int startingRowIndex = 0;
    int startingColumnIndex = 0;
    int endingRowIndex = array.length;
    int endingColumnIndex = array[0].length;
    int previousElement = 0;


    if (array.length > 1) {
      if (array[array.length - 1][0] > array[array.length - 2][0]) {
        arrayDirection = ArrayDirection.DECREASING;
        previousElement = 9999;
      } else {
        arrayDirection = ArrayDirection.INCREASING;
        previousElement = -9999;
      }
    } else if (array[0].length > 1) {
      if (array[0][0] > array[0][1]) {
        arrayDirection = ArrayDirection.DECREASING;
        previousElement = 9999;
      } else {
        arrayDirection = ArrayDirection.INCREASING;
        previousElement = -9999;
      }
    } else {
      return true;
    }

    while (startingRowIndex < endingRowIndex && startingColumnIndex < endingColumnIndex) {

      for (i = startingColumnIndex; i < endingColumnIndex; ++i) {
        switch (arrayDirection) {
          case INCREASING -> {
            if (previousElement > array[startingRowIndex][i]) {
              return false;
            }
          }
          case DECREASING -> {
            if (previousElement < array[startingRowIndex][i])
              return false;
          }
        }
        previousElement = array[startingRowIndex][i];
      }
      startingRowIndex++;

      for (i = startingRowIndex; i < endingRowIndex; ++i) {
        switch (arrayDirection) {
          case INCREASING -> {
            if (previousElement > array[i][endingColumnIndex - 1]) {
              return false;
            }
          }
          case DECREASING -> {
            if (previousElement < array[i][endingColumnIndex - 1]) {
              return false;
            }
          }
        }
        previousElement = array[i][endingColumnIndex - 1];
      }
      endingColumnIndex--;

      if (startingRowIndex < endingRowIndex) {
        for (i = endingColumnIndex - 1; i >= startingColumnIndex; --i) {
          switch (arrayDirection) {
            case INCREASING -> {
              if (previousElement > array[endingRowIndex - 1][i]) {
                return false;
              }
            }
            case DECREASING -> {
              if (previousElement < array[endingRowIndex - 1][i]) {
                return false;
              }
            }
          }
          previousElement = array[endingRowIndex - 1][i];
        }
        endingRowIndex--;
      }

      if (startingColumnIndex < endingColumnIndex) {
        for (i = endingRowIndex - 1; i >= startingRowIndex; --i) {
          switch (arrayDirection) {
            case INCREASING -> {
              if (previousElement > array[i][startingColumnIndex]) {
                return false;
              }
            }
            case DECREASING -> {
              if (previousElement < array[i][startingColumnIndex]) {
                return false;
              }
            }
          }
          previousElement = array[i][startingColumnIndex];
        }
        startingColumnIndex++;
      }
    }
      return true;
  }
}