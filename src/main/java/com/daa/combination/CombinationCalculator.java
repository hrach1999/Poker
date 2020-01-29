package com.daa.combination;

import com.daa.enums.Card;
import com.daa.enums.Combination;
import com.daa.models.CardAndSuit;
import com.daa.models.CombinationWithHighCard;

import java.util.*;

public class CombinationCalculator {
    private CombinationCalculator() {
    }

    public static CombinationWithHighCard getCombinationWithHighCard(List<CardAndSuit> cardAndSuits) {
        return new CombinationWithHighCard(Calculator.getHighCard(cardAndSuits), getCombination(cardAndSuits));
    }

    private static Combination getCombination(List<CardAndSuit> cardAndSuits) {
        if (Calculator.isCombinationRoyalFlush(cardAndSuits))
            return Combination.ROYAL_FLUSH;
        if (Calculator.isCombinationStraightFlush(cardAndSuits))
            return Combination.STRAIGHT_FLUSH;
        if (Calculator.isCombinationFourOfaKind(cardAndSuits))
            return Combination.FOUR_OF_A_KIND;
        if (Calculator.isCombinationFullHouse(cardAndSuits))
            return Combination.FULL_HOUSE;
        if (Calculator.isCombinationFlush(cardAndSuits))
            return Combination.FLUSH;
        if (Calculator.isCombinationStraight(cardAndSuits))
            return Combination.STRAIGHT;
        if (Calculator.isCombinationThreeOfaKind(cardAndSuits))
            return Combination.THREE_OF_A_KIND;
        if (Calculator.isCombinationTwoPair(cardAndSuits))
            return Combination.TWO_PAIR;
        if (Calculator.isCombinationPair(cardAndSuits))
            return Combination.PAIR;
        return null;
    }

    static class Calculator {
        private static boolean isCombinationRoyalFlush(List<CardAndSuit> cardAndSuits) {
            if (!isCombinationFlush(cardAndSuits))
                return false;
            Sorter.sortCards(cardAndSuits);
            int startIndex = -1;
            for (int i = 0, index = 9; i < cardAndSuits.size(); i++) {
                if (startIndex == -1) {
                    startIndex = cardAndSuits.get(i).getCard().ordinal();
                    if (startIndex != 8)
                        return false;
                } else {
                    if ((startIndex = cardAndSuits.get(i).getCard().ordinal()) != index++)
                        return false;
                }
            }
            return true;
        }

        private static boolean isCombinationStraightFlush(List<CardAndSuit> cardAndSuits) {
            if (!isCombinationFlush(cardAndSuits))
                return false;
            Sorter.sortCards(cardAndSuits);
            int startIndex = -1;
            for (CardAndSuit cardAndSuit : cardAndSuits) {
                if (startIndex == -1)
                    startIndex = cardAndSuit.getCard().ordinal();
                else {
                    if (cardAndSuit.getCard().ordinal() != ++startIndex)
                        return false;
                }
            }
            return true;
        }

        private static boolean isCombinationFourOfaKind(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return false;
            Sorter.sortCards(cardAndSuits);
            List<Set<Card>> listOfSet = new ArrayList<>();
            List<CardAndSuit> tempCardAndSuits = new ArrayList<>();
            for (int i = 0; i < cardAndSuits.size(); i++) {
                for (int j = 0; j < cardAndSuits.size(); j++) {
                    if (j != i)
                        tempCardAndSuits.add(cardAndSuits.get(j));
                }
                listOfSet.add(Util.parseCardAndSuitsToCard(tempCardAndSuits));
                tempCardAndSuits.clear();
            }
            for (Set<Card> cards : listOfSet) {
                if (cards.size() == 1)
                    return true;
            }
            return false;
        }

        private static boolean isCombinationFullHouse(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return false;
            Map<Card, Integer> cardRepeat = new HashMap<>();
            Set<Card> setOfCards = Util.parseCardAndSuitsToCard(cardAndSuits);
            if (setOfCards.size() > 2)
                return false;
            for (Card card : setOfCards)
                cardRepeat.put(card, 0);
            for (Card card : setOfCards) {
                for (CardAndSuit cardAndSuit : cardAndSuits) {
                    if (card.ordinal() == cardAndSuit.getCard().ordinal())
                        cardRepeat.put(card, cardRepeat.get(card) + 1);
                }
            }
            for (Integer value : cardRepeat.values()) {
                if (value != 2 && value != 3)
                    return false;
            }
            return true;
        }

        private static boolean isCombinationFlush(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return false;
            int firstCardSuitOrdinal = cardAndSuits.get(0).getSuit().ordinal();
            for (int i = 1; i < cardAndSuits.size(); i++) {
                if (cardAndSuits.get(i).getSuit().ordinal() != firstCardSuitOrdinal)
                    return false;
            }
            return true;
        }

        private static boolean isCombinationStraight(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return false;
            Sorter.sortCards(cardAndSuits);
            int startIndex = -1;
            for (CardAndSuit cardAndSuit : cardAndSuits) {
                if (startIndex == -1)
                    startIndex = cardAndSuit.getCard().ordinal();
                else {
                    if (cardAndSuit.getCard().ordinal() != ++startIndex)
                        return false;
                }
            }
            return true;
        }

        private static boolean isCombinationThreeOfaKind(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return false;
            Map<Card, Integer> cardRepeat = new HashMap<>();
            Set<Card> setOfCards = Util.parseCardAndSuitsToCard(cardAndSuits);
            for (Card card : setOfCards)
                cardRepeat.put(card, 0);
            for (Card card : setOfCards) {
                for (CardAndSuit cardAndSuit : cardAndSuits) {
                    if (card.ordinal() == cardAndSuit.getCard().ordinal())
                        cardRepeat.put(card, cardRepeat.get(card) + 1);
                }
            }
            for (Integer value : cardRepeat.values()) {
                if (value == 3)
                    return true;
            }
            return false;
        }

        private static boolean isCombinationTwoPair(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return false;
            Map<Card, Integer> cardRepeat = new HashMap<>();
            Set<Card> setOfCards = Util.parseCardAndSuitsToCard(cardAndSuits);
            for (Card card : setOfCards)
                cardRepeat.put(card, 0);
            for (Card card : setOfCards) {
                for (CardAndSuit cardAndSuit : cardAndSuits) {
                    if (card.ordinal() == cardAndSuit.getCard().ordinal())
                        cardRepeat.put(card, cardRepeat.get(card) + 1);
                }
            }
            int counter = 0;
            for (Integer value : cardRepeat.values()) {
                if (value == 2)
                    counter++;
            }
            return counter == 2;
        }

        private static boolean isCombinationPair(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return false;
            Map<Card, Integer> cardRepeat = new HashMap<>();
            Set<Card> setOfCards = Util.parseCardAndSuitsToCard(cardAndSuits);
            for (Card card : setOfCards)
                cardRepeat.put(card, 0);
            for (Card card : setOfCards) {
                for (CardAndSuit cardAndSuit : cardAndSuits) {
                    if (card.ordinal() == cardAndSuit.getCard().ordinal())
                        cardRepeat.put(card, cardRepeat.get(card) + 1);
                }
            }
            int counter = 0;
            for (Integer value : cardRepeat.values()) {
                if (value == 2)
                    counter++;
            }
            return counter == 1;
        }

        public static Card getHighCard(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return null;
            Card result = null;
            for (CardAndSuit cardAndSuit : cardAndSuits) {
                if (result == null)
                    result = cardAndSuit.getCard();
                else {
                    if (cardAndSuit.getCard().ordinal() > result.ordinal())
                        result = cardAndSuit.getCard();
                }
            }
            return result;
        }
    }

    static class Sorter {
        private static void sortCards(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return;
            for (int i = 0; i < cardAndSuits.size(); i++) {
                for (int j = 1; j < cardAndSuits.size() - i; j++) {
                    if (cardAndSuits.get(j - 1).getCard().ordinal() > cardAndSuits.get(j).getCard().ordinal()) {
                        CardAndSuit cardAndSuit = cardAndSuits.get(j - 1);
                        cardAndSuits.set(j - 1, cardAndSuits.get(j));
                        cardAndSuits.set(j, cardAndSuit);
                    }
                }
            }
        }
    }

    static class Util {
        private static Set<Card> parseCardAndSuitsToCard(List<CardAndSuit> cardAndSuits) {
            if (cardAndSuits == null)
                return null;
            Set<Card> cards = new HashSet<>();
            for (CardAndSuit cardAndSuit : cardAndSuits) {
                cards.add(cardAndSuit.getCard());
            }
            return cards;
        }
    }
}
