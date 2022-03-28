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

        Folder folder = new Folder(null, "first");
        Folder folder1 = new Folder(folder, "a");
        Folder folder2 = new Folder(folder, "b");

        File file = new File(folder,"text", "txt");
        folder.AddFile(new File("table", "xlsx"));
        folder1.AddFile(file);
        folder1.AddFile(new File("page", "png"));
        folder2.AddFile(new File("music", "mp4"));

        System.out.println(folder.GetChildren().get(0).path);
        System.out.println(file.path);
        System.out.println(folder1.GetChildren().get(1).path);
        System.out.println(folder2.GetChildren().get(0).path);
    }
}
