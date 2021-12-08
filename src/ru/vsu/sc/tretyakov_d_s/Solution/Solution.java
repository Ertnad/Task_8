package ru.vsu.sc.tretyakov_d_s.Solution;

public class Solution {

  ArrayDirection arrayDirection;

  public boolean checkArrayForSequence(int[][] array) {

    int i = 0;
    int startingRowIndex = 0;
    int startingColumnIndex = 0;
    int endingRowIndex = array.length;
    int endingColumnIndex = array[0].length;
    int previousElement = 0;

    previousElement = checkArrayForAscendingOrDescending(array, previousElement);

    while (startingRowIndex < endingRowIndex && startingColumnIndex < endingColumnIndex) {

      if (checkFirstRowFromRemaining(array, i, startingColumnIndex, endingColumnIndex,previousElement,startingRowIndex)) {
        startingRowIndex++;
      } else {
        return false;
      }

      if (checkLastColumnFromRemaining(array, i, endingRowIndex, endingColumnIndex, previousElement, startingRowIndex)) {
        endingColumnIndex--;
      } else {
        return false;
      }

      if (startingRowIndex < endingRowIndex) {
        if(checkLastRowFromRemaining(array, i, startingColumnIndex, endingColumnIndex, previousElement, endingRowIndex)) {
          endingRowIndex--;
        } else {
          return false;
        }
      }

      if (startingColumnIndex < endingColumnIndex) {
        if (checkFirstColumnFromRemaining(array, i, startingColumnIndex, endingRowIndex, previousElement, startingRowIndex)) {
          startingColumnIndex++;
        } else {
          return false;
        }
      }
    }
      return true;
  }

  private int checkArrayForAscendingOrDescending(int[][] array, int previousElement) {
    if (array.length > 1) {
      if (array[array.length - 1][0] > array[array.length - 2][0]) {
        arrayDirection = ArrayDirection.DECREASING;
        previousElement = 9999;
      } else {
        arrayDirection = ArrayDirection.INCREASING;
        previousElement = -9999;
      }
    }
    return previousElement;
  }

  private boolean checkFirstRowFromRemaining(int[][] array, int i, int startingColumnIndex,
      int endingColumnIndex, int previousElement, int startingRowIndex) {
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
    return true;
  }

  private boolean checkLastRowFromRemaining(int[][] array, int i, int startingColumnIndex,
      int endingColumnIndex, int previousElement, int endingRowIndex) {
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
    return true;
  }

  private boolean checkFirstColumnFromRemaining(int[][] array, int i, int startingColumnIndex,
      int endingRowIndex, int previousElement, int startingRowIndex) {
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
    return true;
  }

  private boolean checkLastColumnFromRemaining(int[][] array, int i, int endingRowIndex,
      int endingColumnIndex, int previousElement, int startingRowIndex) {
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
    return true;
  }

}