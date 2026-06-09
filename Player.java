import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Player
{
    private int score;
    private ArrayList<String> hand;
    private ArrayList<String> pairs;

    // intializes a player with a score of zero, a hand of cards, and an empty arraylist of pairs
    public Player()
    {
        this.score = 0;
        this.hand = new ArrayList<String>();
        this.pairs = new ArrayList<String>();
    }

    // returns the player's hand as an arraylist
    public ArrayList<String> getHand()
    {
        return hand;
    }

    // returns the player's pairs as an arraylist
    public ArrayList<String> getPairs()
    {
        return pairs;
    }

    // adds a card to the player's hand
    public void addToHand(String s)
    {
        hand.add(s);
    }

    // finds pairs in the player's deck, increments the player's score, and moves the pairs from their hand into the pairs arraylist
    public void findPairs()
    {
        for (int i = 0; i < hand.size(); i++)
        {
            for (int j = 0; j < hand.size(); j++)
            {
                if ((hand.get(i).equals(hand.get(j))) && (i != j))
                {
                    score += 1;
                    pairs.add(hand.get(j));
                    pairs.add(hand.get(i));
                    hand.remove(j);
                    hand.remove(i);
                }
            }
        }
    }

    // forces the player to draw three cards if their hand is empty. If there are no cards to draw, the game ends
    public static void emptyHand(Player p)
    {
        if (p.getHand().size() == 0)
        {
            if (Card.getDeck().size() <= 3)
            {
                Game.endGame();
            }

            else
            {
                Card.dealCards(p, 3);
            }
            
        }
    }

    // returns the player's score as an integer
    public int getScore()
    {
        return score;
    }
}




