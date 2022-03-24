package com.company;

public class Main {
    public static void main(String[] args) {
//        Card card = new Card (10,"diamonds");
//        Card card1 = new Card(16, "clubs");
//        Card card2 = new Card("clubs");
        Deck deck = Deck.CreateDeck(true);
//        deck.SortDect();
        for (Card card: deck.deck)
            System.out.println(card.toString());
//        deck.ShakeDeck();
//        for (Card card: deck.deck)
//            System.out.println(card.toString());

    }
}
