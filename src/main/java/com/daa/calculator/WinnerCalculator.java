package com.daa.calculator;

import com.daa.combination.CombinationCalculator;
import com.daa.enums.Card;
import com.daa.enums.Combination;
import com.daa.models.CardAndSuit;
import com.daa.models.CombinationWithHighCard;
import com.daa.models.Player;

import java.util.List;

public class WinnerCalculator {
    private WinnerCalculator() {
    }

    public static Player calculateWinner(Player firstPlayer, Player secondPlayer) {
        return calculateWinnerByCards(firstPlayer, secondPlayer);
    }

    private static Player calculateWinnerByCards(Player firstPlayer, Player secondPlayer) {
        int firstPlayerWinCount = 0;
        int secondPlayerWinCount = 0;
        CombinationWithHighCard firstPlayerCombinationWithHighCard;
        CombinationWithHighCard secondPlayerCombinationWithHighCard;
        List<List<CardAndSuit>> firstPlayerCards = firstPlayer.getPlayerCards();
        List<List<CardAndSuit>> secondPlayerCards = secondPlayer.getPlayerCards();
        for (int i = 0; i < firstPlayerCards.size(); i++) {
            firstPlayerCombinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(firstPlayerCards.get(i));
            secondPlayerCombinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(secondPlayerCards.get(i));
            if (firstPlayerCombinationWithHighCard.getCombination() == null) {
                if (secondPlayerCombinationWithHighCard.getCombination() == null) {
                    int result = firstPlayerCombinationWithHighCard.getHighCard().ordinal() - secondPlayerCombinationWithHighCard.getHighCard().ordinal();
                    if (result > 0)
                        firstPlayerWinCount++;
                    else if (result < 0)
                        secondPlayerWinCount++;
                } else {
                    secondPlayerWinCount++;
                }
            } else {
                if (secondPlayerCombinationWithHighCard.getCombination() == null)
                    firstPlayerWinCount++;
                else {
                    Combination firstPlayerCombination = firstPlayerCombinationWithHighCard.getCombination();
                    Combination secondPlayerCombination = secondPlayerCombinationWithHighCard.getCombination();
                    int result = firstPlayerCombination.ordinal() - secondPlayerCombination.ordinal();
                    if (result > 0)
                        firstPlayerWinCount++;
                    else if (result < 0)
                        secondPlayerWinCount++;
                    else {
                        Card firstPlayerHighCard = firstPlayerCombinationWithHighCard.getHighCard();
                        Card secondPlayerHighCard = secondPlayerCombinationWithHighCard.getHighCard();
                        result = firstPlayerHighCard.ordinal() - secondPlayerHighCard.ordinal();
                        if (result > 0)
                            firstPlayerWinCount++;
                        else if (result < 0)
                            secondPlayerWinCount++;
                    }
                }
            }
        }
        return firstPlayerWinCount > secondPlayerWinCount ? firstPlayer : secondPlayer;
    }
}
