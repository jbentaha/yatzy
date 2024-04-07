package org.ben.calculator;

import org.ben.Categories;

public class CalculatorFactory {

    private final ScoringOperations scoringOperations;

    public CalculatorFactory(ScoringOperations scoringOperations) {
        this.scoringOperations = scoringOperations;
    }

    public ScoringOperation getOperation(Categories category) {
        switch (category) {
            case CHANCE -> {
                return scoringOperations.getChance();
            }

            case YATZY -> {
                return scoringOperations.getYatzy();
            }

            case ONES ->{
                return scoringOperations.getOnes();
            }

            case TWOS -> {
                return scoringOperations.getTwos();
            }

            case THREES -> {
                return scoringOperations.getThrees();
            }

            case FOURS -> {
                return scoringOperations.getFours();
            }

            case FIVES -> {
                return scoringOperations.getFives();
            }

            case SIXES -> {
                return scoringOperations.getSixes();
            }

            case PAIR -> {
                return scoringOperations.getPair();
            }

            case TWO_PAIRS -> {
                return scoringOperations.getTwoPair();
            }

            case THREE_OF_KIND -> {
                return scoringOperations.getThreeOfKind();
            }

            case FOUR_OF_KIND -> {
                return scoringOperations.getFourOfKind();
            }

            case SMALL_STRAIGHT -> {
                return scoringOperations.getSmallStraight();
            }

            case LARGE_STRAIGHT -> {
                return scoringOperations.getLargeStraight();
            }

            case FULL_HOUSE -> {
                return scoringOperations.getFullHouse();
            }

            default -> {
                return null;
            }
        }
    }

}
