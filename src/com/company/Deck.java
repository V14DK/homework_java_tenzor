package com.company;

import java.util.*;

public class Deck {
    public ArrayList<Card> deck = new ArrayList<>();
    public Set set = new HashSet();
    private Random random = new Random();

    private Deck(boolean withJokers){
        ArrayList<String> suits = new ArrayList<>(Arrays.asList("clubs","diamonds","spades", "hearts"));
        if (withJokers){
            Card jok1 = new Card(15, "hearts");
            Card jok2 = new Card(15, "spades");
            this.deck.addAll(Arrays.asList(jok1, jok2));
        }

        for (int i = 2; i < 14; i++){
            for (int j = 0; j < suits.size(); j++){
                this.deck.add(new Card(i, suits.get(j)));
            }
        }

        this.ShakeDeck();
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
