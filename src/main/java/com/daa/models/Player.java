package com.daa.models;

import java.util.List;

public class Player {
    private String name;
    private String surname;
    private List<List<CardAndSuit>> playerCards;

    public Player(String name, String surname, List<List<CardAndSuit>> playerCards) {
        this.name = name;
        this.surname = surname;
        this.playerCards = playerCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<List<CardAndSuit>> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<List<CardAndSuit>> playerCards) {
        this.playerCards = playerCards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", playerCards=" + playerCards +
                '}';
    }
}
