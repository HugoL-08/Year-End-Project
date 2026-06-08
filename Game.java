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
        mainFrame.setSize(1000,1000);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        guessList = new JList();
        guessList.setBounds(20, 20, 300, 500);

        playerOneListModel = new DefaultListModel<String>();
        playerTwoListModel = new DefaultListModel<String>();

        guessButton = new JButton("Guess");
        guessButton.setBounds(400, 20, 100, 75);

        mainFrame.add(guessList);
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
