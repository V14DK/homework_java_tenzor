package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Card card = new Card (10,"diamonds");
        Card card2 = new Card("diamonds");

        System.out.println(card.GetRank());
        System.out.println(card2.GetRank());

        Deck deck = Deck.CreateDeck(true);
        ArrayList<Card> pulledCards = new ArrayList<>();

        for (int i = 0; i < 18; i++) {
            pulledCards.add(deck.DistributionCard());
        }

        int indexToDeck = new Random().nextInt(pulledCards.size());
        Card cardToDeck = pulledCards.get(indexToDeck);
        pulledCards.remove(indexToDeck);

        deck.BackToDeck(cardToDeck);
        deck.BackToDeck(cardToDeck);
        System.out.println(deck.toString());

        deck.ShakeDeck();
        System.out.println(deck.toString());

        deck.SortDeck();
        System.out.println(deck.toString());

        while (!deck.IsEmpty()){
            pulledCards.add(deck.DistributionCard());
        }
        System.out.println(deck.toString());
        System.out.println("Deck is empty");
    }
}
