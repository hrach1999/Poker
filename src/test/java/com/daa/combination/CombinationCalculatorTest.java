package com.daa.combination;

import com.daa.enums.Card;
import com.daa.enums.Combination;
import com.daa.enums.Suit;
import com.daa.models.CardAndSuit;
import com.daa.models.CombinationWithHighCard;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationCalculatorTest {

    private static List<List<CardAndSuit>> cards = new ArrayList<>();

    @BeforeClass
    public static void initCardAndSuitsForTesting() {
        //royal flush
        cards.add(Arrays.asList(new CardAndSuit(Suit.CLUBS, Card.TEN), new CardAndSuit(Suit.CLUBS, Card.JACK),
                new CardAndSuit(Suit.CLUBS, Card.QUEEN), new CardAndSuit(Suit.CLUBS, Card.KING), new CardAndSuit(Suit.CLUBS, Card.ACE)));

        //straight flush test
        cards.add(Arrays.asList(new CardAndSuit(Suit.CLUBS, Card.FIVE), new CardAndSuit(Suit.CLUBS, Card.SIX), new CardAndSuit(Suit.CLUBS, Card.SEVEN),
                new CardAndSuit(Suit.CLUBS, Card.EIGHT), new CardAndSuit(Suit.CLUBS, Card.NINE)));

        //four of a kind
        cards.add(Arrays.asList(new CardAndSuit(Suit.DIAMONDS, Card.FIVE), new CardAndSuit(Suit.HEART, Card.SIX), new CardAndSuit(Suit.CLUBS, Card.FIVE),
                new CardAndSuit(Suit.SPADE, Card.FIVE), new CardAndSuit(Suit.SPADE, Card.FIVE)));

        //full house
        cards.add(Arrays.asList(new CardAndSuit(Suit.DIAMONDS, Card.FIVE), new CardAndSuit(Suit.HEART, Card.SIX), new CardAndSuit(Suit.CLUBS, Card.SIX),
                new CardAndSuit(Suit.SPADE, Card.FIVE), new CardAndSuit(Suit.SPADE, Card.FIVE)));

        //flush
        cards.add(Arrays.asList(new CardAndSuit(Suit.HEART, Card.TEN), new CardAndSuit(Suit.HEART, Card.JACK), new CardAndSuit(Suit.HEART, Card.SIX),
                new CardAndSuit(Suit.HEART, Card.FIVE), new CardAndSuit(Suit.HEART, Card.SEVEN)));

        //straight
        cards.add(Arrays.asList(new CardAndSuit(Suit.SPADE, Card.TWO), new CardAndSuit(Suit.DIAMONDS, Card.THREE), new CardAndSuit(Suit.CLUBS, Card.FOUR),
                new CardAndSuit(Suit.HEART, Card.FIVE), new CardAndSuit(Suit.HEART, Card.SIX)));

        //three of a kind
        cards.add(Arrays.asList(new CardAndSuit(Suit.SPADE, Card.TWO), new CardAndSuit(Suit.DIAMONDS, Card.TWO), new CardAndSuit(Suit.CLUBS, Card.TWO),
                new CardAndSuit(Suit.HEART, Card.FIVE), new CardAndSuit(Suit.HEART, Card.SIX)));

        //two pair
        cards.add(Arrays.asList(new CardAndSuit(Suit.SPADE, Card.TWO), new CardAndSuit(Suit.DIAMONDS, Card.TWO), new CardAndSuit(Suit.CLUBS, Card.FIVE),
                new CardAndSuit(Suit.HEART, Card.FIVE), new CardAndSuit(Suit.HEART, Card.SIX)));

        //pair
        cards.add(Arrays.asList(new CardAndSuit(Suit.SPADE, Card.TWO), new CardAndSuit(Suit.DIAMONDS, Card.TWO), new CardAndSuit(Suit.CLUBS, Card.FIVE),
                new CardAndSuit(Suit.HEART, Card.SEVEN), new CardAndSuit(Suit.HEART, Card.SIX)));


        //null test
        cards.add(null);
    }

    @Test
    public void isCombinationRoyalFlushTe() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(0));
        Assert.assertSame(Combination.ROYAL_FLUSH, combinationWithHighCard.getCombination());
        Assert.assertSame(Card.ACE, combinationWithHighCard.getHighCard());
    }

    @Test
    public void isCombinationStraightFlush() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(1));
        Assert.assertSame(Combination.STRAIGHT_FLUSH, combinationWithHighCard.getCombination());
        Assert.assertSame(Card.NINE, combinationWithHighCard.getHighCard());
    }

    @Test
    public void isCombinationFourOfAKind() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(2));
        Assert.assertSame(Combination.FOUR_OF_A_KIND, combinationWithHighCard.getCombination());
        Assert.assertSame(Card.SIX, combinationWithHighCard.getHighCard());
    }

    @Test
    public void isCombinationFullHouse() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(3));
        Assert.assertSame(Combination.FULL_HOUSE, combinationWithHighCard.getCombination());
        Assert.assertSame(Card.SIX, combinationWithHighCard.getHighCard());
    }

    @Test
    public void isCombinationFlush() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(4));
        Assert.assertSame(Combination.FLUSH, combinationWithHighCard.getCombination());
        Assert.assertSame(Card.JACK, combinationWithHighCard.getHighCard());
    }

    @Test
    public void isCombinationStraight() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(5));
        Assert.assertSame(Combination.STRAIGHT, combinationWithHighCard.getCombination());
        Assert.assertSame(Card.SIX, combinationWithHighCard.getHighCard());
    }

    @Test
    public void isCombinationThreeOfAKind() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(6));
        Assert.assertSame(Combination.THREE_OF_A_KIND, combinationWithHighCard.getCombination());
        Assert.assertSame(Card.SIX, combinationWithHighCard.getHighCard());
    }

    @Test
    public void isCombinationTwoPair() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(7));
        Assert.assertSame(Combination.TWO_PAIR, combinationWithHighCard.getCombination());
        Assert.assertSame(Card.SIX, combinationWithHighCard.getHighCard());
    }

    @Test
    public void isCombinationPair() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(8));
        Assert.assertSame(Combination.PAIR, combinationWithHighCard.getCombination());
        Assert.assertSame(Card.SEVEN, combinationWithHighCard.getHighCard());
    }

    @Test
    public void isGivenCombinationNull() {
        CombinationWithHighCard combinationWithHighCard = CombinationCalculator.getCombinationWithHighCard(cards.get(9));
        Assert.assertNull(combinationWithHighCard.getCombination());
        Assert.assertNull(combinationWithHighCard.getHighCard());
    }
}
