package com.company;

import java.util.*;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    public Random random = new Random();

    private Deck(boolean withJokers){
        ArrayList<String> suits = new ArrayList<>(Arrays.asList("clubs","diamonds","spades", "hearts"));
        if (withJokers){
            Card jok1 = new Card(15, "hearts");
            Card jok2 = new Card(15, "spades");
            this.deck.addAll(Arrays.asList(jok1, jok2));
        }

        for (int i = 2; i < 15; i++){
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

    public void SortDeck(){
        Collections.sort(this.deck);
    }

    public Card DistributionCard(){
        int index = this.random.nextInt(this.deck.size());
        Card card = this.deck.get(index);
        this.deck.remove(index);
        return card;
    };

    public void BackToDeck(Card card){
        if (this.deck.contains(card))
            System.out.println("The card is already in the deck");
        else
            this.deck.add(card);

    };

    public boolean IsEmpty(){ return this.deck.size() == 0; };

    public String toString(){
        String content = new String();
        if (!this.IsEmpty()){
            for (Card card: this.deck)
                content += card.toString() + ", ";
        }
        return content;
    };
}
