import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {

    private static Player playerOne;
    private static Player playerTwo;

    private static JFrame mainFrame;
    private static JList guessList;
    private static DefaultListModel<String> guessListModel;
    private static JButton guessButton;

    public static void initalizeGame()
    {
        Card.initializeDeck();

        playerOne = new Player();
        playerTwo = new Player();
    }

    public static void initializeMainFrame()
    {
        mainFrame = new JFrame();
        mainFrame.setSize(1000,1000);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        guessListModel = new DefaultListModel<>();
        for (String s : playerOne.getHand())
        {
            guessListModel.addElement(s);
        }

        guessList = new JList(guessListModel);
        guessList.setBounds(20, 20, 300, 500);

        guessButton = new JButton("Guess");
        guessButton.setBounds(400, 20, 100, 75);

        mainFrame.add(guessList);
        mainFrame.add(guessButton);
        mainFrame.setVisible(true);
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
