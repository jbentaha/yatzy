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
                return scoringOperations.getChanceOperation();
            }

            case YATZY -> {
                return scoringOperations.getYatzyOperation();
            }

            case ONES ->{
                return scoringOperations.getOnesOperation();
            }

            case TWOS -> {
                return scoringOperations.getTwosOperation();
            }

            case THREES -> {
                return scoringOperations.getThreesOperation();
            }

            case FOURS -> {
                return scoringOperations.getFoursOperation();
            }

            case FIVES -> {
                return scoringOperations.getFivesOperation();
            }

            case SIXES -> {
                return scoringOperations.getSixesOperation();
            }

            case PAIR -> {
                return scoringOperations.getPairOperation();
            }

            case TWO_PAIRS -> {
                return scoringOperations.getTwoPairOperation();
            }

            case THREE_OF_KIND -> {
                return scoringOperations.getThreeOfKindOperation();
            }

            case FOUR_OF_KINd -> {
                return scoringOperations.getFourOfKindOperation();
            }

            case SMALL_STRAIGHT -> {
                return scoringOperations.getSmallStraightOperation();
            }

            case LARGE_STRAIGHT -> {
                return scoringOperations.getLargeStraightOperation();
            }

            case FULL_HOUSE -> {
                return scoringOperations.getFullHouseOperation();
            }

            default -> {
                return null;
            }
        }
    }

}
