package org.ben.calculator;

import lombok.Getter;

@Getter
public class ScoringOperations {

    private final ScoringOperation ones = diceValues -> (int) diceValues.stream()
            .filter(dice -> dice == 1)
            .count();

    private final ScoringOperation twos = diceValues -> diceValues.stream()
            .filter(dice -> dice == 2)
            .mapToInt(Integer::intValue)
            .sum();

    private final ScoringOperation threes = diceValues -> diceValues.stream()
            .filter(dice -> dice == 3)
            .mapToInt(Integer::intValue)
            .sum();

    private final ScoringOperation fours = diceValues -> diceValues.stream()
            .filter(dice -> dice == 4)
            .mapToInt(Integer::intValue)
            .sum();

    private final ScoringOperation fives = diceValues -> diceValues.stream()
            .filter(dice -> dice == 5)
            .mapToInt(Integer::intValue)
            .sum();

    private final ScoringOperation sixes = diceValues -> diceValues.stream()
            .filter(dice -> dice == 6)
            .mapToInt(Integer::intValue)
            .sum();

    private final ScoringOperation chance = diceValues -> {
        return 0;
    };

    private final ScoringOperation pair = diceValues -> {
        return 0;
    };

    private final ScoringOperation twoPair = diceValues -> {
        return 0;
    };

    private final ScoringOperation threeOfKind = diceValues -> {
        return 0;
    };

    private final ScoringOperation fourOfKind = diceValues -> {
        return 0;
    };

    private final ScoringOperation smallStraight = diceValues -> {
        return 0;
    };

    private final ScoringOperation largeStraight = diceValues -> {
        return 0;
    };

    private final ScoringOperation yatzy = diceValues -> {
        return 0;
    };

    private final ScoringOperation fullHouse = diceValues -> {
        return 0;
    };

}
