package org.ben.calculator;

import java.util.List;
import java.util.function.Function;

@FunctionalInterface
public interface ScoringOperation {

    int calculateScore(List<Integer> diceValues);

}
