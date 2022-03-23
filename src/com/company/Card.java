package com.company;
import java.util.Comparator;
import java.util.HashMap;


enum Suit {
    clubs(0),
    diamonds(1),
    spades(2),
    hearts(3),
    Jack(11),
    Queen(12),
    King(13),
    Ace(14),
    Joker(15);

    final int position;

    Suit(int position) {
        this.position = position;
    }

    public static boolean Contains(String suit) {
        for (Suit val : values())
            if (suit.equals(val.toString()))
                return true;
        return false;
    }

    public static String ToString(int rank) {
        for (Suit val : values())
            if (val.position == rank)
                return val.toString();
        throw new java.lang.Error("Wrong rank value");
    }

    public static int SuitEquals(Card first, Card second) {
        int first_position = Suit.valueOf(first.GetSuit()).position;
        int second_position = Suit.valueOf(second.GetSuit()).position;
        return Integer.compare(first_position, second_position);
    }
}


public class Card implements Comparable<Card> {
    private final int rank;
    private final String suit;
    private static HashMap<String, Integer> maxRank = new HashMap<>();

    Card(int rank, String suit) {
        this.suit = suit.toLowerCase();
        Card.CheckSuit(suit);
        this.rank = rank;
        maxRank.put(this.suit, this.rank);
    }

    Card(String suit) {
        this.suit = suit.toLowerCase();
        Card.CheckSuit(suit);
        if (Card.maxRank.containsKey(suit))
            this.rank = Card.maxRank.get(suit) + 1;
        else
            this.rank = 1;
        maxRank.put(this.suit, this.rank);
    }

    private static void CheckSuit(String suit){
        if (!Suit.Contains(suit.toLowerCase()))
            throw new java.lang.Error("Wrong suit value");
    }

    public int GetRank() {
        return this.rank;
    }

    public String GetSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        String rank = Integer.toString(this.rank);
        if (this.rank > 10){
            rank = Suit.ToString(this.rank);
            if (this.rank == 15)
                return rank;
        }
        return rank + " " + this.suit;

    }

    public boolean Equals(Card otherCard){
        return this.suit.equals(otherCard.suit)
                && this.rank == otherCard.rank;
    }

    public int HashCode(){
        return 0;
    }

    public boolean StandartDeck(){
        return !(this.rank < 6) && !(this.rank > 14);
    }

    public int IsStronger(Card otherCard) {
        return Integer.compare(this.rank, otherCard.rank);
    }

    public int SuitEquals(Card otherCard){
        return Suit.SuitEquals(this, otherCard);
    }

    @Override
    public int compareTo(Card card){
        int res = this.SuitEquals(card);
        if (res == 0)
            res = this.IsStronger(card);
        return res;
    }
}
