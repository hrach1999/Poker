package com.daa.models;

import com.daa.enums.Card;
import com.daa.enums.Suit;

public class CardAndSuit {
    private Suit suit;
    private Card card;

    public CardAndSuit(Suit suit, Card card) {
        this.suit = suit;
        this.card = card;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "CardAndSuit{" +
                "suit=" + suit +
                ", card=" + card +
                '}';
    }
}
