import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Card 
{
    private static ArrayList<String> deck;

    // Creates a deck of 52 cards, the deck does not specify the suit of the cards, only the rank
    public static void initializeDeck()
    {
        deck = new ArrayList<String>();

        for (int i = 0; i < 4; i++)
        {
            deck.add("Ace");
            deck.add("Two");
            deck.add("Three");
            deck.add("Four");
            deck.add("Five");
            deck.add("Six");
            deck.add("Seven");
            deck.add("Eight");
            deck.add("Nine");
            deck.add("Ten");
            deck.add("Jack");
            deck.add("Queen");
            deck.add("King");
        }
    }

    // deals a number of a cards to a specified player
    public static void dealCards(Player p, int n)
    {
        Random r = new Random();

        for (int i = 0; i < n; i++)
        {
            int x = r.nextInt(deck.size());
            p.addToHand(deck.get(x));
            deck.remove(x);
        }

    }

    // returns the deck of cards as an ArrayList
    public static ArrayList<String> getDeck()
    {
        return deck;
    }

}

