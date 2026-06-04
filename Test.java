import javax.swing.*;
import java.util.*;
import java.math.*;
import java.awt.event.*;

public class Test implements ActionListener
  {

    private static JFrame frame;
    private static JLabel label;
    //This says the players cards
    private static JLabel scoreLabel;
    private static JLabel opponentScore;
    private static JLabel opponentAmount;
    public static String[] CardArr;
    //This array holds every card from the deck
    public static String[] playerCards;
    //This array holds every card in the players hand
    public static String[] player2Cards;
    //This array holds every card in the others players hand
    public static int player;
    //This integer tracks which players turn it is.
    public static int totalPlayers;
    //this integer tracks if the game is set to four or two players
    public static int player1points;
    public static int player2points;
    public static int player3points;
    public static int player4points;
    public static JLabel player1pairs;
    public static JLabel player2pairs;
    public static int pair2;
    public static int pair1;
    //these labels holds very pair that has been counted so far.
    public static int currentplayer;
    //this checks which players turn it is
    public static JSlider cardPick;
    public static JButton guess;
    //The drop down box allows the user to select which card to guess while the button confirms the guess.
    public static JButton endTurn;
    public static JButton startTurn;
    public static JLabel warn;

    public Test()
    {

    }

    public static void main(String[] args)
    {
      String Globvar = "Hello World";
      System.out.println(Globvar);
      createFrame();
      startGame();
    }

    public static void createFrame()
    {
      CardArr = new String[] {"A","A","A","A","2","2","2","2","3","3","3","3","4","4","4","4","5","5","5","5","6","6","6","6","7","7","7","7","8","8","8","8","9","9","9","9","10","10","10","10","J","J","J","J","Q","Q","Q","Q","K","K","K","K"};
      frame = new JFrame("Test");
      frame.setSize(1100, 600);
      frame.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      label = new JLabel("Your cards are: ");
      label.setBounds(200,250,600,100);
      scoreLabel = new JLabel("Your score is: ");
      scoreLabel.setBounds(100,350,300,100);
      player1pairs = new JLabel("Pairs collected: ");
      player1pairs.setBounds(100,400,300,100);
      player2pairs = new JLabel("Pairs collected: ");
      player2pairs.setBounds(100,100,300,100);
      opponentScore = new JLabel("Opponent score: ");
      opponentScore.setBounds(100,50,300,100);
      opponentAmount = new JLabel("Your opponent has ___ cards ");
      opponentAmount.setBounds(200,150,600,100);
      cardPick = new JSlider(JSlider.VERTICAL,1,13,6);
      cardPick.setBounds(440, 250, 50, 250);
      Hashtable<Integer, JLabel> labelSet = new Hashtable<>();
      labelSet.put(1, new JLabel("A"));
      labelSet.put(2, new JLabel("2"));
      labelSet.put(3, new JLabel("3"));
      labelSet.put(4, new JLabel("4"));
      labelSet.put(5, new JLabel("5"));
      labelSet.put(6, new JLabel("6"));
      labelSet.put(7, new JLabel("7"));
      labelSet.put(8, new JLabel("8"));
      labelSet.put(9, new JLabel("9"));
      labelSet.put(10, new JLabel("10"));
      labelSet.put(11, new JLabel("J"));
      labelSet.put(12, new JLabel("Q"));
      labelSet.put(13, new JLabel("K"));

      cardPick.setLabelTable(labelSet);
      cardPick.setMajorTickSpacing(1);
      cardPick.setMinorTickSpacing(1);
      cardPick.setPaintTicks(true);
      cardPick.setPaintLabels(true);
      guess = new JButton("Guess");
      guess.setBounds(280,400,90,60);
      endTurn = new JButton("Finish Turn");
      endTurn.setBounds(280,400,150,60);
      startTurn = new JButton("Start Turn");
      startTurn.setBounds(280,400,150,60);
      warn = new JLabel("Switch with the other player BEFORE pressing the button.");
      warn.setBounds(200,150,600,100);

      Test t = new Test();
      guess.addActionListener(t);
      endTurn.addActionListener(t);
      startTurn.addActionListener(t);

      frame.add(cardPick);
      frame.add(guess);
      frame.add(endTurn);
      frame.add(startTurn);
      startTurn.setVisible(false);
      endTurn.setVisible(false);
      frame.add(label);
      frame.add(warn);
      warn.setVisible(false);
      frame.add(scoreLabel);
      frame.add(opponentScore);
      frame.add(opponentAmount);
      frame.add(player1pairs);
      
      frame.setVisible(true);
    }
    public static void startGame(){
      String labelText = label.getText();
      playerCards = new String[] {"","","","","","","","","","","","","",""};
      int r = 0;
      //random number
      if (totalPlayers < 3){
        for (int i = 0; i < 7; i++){
        labelText = label.getText();
        r = (int)(Math.random() * 52);
        while (CardArr[r] == ""){
          r = (int)(Math.random()*52);
        }

        label.setText(labelText + " " + CardArr[r] + ",");
        playerCards[i] = CardArr[r];
        }
      }
      player2Cards = new String[] {"","","","","","","","","","","","","",""};
      if (totalPlayers < 3){
        for (int i = 0; i < 7; i++){
        labelText = label.getText();
        r = (int)(Math.random() * 52);
        while (CardArr[r] == ""){
          r = (int)(Math.random()*52);
        }
        player2Cards[i] = CardArr[r];
        }
      }
      String playerpair = "";
      pair1 = 7;
      for (int i = 0; i < 13; i++){
        for (int j = 0; j < 13; j++){
          if ((playerCards[i] == playerCards[j])&&(i != j)&&(playerCards[i] !="")){
            player1points += 1;
            playerpair = player1pairs.getText();
            player1pairs.setText(playerpair + playerCards[i] + ", ");
            playerCards[i] = "";
            playerCards[j] = "";
            pair1 -= 2;
            }
          }
        }
        label.setText("Your cards are: ");
        for (int h = 0; h < 13; h++){
              if (playerCards[h] != ""){
                labelText = label.getText();
            label.setText(labelText + playerCards[h] + ", ");
              }
            }
            pair2 = 7;
              for (int i = 0; i < 13; i++){
        for (int j = 0; j < 13; j++){
          if ((player2Cards[i] == player2Cards[j])&&(i != j)&&(player2Cards[i] !="")){
            player2points += 1;
            playerpair = player2pairs.getText();
            player2pairs.setText(player2pairs + player2Cards[i] + ", ");
            player2Cards[i] = "";
            player2Cards[j] = "";
            pair2 -= 2;
            }
          }
        }
        opponentAmount.setText("Your opponent has " + pair2 + " cards");
        opponentScore.setText("Opponent score is " + player2points);
      
      System.out.println(playerCards[0]);
      System.out.println(playerCards[1]);
      System.out.println(playerCards[2]);
      System.out.println(playerCards[3]);
      System.out.println(playerCards[4]);
      System.out.println(playerCards[5]);
      System.out.println(playerCards[6]);
      System.out.println(playerCards[7]);
      System.out.println(playerCards[8]);
      scoreLabel.setText("Your score is: " + player1points);
      currentplayer = 1;
      playerTurn();
    }
    public static void playerTurn(){
      label.setText("Your cards are ");
      String labelText = "";
      if (currentplayer == 1){
        opponentAmount.setText("Your opponent has " + pair2 + " cards");
        opponentScore.setText("Opponent score is " + player2points);
        scoreLabel.setText("Your score is: " + player1points);
        for (int h = 0; h < 13; h++){
              if (playerCards[h] != ""){
                labelText = label.getText();
            label.setText(labelText + playerCards[h] + ", ");
              }
            }
      } else{
        opponentAmount.setText("Your opponent has " + pair1 + " cards");
        opponentScore.setText("Opponent score is " + player1points);
        scoreLabel.setText("Your score is: " + player2points);
        for (int h = 0; h < 13; h++){
              if (player2Cards[h] != ""){
                labelText = label.getText();
            label.setText(labelText + player2Cards[h] + ", ");
      }
    }
  }
}
public void actionPerformed(ActionEvent e)
{
  if (e.getActionCommand().equals("Guess"))
  {
    int value = cardPick.getValue();
    int r = 0;
    int checkcards = pair2;
    String[] all = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    for (int i = 0; i < 13; i++){
    if (all[value - 1].equals(playerCards[i])){
      for (int j = 0; j < 13; j++){
      if (all[value - 1].equals(player2Cards[j])){
        player1points += 1;
        scoreLabel.setText("Your score is: " + player1points);
        String playerpair = player1pairs.getText();
        player1pairs.setText(playerpair + playerCards[i] + ", ");
      playerCards[i] = "";
      player2Cards[j] = "";
      pair2 --;
      opponentAmount.setText("Your opponent has " + pair2 + " cards");
      guess.setVisible(false);
      endTurn.setVisible(true);
      }
    }
    if (checkcards == pair2){
      for (int j = 0; j < 13; j++){
        r = (int)(Math.random() * 52);
        while (CardArr[r] == ""){
          r = (int)(Math.random()*52);
        }
        if ((playerCards[j] == "")&&(CardArr[r] != "")){
        playerCards[j] = CardArr[r];
        CardArr[r] = "";
        guess.setVisible(false);
        endTurn.setVisible(true);
        break;
        }
      }
    }
    }
  }
  String playerpair = "";
  for (int i = 0; i < 13; i++){
        for (int j = 0; j < 13; j++){
          if ((playerCards[i] == playerCards[j])&&(i != j)&&(playerCards[i] !="")){
            player1points += 1;
            playerpair = player1pairs.getText();
            player1pairs.setText(playerpair + playerCards[i] + ", ");
            playerCards[i] = "";
            playerCards[j] = "";
            pair1 -= 2;
            }
          }
        }
    label.setText("Your cards are ");
      String labelText = "";
      if (currentplayer == 1){
        opponentAmount.setText("Your opponent has " + pair2 + " cards");
        opponentScore.setText("Opponent score is " + player2points);
        scoreLabel.setText("Your score is: " + player1points);
        for (int h = 0; h < 13; h++){
              if (playerCards[h] != ""){
                labelText = label.getText();
            label.setText(labelText + playerCards[h] + ", ");
              }
            }
      } else{
        opponentAmount.setText("Your opponent has " + pair1 + " cards");
        opponentScore.setText("Opponent score is " + player1points);
        scoreLabel.setText("Your score is: " + player2points);
        for (int h = 0; h < 13; h++){
              if (player2Cards[h] != ""){
                labelText = label.getText();
            label.setText(labelText + player2Cards[h] + ", ");
      }
    }
  }
  }
  if (e.getActionCommand().equals("Finish Turn")){
    warn.setVisible(true);
    label.setVisible(false);
    startTurn.setVisible(true);
    scoreLabel.setVisible(false);
    opponentAmount.setVisible(false);
    opponentScore.setVisible(false);
    player1pairs.setVisible(false);
    endTurn.setVisible(false);
  }
}
  }
