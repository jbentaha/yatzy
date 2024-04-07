package org.ben.calculator;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class ScoringOperations {

    /**
     * return only the sum of ones
     */
    private final ScoringOperation ones = diceValues -> (int) diceValues.stream()
            .filter(dice -> dice == 1)
            .count();

    /**
     * return only the sum of twos
     */
    private final ScoringOperation twos = diceValues -> diceValues.stream()
            .filter(dice -> dice == 2)
            .mapToInt(Integer::intValue)
            .sum();

    /**
     * return only the sum of threes
     */
    private final ScoringOperation threes = diceValues -> diceValues.stream()
            .filter(dice -> dice == 3)
            .mapToInt(Integer::intValue)
            .sum();

    /**
     * return only the sum of fours
     */
    private final ScoringOperation fours = diceValues -> diceValues.stream()
            .filter(dice -> dice == 4)
            .mapToInt(Integer::intValue)
            .sum();

    /**
     * return only the sum of fives
     */
    private final ScoringOperation fives = diceValues -> diceValues.stream()
            .filter(dice -> dice == 5)
            .mapToInt(Integer::intValue)
            .sum();

    /**
     * return only the sum of sixes
     */
    private final ScoringOperation sixes = diceValues -> diceValues.stream()
            .filter(dice -> dice == 6)
            .mapToInt(Integer::intValue)
            .sum();

    /**
     * return the sum of all dices
     */
    private final ScoringOperation chance = diceValues -> diceValues.stream()
                .mapToInt(Integer::intValue)
                .sum();

    /**
     * return the sum of first two matching dices, otherwise 0
     */
    private final ScoringOperation pair = diceValues -> {
        int[] counts = new int[6];
        diceValues.forEach(dice -> counts[dice - 1]++);

        OptionalInt pairIndex = IntStream.range(0, 6)
                .filter(i -> counts[6 - i - 1] >= 2)
                .findFirst();

        return pairIndex.isPresent() ? (6 - pairIndex.getAsInt()) * 2 : 0;
    };

    /**
     * return the sum of the two pairs of dice with the same number, otherwise 0
     */
    private final ScoringOperation twoPair = diceValues -> {
        int[] counts = new int[6];
        diceValues.forEach(die -> counts[die - 1]++);

        int pairsFound = (int) IntStream.range(0, 6)
                .filter(i -> counts[6 - i - 1] >= 2)
                .count();

        if (pairsFound == 2) {
            return IntStream.range(0, 6)
                    .filter(i -> counts[6 - i - 1] >= 2)
                    .map(i -> (6 - i) * 2)
                    .sum();
        } else {
            return 0;
        }
    };

    /**
     * return if exists, the sum of three dices with same number, otherwise 0
     */
    private final ScoringOperation threeOfKind = diceValues -> {
        int[] counts = new int[6];
        diceValues.forEach(die -> counts[die - 1]++);

        return IntStream.range(0, 6)
                .filter(i -> counts[i] >= 3)
                .map(i -> (i + 1) * 3)
                .findFirst()
                .orElse(0);
    };

    /**
     * return if exists, the sum of four dices with same number, otherwise 0
     */
    private final ScoringOperation fourOfKind = diceValues -> {
        int[] counts = new int[6];
        diceValues.forEach(die -> counts[die - 1]++);

        return IntStream.range(0, 6)
                .filter(i -> counts[i] >= 4)
                .map(i -> (i + 1) * 4)
                .findFirst()
                .orElse(0);
    };

    /**
     * return the sum of straight dices starting from 1 (1,2,3,4,5), otherwise 0
     */
    private final ScoringOperation smallStraight = diceValues -> {
        Set<Integer> uniqueValues = new HashSet<>(diceValues);

        int minValue = uniqueValues.stream().mapToInt(Integer::intValue).min().getAsInt();

        if (uniqueValues.size() == 5 && minValue == 1) {
            return 15;
        }

        return 0;
    };

    /**
     * return the sum of straight dices starting from 2 (2,3,4,5,6), otherwise 0
     */
    private final ScoringOperation largeStraight = diceValues -> {
        Set<Integer> uniqueValues = new HashSet<>(diceValues);

        int minValue = uniqueValues.stream().mapToInt(Integer::intValue).min().getAsInt();

        if (uniqueValues.size() == 5 && minValue == 2) {
            return 20;
        }

        return 0;
    };

    /**
     * return 50 if all dices have the same value, otherwise 0
     */
    private final ScoringOperation yatzy = diceValues -> {
        int[] counts = new int[6];
        diceValues.forEach(die -> counts[die - 1]++);

        return IntStream.of(counts)
                .anyMatch(count -> count == 5) ? 50 : 0;
    };

    /**
     * return the sum of all dices if they are two of a kind and three of a kind
     */
    private final ScoringOperation fullHouse = diceValues -> {
        Map<Integer, Long> counts = diceValues.stream()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        int valueTwo = 0;
        int valueThree = 0;

        for (Map.Entry<Integer, Long> entry : counts.entrySet()) {
            int value = entry.getKey();
            long count = entry.getValue();
            if (count == 2) {
                valueTwo = value;
            } else if (count == 3) {
                valueThree = value;
            }
        }

        if(valueTwo != 0 && valueThree != 0) {
            return valueTwo * 2 + valueThree * 3;
        }

        return 0;
    };

}
