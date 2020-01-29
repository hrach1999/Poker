package com.daa.enums;

import com.daa.util.StringUtil;

public enum Card {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace");

    private String name;

    Card(String name) {
        this.name = name;
    }

    public static Card getCardByFirstLetters(String firstLetters) {
        for (Card card : values()) {
            boolean isInteger = StringUtil.isInteger(firstLetters, 10);
            if (isInteger) {
                if (card.getName().equalsIgnoreCase(firstLetters))
                    return card;
            } else {
                if (card.getName().substring(0, 1).equalsIgnoreCase(firstLetters))
                    return card;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
