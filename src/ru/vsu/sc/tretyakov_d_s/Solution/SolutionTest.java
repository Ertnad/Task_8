package ru.vsu.sc.tretyakov_d_s.Solution;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.sc.tretyakov_d_s.Utils.ArrayUtils;

public class SolutionTest {

  @Test
  public void testOne() {

    boolean correctResult = true;
    Solution solution = new Solution();

    int[][] array = ArrayUtils.readIntArray2FromFile("testFiles/input01.txt");

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }

  @Test
  public void testSecond() {

    boolean correctResult = true;
    Solution solution = new Solution();

    int[][] array = ArrayUtils.readIntArray2FromFile("testFiles/input02.txt");

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }

  @Test
  public void testThird() {

    boolean correctResult = false;
    Solution solution = new Solution();

    int[][] array = ArrayUtils.readIntArray2FromFile("testFiles/input03.txt");

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }

  @Test
  public void testFourth() {

    boolean correctResult = false;
    Solution solution = new Solution();

    int[][] array = ArrayUtils.readIntArray2FromFile("testFiles/input04.txt");

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }

  @Test
  public void testFifth() {

    boolean correctResult = true;
    Solution solution = new Solution();

    int[][] array = ArrayUtils.readIntArray2FromFile("testFiles/input05.txt");

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }


}