import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements ActionListener {

    private static Player playerOne;
    private static Player playerTwo;

    private static String turn;
    private static String winner;

    private static JFrame mainFrame;

    private static JLabel rulesLabel;

    private static JScrollPane guessListScrollPane;
    private static JLabel guessListLabel;
    private static JList<String> guessList;

    private static JScrollPane playerOnePairsScrollPane;
    private static JList<String> playerOnePairsList;
    private static JLabel playerOnePairsListLabel;

    private static JScrollPane playerTwoPairsScrollPane;
    private static JList<String> playerTwoPairsList;
    private static JLabel playerTwoPairsListLabel;

    private static JLabel playerOneScoreLabel;
    private static JLabel playerTwoScoreLabel;

    private static DefaultListModel<String> playerOneHandListModel;
    private static DefaultListModel<String> playerOnePairsListModel;
    private static DefaultListModel<String> playerTwoHandListModel;
    private static DefaultListModel<String> playerTwoPairsListModel;

    private static JButton guessButton;
    private static JButton nextTurnButton;

    public void Game()
    {

    }

    public static void initalizeGame()
    {
        Card.initializeDeck();

        turn = "playerOne";
        winner = "";

        playerOne = new Player();
        playerTwo = new Player();

        Card.dealCards(playerOne, 7);
        Card.dealCards(playerTwo, 7);

        playerOne.findPairs();
        playerTwo.findPairs();
    }

    public static void initializeMainFrame()
    {
        mainFrame = new JFrame("Go Fish!");
        mainFrame.setSize(1000,600);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        rulesLabel = new JLabel();
        rulesLabel.setText("<html>Rules:<br>The objective of the game is to have the most pairs.<br>You play with a basic 52 card deck. When a player guesses, they must audibly anounce which card they are guessing for their opponent to hear. <br>The active player clicks the guess button, and the next player clicks the next turn button.<br>If you run out of cards you will be delt 3 cards and the game ends when a player trys to take a card from the empty deck.<br>By guessing cards you are attempting to steal a matching card from your opponent to make a pair.");
        rulesLabel.setBounds(700, 20, 250, 400);
        
        guessListLabel = new JLabel("Player One/Two Hand");
        guessListLabel.setBounds(500, 20, 200, 20);
        guessList = new JList<String>();

        
        playerOnePairsListLabel = new JLabel("Player One Pairs");
        playerOnePairsListLabel.setBounds(20, 20, 150, 20);
        playerOnePairsList = new JList<String>();

        playerOneScoreLabel = new JLabel("Player One Score: " + playerOne.getScore());
        playerOneScoreLabel.setBounds(20, 410, 150, 20);

        
        playerTwoPairsListLabel = new JLabel("Player Two Pairs");
        playerTwoPairsListLabel.setBounds(170, 20, 100, 20);
        playerTwoPairsList = new JList<String>();
        playerTwoScoreLabel = new JLabel("Player Two Score: " + playerTwo.getScore());
        playerTwoScoreLabel.setBounds(170, 410, 150, 20);

        playerOneHandListModel = new DefaultListModel<String>();
        playerOnePairsListModel = new DefaultListModel<String>();

        playerTwoHandListModel = new DefaultListModel<String>();
        playerTwoPairsListModel = new DefaultListModel<String>();

        setGuessList();
        setPairLists();

        guessListScrollPane = new JScrollPane(guessList);
        guessListScrollPane.setBounds(500, 50, 100, 200);
        playerOnePairsScrollPane = new JScrollPane(playerOnePairsList);
        playerOnePairsScrollPane.setBounds(20, 50, 100, 350);
        playerTwoPairsScrollPane = new JScrollPane(playerTwoPairsList);
        playerTwoPairsScrollPane.setBounds(170, 50, 100, 350);



        guessList.setModel(playerOneHandListModel);
        playerOnePairsList.setModel(playerOnePairsListModel);
        playerTwoPairsList.setModel(playerTwoPairsListModel);

        Game g = new Game();

        guessButton = new JButton("Guess");
        guessButton.setBounds(750, 500, 75, 50);
        guessButton.addActionListener(g);

        nextTurnButton = new JButton("Next Turn");
        nextTurnButton.setBounds(850, 500, 100, 50);
        nextTurnButton.addActionListener(g);

        mainFrame.add(guessListLabel);
        mainFrame.add(guessListScrollPane);

        mainFrame.add(rulesLabel);

        mainFrame.add(playerOnePairsListLabel);
        mainFrame.add(playerOnePairsScrollPane);
        mainFrame.add(playerOneScoreLabel);

        mainFrame.add(playerTwoPairsListLabel);
        mainFrame.add(playerTwoPairsScrollPane);
        mainFrame.add(playerTwoScoreLabel);

        mainFrame.add(guessButton);
        mainFrame.add(nextTurnButton);
        mainFrame.setVisible(true);

        JOptionPane.showMessageDialog(mainFrame, "Go Fish Has Begun! It is now Player One's turn.", "Welcome Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void setGuessList()
    {
        playerOneHandListModel.clear();
        playerTwoHandListModel.clear();

        for (String stringOne : playerOne.getHand())
        {
            playerOneHandListModel.addElement(stringOne);
        }

        for (String stringTwo : playerTwo.getHand())
        {
            playerTwoHandListModel.addElement(stringTwo); 
        }
    }

    public static void setPairLists()
    {
        playerOnePairsListModel.clear();
        playerTwoPairsListModel.clear();

        for (String stringOne : playerOne.getPairs())
        {
            playerOnePairsListModel.addElement(stringOne);
        }

        for (String stringTwo : playerTwo.getPairs())
        {
            playerTwoPairsListModel.addElement(stringTwo);
        }
    }

    public static void switchTurn()
    {
        if (turn.equals("playerOne"))
        {
            turn = "playerTwo";
            setGuessList();
            setPairLists();
            guessList.setModel(playerTwoHandListModel);
            JOptionPane.showMessageDialog(mainFrame, "It is now Player Two's turn.", "Next Turn", JOptionPane.INFORMATION_MESSAGE);
        }

        else if (turn.equals("playerTwo"))
        {
            turn = "playerOne";
            setGuessList();
            setPairLists();
            guessList.setModel(playerOneHandListModel);
            JOptionPane.showMessageDialog(mainFrame, "It is now Player One's turn.", "Next Turn", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void determineWinner()
    {
        if (playerOne.getScore() > playerTwo.getScore())
        {
            winner = "Congratulations Player One, you have won!";
        }

        else if (playerTwo.getScore() > playerOne.getScore())
        {
            winner = "Congratulations Player Two, you have won!";
        }

        else
        {
            winner = "Sorry, both players have tied.";
        }

        JOptionPane.showMessageDialog(mainFrame, winner, "Game Over!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void endGame()
    {
        mainFrame.setVisible(false);
        determineWinner();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Guess"))
        {
            guessButton.setVisible(false);
            guessList.setVisible(false);
            String guess = (String) guessList.getSelectedValue();

            if (turn.equals("playerOne"))
            {
                boolean foundPair = false;
                for (int i = 0; i < playerTwo.getHand().size(); i++)
                {
                    if (guess.equals(playerTwo.getHand().get(i)))
                    {
                        playerOne.addToHand(playerTwo.getHand().get(i));
                        playerOne.findPairs();
                        playerTwo.getHand().remove(i);
                        foundPair = true;
                        playerOneScoreLabel.setText("Player One Score: " + playerOne.getScore());
                    }
                }
                if (foundPair == false)
                {
                    if (Card.getDeck().size() == 0)
                    {
                        endGame();
                    }
                    else 
                    {
                        Card.dealCards(playerOne, 1);
                        playerOne.findPairs();
                        playerOneScoreLabel.setText("Player One Score: " + playerOne.getScore());
                    }
                    
                }
            }

            else if (turn.equals("playerTwo"))
            {
                boolean foundPair = false;
                for (int i = 0; i < playerOne.getHand().size(); i++)
                {
                    if (guess.equals(playerOne.getHand().get(i)))
                    {
                        playerTwo.addToHand(playerOne.getHand().get(i));
                        playerTwo.findPairs();
                        playerOne.getHand().remove(i);
                        foundPair = true;
                        playerTwoScoreLabel.setText("Player Two Score: " + playerTwo.getScore());
                    }
                }

                if (foundPair == false)
                {
                    if (Card.getDeck().size() == 0)
                    {
                        endGame();
                    }

                    else
                    {
                        Card.dealCards(playerTwo, 1);
                        playerTwo.findPairs();
                        playerTwoScoreLabel.setText("Player Two Score: " + playerTwo.getScore());
                    }
                    
                }
            }

            else
            {
                
            }

            Player.emptyHand(playerOne);
            Player.emptyHand(playerTwo);

            setGuessList();
            setPairLists();
        }

        if (e.getActionCommand().equals("Next Turn"))
        {
            switchTurn();
            guessButton.setVisible(true);
            guessList.setVisible(true);

        }
    }

}
