package ru.vsu.sc.tretyakov_d_s.Solution;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.sc.tretyakov_d_s.Solution.Solution;
import ru.vsu.sc.tretyakov_d_s.Utils.ArrayUtils;

public class SolutionTest {

  @Test
  public void testOne() {

    boolean correctResult = true;
    Solution solution = new Solution();

    int[][] array = ArrayUtils.readIntArray2FromFile("src/ru/vsu/sc/tretyakov_d_s/Matrix/FirstMatrix.txt");

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }

  @Test
  public void testSecond() {

    boolean correctResult = false;
    Solution solution = new Solution();

    int[][] array = ArrayUtils.readIntArray2FromFile("src/ru/vsu/sc/tretyakov_d_s/Matrix/SecondMatrix.txt");

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }

  @Test
  public void testThird() {

    boolean correctResult = true;
    Solution solution = new Solution();

    int[][] array = ArrayUtils.readIntArray2FromFile("src/ru/vsu/sc/tretyakov_d_s/Matrix/ThirdMatrix.txt");

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }

  @Test
  public void testFourth() {

    boolean correctResult = true;
    Solution solution = new Solution();

    int[][] array = new int[][] {
        {1, 2, 3, 4, 5},
        {16, 17, 18, 19, 6},
        {15, 24, 25, 20, 7},
        {14, 23, 22, 21, 8},
        {13, 12, 11, 10, 9}
    };

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }

  @Test
  public void testFifth() {

    boolean correctResult = true;
    Solution solution = new Solution();

    int[][] array = new int[][] {
        {1, 2, 3, 4, 5},
        {16, 17, 18, 19, 6},
        {15, 24, 25, 20, 7},
        {14, 23, 22, 21, 8},
        {13, 12, 11, 10, 9}
    };

    boolean currentResult = solution.checkArrayForSequence(array);
    Assert.assertEquals(correctResult, currentResult);
  }


}