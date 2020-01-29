package com.daa.enums;

public enum Combination {
    PAIR("Pair"),
    TWO_PAIR("Two Pair"),
    THREE_OF_A_KIND("Three of a kind"),
    STRAIGHT("Straight"),
    FLUSH("Flush"),
    FULL_HOUSE("Full House"),
    FOUR_OF_A_KIND("Four of a kind"),
    STRAIGHT_FLUSH("Straight flush"),
    ROYAL_FLUSH("Royal Flush");

    private String name;

    Combination(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}