import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Player
{
    private int score;
    private ArrayList<String> hand;
    private ArrayList<String> pairs;

    public Player()
    {
        this.score = 0;
        this.hand = new ArrayList<String>();
        this.pairs = new ArrayList<String>();
    }

    public ArrayList<String> getHand()
    {
        return hand;
    }

    public ArrayList<String> getPairs()
    {
        return pairs;
    }

    public void addToHand(String s)
    {
        hand.add(s);
    }

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
                Card.dealCards(p, Card.getDeck().size());
            }
            
        }
    }

    public int getScore()
    {
        return score;
    }
}




