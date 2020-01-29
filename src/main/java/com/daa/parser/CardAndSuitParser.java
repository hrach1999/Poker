package com.daa.parser;

import com.daa.enums.Card;
import com.daa.enums.Configuration;
import com.daa.enums.Suit;
import com.daa.exceptions.InvalidValueException;
import com.daa.models.CardAndSuit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CardAndSuitParser {
    private CardAndSuitParser() {
    }

    public static List<List<CardAndSuit>> parseCardAndSuitForSelectedPlayer(int playerIndex) {
        if (playerIndex < 1 || playerIndex > 2)
            throw new IllegalArgumentException("Invalid player index is selected");
        return parseCardsProcess(playerIndex == 1);
    }

    private static List<List<CardAndSuit>> parseCardsProcess(boolean isSelectedFirstPlayer) {
        List<List<CardAndSuit>> playerCards = new ArrayList<>();
        String lineWithCards;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Configuration.INSTANCE.getPATH()))))) {
            while ((lineWithCards = reader.readLine()) != null) {
                if (lineWithCards.startsWith(" "))
                    continue;
                int indexOfHyphens = lineWithCards.indexOf(Configuration.INSTANCE.getDELIMITER());
                playerCards.add(parseStringToCardAndSuit(isSelectedFirstPlayer ? lineWithCards.substring(0, indexOfHyphens) : lineWithCards.substring(indexOfHyphens + 3)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return playerCards;
    }

    private static List<CardAndSuit> parseStringToCardAndSuit(String playerCards) throws InvalidValueException {
        List<CardAndSuit> result = null;
        String[] cards = playerCards.split(" ");
        for (String card : cards) {
            Suit playerSuit = Suit.getSuitByFirstLetter(card.charAt(0));
            Card playerCard = Card.getCardByFirstLetters(card.substring(1));
            if (playerSuit == null || playerCard == null)
                throw new InvalidValueException("Invalid suit or card");
            if (result == null)
                result = new ArrayList<>();
            result.add(new CardAndSuit(playerSuit, playerCard));
        }
        return result;
    }
}
