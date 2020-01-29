package com.daa.enums;

public enum Suit {
    HEART("Heart"),
    SPADE("Spade"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds");

    private String name;

    Suit(String name) {
        this.name = name;
    }

    public static Suit getSuitByFirstLetter(char firstLetter) {
        for (Suit suit : values()) {
            if (suit.getName().charAt(0) == firstLetter)
                return suit;
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
