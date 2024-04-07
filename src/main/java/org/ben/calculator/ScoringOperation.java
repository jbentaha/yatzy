package org.ben.calculator;

import java.util.List;

@FunctionalInterface
public interface ScoringOperation {

    int calculateScore(List<Integer> diceValues);

}
