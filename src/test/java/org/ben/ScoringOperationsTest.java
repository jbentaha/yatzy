package org.ben;

import org.ben.calculator.CalculatorFactory;
import org.ben.calculator.ScoringOperations;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoringOperationsTest {

  private CalculatorFactory calculatorFactory = new CalculatorFactory(new ScoringOperations());

  @Test
  public void testOnesOperation() {
    List<Integer> twoOnes = List.of(1, 2, 4, 5, 1);
    List<Integer> noOnes = List.of(3, 2, 4, 5, 6);

    int twoOnesResult = calculatorFactory.getOperation(Categories.ONES).calculateScore(twoOnes);
    assertEquals(2, twoOnesResult, "Should return 2 : 1 + 1");

    int noOnesResult = calculatorFactory.getOperation(Categories.ONES).calculateScore(noOnes);
    assertEquals(0, noOnesResult, "Should return 0 : no 1 in the list");
  }

  @Test
  public void testTwosOperation() {
    List<Integer> threeTwos = List.of(1, 2, 2, 5, 2);
    List<Integer> oneTwo = List.of(1, 2, 4, 5, 1);
    List<Integer> noTwo = List.of(1, 1, 4, 5, 1);

    int threeTwosResult = calculatorFactory.getOperation(Categories.TWOS).calculateScore(threeTwos);
    assertEquals(6, threeTwosResult, "Should return 6 : 2 + 2 + 2");

    int oneTwosResult = calculatorFactory.getOperation(Categories.TWOS).calculateScore(oneTwo);
    assertEquals(2, oneTwosResult, "Should return 2 : one time occurrence");

    int noTwosResult = calculatorFactory.getOperation(Categories.TWOS).calculateScore(noTwo);
    assertEquals(0, noTwosResult, "Should return 0 : no occurrences");
  }

  @Test
  public void testThreesOperation() {
    List<Integer> twoThrees = List.of(3, 2, 3, 5, 2);
    List<Integer> oneThree = List.of(1, 2, 4, 3, 1);
    List<Integer> noThree = List.of(1, 1, 4, 5, 1);

    int multiResult = calculatorFactory.getOperation(Categories.THREES).calculateScore(twoThrees);
    assertEquals(6, multiResult, "Should return 6 : 3 + 3");

    int oneResult = calculatorFactory.getOperation(Categories.THREES).calculateScore(oneThree);
    assertEquals(3, oneResult, "Should return 3 : one time occurrence");

    int zeroResult = calculatorFactory.getOperation(Categories.THREES).calculateScore(noThree);
    assertEquals(0, zeroResult, "Should return 0 : no occurrences");
  }

  @Test
  public void testFoursOperation() {
    List<Integer> threeFours = List.of(3, 4, 4, 5, 4);
    List<Integer> oneFour = List.of(1, 2, 4, 3, 1);
    List<Integer> noFour = List.of(1, 1, 2, 5, 1);

    int multiResult = calculatorFactory.getOperation(Categories.FOURS).calculateScore(threeFours);
    assertEquals(12, multiResult, "Should return 12 : 4 + 4 + 4");

    int oneResult = calculatorFactory.getOperation(Categories.FOURS).calculateScore(oneFour);
    assertEquals(4, oneResult, "Should return 4 : one time occurrence");

    int zeroResult = calculatorFactory.getOperation(Categories.FOURS).calculateScore(noFour);
    assertEquals(0, zeroResult, "Should return 0 : no occurrences");
  }

  @Test
  public void testFivesOperation() {
    List<Integer> threeFives = List.of(5, 4, 5, 5, 6);
    List<Integer> oneFive = List.of(1, 2, 4, 3, 5);
    List<Integer> noFive = List.of(3, 1, 2, 4, 1);

    int multiResult = calculatorFactory.getOperation(Categories.FIVES).calculateScore(threeFives);
    assertEquals(15, multiResult, "Should return 15 : 5 + 5 + 5");

    int oneResult = calculatorFactory.getOperation(Categories.FIVES).calculateScore(oneFive);
    assertEquals(5, oneResult, "Should return 5 : one time occurrence");

    int zeroResult = calculatorFactory.getOperation(Categories.FIVES).calculateScore(noFive);
    assertEquals(0, zeroResult, "Should return 0 : no occurrences");
  }

  @Test
  public void testSixesOperation() {
    List<Integer> twoSixes = List.of(5, 4, 6, 5, 6);
    List<Integer> oneSix = List.of(1, 2, 4, 6, 5);
    List<Integer> noSix = List.of(3, 1, 2, 4, 1);

    int multiResult = calculatorFactory.getOperation(Categories.SIXES).calculateScore(twoSixes);
    assertEquals(12, multiResult, "Should return 12 : 6 + 6");

    int oneResult = calculatorFactory.getOperation(Categories.SIXES).calculateScore(oneSix);
    assertEquals(6, oneResult, "Should return 6 : one time occurrence");

    int zeroResult = calculatorFactory.getOperation(Categories.SIXES).calculateScore(noSix);
    assertEquals(0, zeroResult, "Should return 0 : no occurrences");
  }

}
