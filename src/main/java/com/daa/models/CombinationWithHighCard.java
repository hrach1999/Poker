package com.daa.models;

import com.daa.enums.Card;
import com.daa.enums.Combination;

public class CombinationWithHighCard {
    private Card highCard;
    private Combination combination;

    public CombinationWithHighCard(Card highCard, Combination combination) {
        this.highCard = highCard;
        this.combination = combination;
    }

    public Card getHighCard() {
        return highCard;
    }

    public void setHighCard(Card highCard) {
        this.highCard = highCard;
    }

    public Combination getCombination() {
        return combination;
    }

    public void setCombination(Combination combination) {
        this.combination = combination;
    }
}
