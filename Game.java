import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements ActionListener {

    private static Player playerOne;
    private static Player playerTwo;

    private static String turn;
    private static String winner;

    private static JFrame mainFrame;
    private static JList guessList;
    private static DefaultListModel<String> playerOneListModel;
    private static DefaultListModel<String> playerTwoListModel;
    private static JButton guessButton;
    private static JLabel player1Score;
    private static JLabel player2Score;
    private static JLabel player1Pairs;
    private static JLabel player2Pairs;
    private static JLabel opponentHand;
    private static JLabel rules;


    public static void initalizeGame()
    {
        Card.initializeDeck();

        turn = "playerOne";

        playerOne = new Player();
        playerTwo = new Player();

        Card.dealCards(playerOne, 7);
        Card.dealCards(playerTwo, 7);

        playerOne.findPairs();
        playerTwo.findPairs();
    }

    public static void initializeMainFrame()
    {
        mainFrame = new JFrame();
        mainFrame.setSize(600,500);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        playerOneListModel = new DefaultListModel<String>();
        playerTwoListModel = new DefaultListModel<String>();

        guessList = new JList();
        guessList.setBounds(350, 100, 200, 300);

        guessButton = new JButton("Guess");
        guessButton.setBounds(150, 350, 100, 65);

        player1Score = new JLabel("Player 1 Score = ");
        player1Score.setBounds(50, 100, 300, 65);

        player2Score = new JLabel("Player 2 Score = ");
        player2Score.setBounds(50, 150, 300, 65);

        player1Pairs = new JLabel("Most recent collected pair = ");
        player1Pairs.setBounds(50, 125, 300, 65);

        player2Pairs = new JLabel("Most recent collected pair = ");
        player2Pairs.setBounds(50, 175, 300, 65);

        opponentHand = new JLabel("Opponent has __ cards in their hand.");
        opponentHand.setBounds(100, 200, 300, 65);

        rules = new JLabel("1. ________");
        rules.setBounds(20, -25, 300, 100);


        mainFrame.add(guessList);
        mainFrame.add(player1Score);
        mainFrame.add(player2Score);
        mainFrame.add(player1Pairs);
        mainFrame.add(player2Pairs);
        mainFrame.add(rules);
        mainFrame.add(opponentHand);
        mainFrame.add(guessButton);
        mainFrame.setVisible(true);
    }

    public static void updateGuessList()
    {
        playerOneListModel.clear();
        playerTwoListModel.clear();

        for (String s : playerOne.getHand())
        {
            playerOneListModel.addElement(s);
        }

        for (String s : playerTwo.getHand())
        {
            playerTwoListModel.addElement(s);
        }

        if (turn.equals("playerOne"))
        {
            guessList.setModel(playerTwoListModel);
            turn = "playerTwo";
        }

        if (turn.equals("playerTwo"))
        {
            guessList.setModel(playerOneListModel);
            turn = "playerOne";
        }
    }

    public static void switchTurn()
    {
        
    }

    public static void determineWinner()
    {
        if (playerOne.getScore() > playerTwo.getScore())
        {
            winner = "Congratulations Player One, you have won!";
        }

        if (playerTwo.getScore() > playerOne.getScore())
        {
            winner = "Congratulations Player Two, you have won!";
        }

        else
        {
            winner = "Sorry, both players have tied.";
        }
    }
    
    public static void testGame()
    {
        
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Guess"))
        {
            
        }
    }
}
