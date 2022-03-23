package com.company;

import java.util.*;

public class Deck {
    public ArrayList<Card> deck;
    private Random random = new Random();

    private Deck(boolean withJokers){
        //TODO не добавлять дубликаты
        ArrayList<String> suits = new ArrayList<>(Arrays.asList("clubs","diamonds","spades", "hearts"));
        int count = 52;
        if (withJokers){
            Card jok1 = new Card(15, "hearts");
            Card jok2 = new Card(15, "spades");
            this.deck = new ArrayList<Card>(Arrays.asList(jok1, jok2));
        }
        for (int i = 0; i < count; i++) {
            Card card = new Card(this.random.nextInt(12) + 2,
                    suits.get(this.random.nextInt(4)));
            this.deck.add(card);
        }
    };

    public static Deck CreateDeck(boolean withJokers){
        return new Deck(withJokers);
    };

    public Card RandomCard(){
        return this.deck.get(random.nextInt(this.deck.size()));
    };

    public void ShakeDeck(){
        Collections.shuffle(this.deck, this.random);
    };

    public void SortDect(){
        Collections.sort(this.deck);
    }

//    public void DistributionCards(){
//        return;
//    };
//
//    public static void BackToDeck(){
//
//    };
//
//    public boolean Absent(Card card){
//        return this.deck.contains(card);
//    };
//
//    public static void ToString(){
//
//    };
}
