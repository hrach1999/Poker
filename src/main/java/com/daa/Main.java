package com.daa;

import com.daa.calculator.WinnerCalculator;
import com.daa.models.Player;
import com.daa.parser.CardAndSuitParser;

public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new Player("TestFirstName", "TestSecondName", CardAndSuitParser.parseCardAndSuitForSelectedPlayer(1));
        Player secondPlayer = new Player("TestSecondFirstName", "TestSecondLastName", CardAndSuitParser.parseCardAndSuitForSelectedPlayer(2));
        System.out.println(WinnerCalculator.calculateWinner(firstPlayer, secondPlayer));
    }
}
