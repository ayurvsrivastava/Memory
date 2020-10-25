//This class contains code the code for each of the JButtons
//This tests whether each card matches another
//and checks to see if the user has won or not

import javax.swing.JOptionPane;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;
import java.awt.event.WindowEvent;

public class SrivastavaMemory extends JFrame implements ActionListener {
   //creates all the variables needed for the code to work.
   JButton[][] cards;
   int u = 1;
   int pos1;
   int pos2;
   int row1;
   int row2;
   int column1;
   int column2;
   int gameCount;
   boolean check;
   String[] deck;
   String[] picks = new String[2];
   int gameLength;
   public Timer timer = null;
   
   
   //constructor for the SrivastavaDeck class to access
   public SrivastavaMemory(String title, int x) {
      
      super(title);
      gameLength = x;
      gameCount = (gameLength * gameLength) / 2;
      //creates 2D array for the buttons to be stored in
      cards = new JButton[gameLength][gameLength];
      deck = new String[gameLength*gameLength];
      setLayout(new GridLayout(gameLength, gameLength, gameLength, gameLength));
      //assigns all the required constructors for teach of the buttons
      for (int r = 0; r < cards.length; r++) {
         for (int c = 0; c < cards.length; c++) {
            cards[r][c] = new JButton();
            cards[r][c].addActionListener(this);
            Dimension dim = cards[r][c].getPreferredSize();
            int buttonSize = Math.max(150, 150);
            cards[r][c].setPreferredSize(new Dimension(buttonSize, buttonSize));
            cards[r][c].setBackground(Color.WHITE);
            cards[r][c].setOpaque(true);
            cards[r][c].setBorderPainted(false);
            add(cards[r][c]);
            String q = Integer.toString(u);
            cards[r][c].setActionCommand(q);
            u++;
         }
      }
      //creates a temporary deck of cards to assign values too
      SrivastavaDeck mainDeck = new SrivastavaDeck(gameLength);;
      mainDeck.randomize();
      for(int i=0; i < deck.length; i++) {
         deck[i] = mainDeck.deck[i];
      }
   }
   //used for testing to return gameCount values
   int getGameCount() {
      return gameCount;
   }
   
   //Sets the commands for each of the values
  public void actionPerformed(ActionEvent e) {
    
    //action listener for timer set for 1 second
    timer = new Timer(1000, new ActionListener(){      
                public void actionPerformed(ActionEvent e) {
            //resets the buutton if the two lines dont match.
            if(check==true)
            {
             cards[row1][column1].setText(null);
             cards[row2][column2].setText(null);
             cards[row1][column1].setBackground(Color.WHITE);
             cards[row2][column2].setBackground(Color.WHITE);
            }
            //if all the matches occur then it will end the game.
            //System.out.println("Banana");
            if(gameCount==0)
            {
               gameCount++;
               System.out.println("GAME OVER");
               JFrame frame = new JFrame();
    //Creates JOptionPane to instigate the play again screen
    String message = "Play Again?";
    int answer = JOptionPane.showConfirmDialog(frame, message);
    //if player chooses no then it quits
    if (answer == JOptionPane.YES_OPTION) {
    dispose();
      SrivastavaDeck test = new SrivastavaDeck(2);
      test.Game();
    
    return;
    //if player clicks no, close the program
    } else if (answer == JOptionPane.NO_OPTION) {
      System.exit(0);
    }

             
               
            
            }
            //stop timer so it can restart next time match doesn't occur
                            timer.stop();
                            }
        });
                
    

     
     int action = Integer.parseInt(e.getActionCommand());
     JPanel panel = new JPanel();
     //runs through this if game is 2x2
     if (gameLength == 2) {
      //aight mr.barker, there are like 45 test cases and i really dont want to comment them all, but the code is the same for each of them.
      //Ill comment the first one and the rest just follows the same idea
      //so we use a switch case for every scenario a card could be
      switch (action) {
      //this uses the utf-8 code to set the shapes for everything so square is u25a0 for example
         case 1:
            if(deck[0].equals("Square of Blue")) {
               cards[0][0].setText("\u25A0");
               //them we set the color here to blue for the square
               cards[0][0].setForeground(Color.BLUE);
               //then it makes the square visible by enlarging it
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[0].equals("Square of Green")) {
               cards[0][0].setText("\u25A0");
               cards[0][0].setForeground(Color.GREEN);
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            //aight down here it checks if a card is in pick[0]
            //then it sets its relative position to 1 if not
            if (picks[0] == null) {
               picks[0] = deck[0];
               pos1 = 1;
            }
            //if pick[0] has a value it sets pick[1] to the value
            //then it does this for the 2x2 and the 4x4 and the 6x6. 
            //each scenario just has a lot more test cases than I care to admit
            //just copying, pasting, then editiing took me like a solid 2 hours
            else if (pos1 != 1) {
               picks[1] = deck[0];
               pos2 = 1;
            }
            System.out.println(picks[0] + " " + picks[1]);
         break;
            
         case 2: 
            if(deck[1].equals("Square of Blue")) {
               cards[0][1].setText("\u25A0");
               cards[0][1].setForeground(Color.BLUE);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[1].equals("Square of Green")) {
               cards[0][1].setText("\u25A0");
               cards[0][1].setForeground(Color.GREEN);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            if(picks[0] == null) {
               picks[0] = deck[1];
               pos1 = 2;
            }
            else if (pos1 != 2) {
               picks[1] = deck[1];
               pos2 = 2;
            }
             System.out.println(picks[0] + " " + picks[1]);

         break;
         
         case 3:
            if(deck[2].equals("Square of Blue")) {
               cards[1][0].setText("\u25A0");
               cards[1][0].setForeground(Color.BLUE);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[2].equals("Square of Green")) {
               cards[1][0].setText("\u25A0");
               cards[1][0].setForeground(Color.GREEN);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            if(picks[0] == null) {
               picks[0] = deck[2];
               pos1 = 3;
            }
            else if (pos1 != 3) {
               picks[1] = deck[2];
               pos2 = 3;
            }
             System.out.println(picks[0] + " " + picks[1]);

         break;
         
         case 4:
            if(deck[3].equals("Square of Blue")) {
               cards[1][1].setText("\u25A0");
               cards[1][1].setForeground(Color.BLUE);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[3].equals("Square of Green")) {
               cards[1][1].setText("\u25A0");
               cards[1][1].setForeground(Color.GREEN);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            if(picks[0] == null) {
               picks[0] = deck[3];
               pos1 = 4;
            }
            else if (pos1 != 4) {
               picks[1] = deck[3];
               pos2 = 4;
            }
             System.out.println(picks[0] + " " + picks[1]);

            break;

      }
     }  
     //same thing as 2x2 but for 4x4
     //just more test cases pretty much for the same thing
     if (gameLength == 4) {
      switch(action) {
         case 1: 
            if(deck[0].equals("Square of Blue")) {
               cards[0][0].setText("\u25A0");
               cards[0][0].setForeground(Color.BLUE);
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[0].equals("Square of Green")) {
               cards[0][0].setText("\u25A0");
               cards[0][0].setForeground(Color.GREEN);
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[0].equals("Square of Red")) {
               cards[0][0].setText("\u25A0");
               cards[0][0].setForeground(Color.RED);
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[0].equals("Square of Yellow")) {
               cards[0][0].setText("\u25A0");
               cards[0][0].setForeground(Color.YELLOW);
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[0].equals("Triangle of Blue")) {
               cards[0][0].setText("\u25B2");
               cards[0][0].setForeground(Color.BLUE);
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[0].equals("Triangle of Green")) {
               cards[0][0].setText("\u25B2");
               cards[0][0].setForeground(Color.GREEN);
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[0].equals("Triangle of Red")) {
               cards[0][0].setText("\u25B2");
               cards[0][0].setForeground(Color.RED);
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[0].equals("Triangle of Yellow")) {
               cards[0][0].setText("\u25B2");
               cards[0][0].setForeground(Color.YELLOW);
               cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[0];
               pos1 = 1;
            }
            else if (pos1 != 1) {
               picks[1] = deck[0];
               pos2 = 1;
            }
            
            break;
            
            case 2:
            if(deck[1].equals("Square of Blue")) {
               cards[0][1].setText("\u25A0");
               cards[0][1].setForeground(Color.BLUE);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[1].equals("Square of Green")) {
               cards[0][1].setText("\u25A0");
               cards[0][1].setForeground(Color.GREEN);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[1].equals("Square of Red")) {
               cards[0][1].setText("\u25A0");
               cards[0][1].setForeground(Color.RED);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[1].equals("Square of Yellow")) {
               cards[0][1].setText("\u25A0");
               cards[0][1].setForeground(Color.YELLOW);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[1].equals("Triangle of Blue")) {
               cards[0][1].setText("\u25B2");
               cards[0][1].setForeground(Color.BLUE);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[1].equals("Triangle of Green")) {
               cards[0][1].setText("\u25B2");
               cards[0][1].setForeground(Color.GREEN);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[1].equals("Triangle of Red")) {
               cards[0][1].setText("\u25B2");
               cards[0][1].setForeground(Color.RED);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[1].equals("Triangle of Yellow")) {
               cards[0][1].setText("\u25B2");
               cards[0][1].setForeground(Color.YELLOW);
               cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[1];
               pos1 = 2;
            }
            else if (pos1 != 2) {
               picks[1] = deck[1];
               pos2 = 2;
            }
            
            break;
            
            case 3:
            if(deck[2].equals("Square of Blue")) {
               cards[0][2].setText("\u25A0");
               cards[0][2].setForeground(Color.BLUE);
               cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[2].equals("Square of Green")) {
               cards[0][2].setText("\u25A0");
               cards[0][2].setForeground(Color.GREEN);
               cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[2].equals("Square of Red")) {
               cards[0][2].setText("\u25A0");
               cards[0][2].setForeground(Color.RED);
               cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[2].equals("Square of Yellow")) {
               cards[0][2].setText("\u25A0");
               cards[0][2].setForeground(Color.YELLOW);
               cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[2].equals("Triangle of Blue")) {
               cards[0][2].setText("\u25B2");
               cards[0][2].setForeground(Color.BLUE);
               cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[2].equals("Triangle of Green")) {
               cards[0][2].setText("\u25B2");
               cards[0][2].setForeground(Color.GREEN);
               cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[2].equals("Triangle of Red")) {
               cards[0][2].setText("\u25B2");
               cards[0][2].setForeground(Color.RED);
               cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[2].equals("Triangle of Yellow")) {
               cards[0][2].setText("\u25B2");
               cards[0][2].setForeground(Color.YELLOW);
               cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[2];
               pos1 = 3;
            }
            else if (pos1 != 3) {
               picks[1] = deck[2];
               pos2 = 3;
            }
            
            break;
            
            case 4:
            if(deck[3].equals("Square of Blue")) {
               cards[0][3].setText("\u25A0");
               cards[0][3].setForeground(Color.BLUE);
               cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[3].equals("Square of Green")) {
               cards[0][3].setText("\u25A0");
               cards[0][3].setForeground(Color.GREEN);
               cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[3].equals("Square of Red")) {
               cards[0][3].setText("\u25A0");
               cards[0][3].setForeground(Color.RED);
               cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[3].equals("Square of Yellow")) {
               cards[0][3].setText("\u25A0");
               cards[0][3].setForeground(Color.YELLOW);
               cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[3].equals("Triangle of Blue")) {
               cards[0][3].setText("\u25B2");
               cards[0][3].setForeground(Color.BLUE);
               cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[3].equals("Triangle of Green")) {
               cards[0][3].setText("\u25B2");
               cards[0][3].setForeground(Color.GREEN);
               cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[3].equals("Triangle of Red")) {
               cards[0][3].setText("\u25B2");
               cards[0][3].setForeground(Color.RED);
               cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[3].equals("Triangle of Yellow")) {
               cards[0][3].setText("\u25B2");
               cards[0][3].setForeground(Color.YELLOW);
               cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[3];
               pos1 = 4;
            }
            else if (pos1 != 4) {
               picks[1] = deck[3];
               pos2 = 4;
            }
            
            break;
            
            case 5:
            if(deck[4].equals("Square of Blue")) {
               cards[1][0].setText("\u25A0");
               cards[1][0].setForeground(Color.BLUE);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[4].equals("Square of Green")) {
               cards[1][0].setText("\u25A0");
               cards[1][0].setForeground(Color.GREEN);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[4].equals("Square of Red")) {
               cards[1][0].setText("\u25A0");
               cards[1][0].setForeground(Color.RED);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[4].equals("Square of Yellow")) {
               cards[1][0].setText("\u25A0");
               cards[1][0].setForeground(Color.YELLOW);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[4].equals("Triangle of Blue")) {
               cards[1][0].setText("\u25B2");
               cards[1][0].setForeground(Color.BLUE);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[4].equals("Triangle of Green")) {
               cards[1][0].setText("\u25B2");
               cards[1][0].setForeground(Color.GREEN);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[4].equals("Triangle of Red")) {
               cards[1][0].setText("\u25B2");
               cards[1][0].setForeground(Color.RED);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[4].equals("Triangle of Yellow")) {
               cards[1][0].setText("\u25B2");
               cards[1][0].setForeground(Color.YELLOW);
               cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[4];
               pos1 = 5;
            }
            else if (pos1 != 5) {
               picks[1] = deck[4];
               pos2 = 5;
            }  
            
            break;
            
            case 6:
            if(deck[5].equals("Square of Blue")) {
               cards[1][1].setText("\u25A0");
               cards[1][1].setForeground(Color.BLUE);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[5].equals("Square of Green")) {
               cards[1][1].setText("\u25A0");
               cards[1][1].setForeground(Color.GREEN);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[5].equals("Square of Red")) {
               cards[1][1].setText("\u25A0");
               cards[1][1].setForeground(Color.RED);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[5].equals("Square of Yellow")) {
               cards[1][1].setText("\u25A0");
               cards[1][1].setForeground(Color.YELLOW);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[5].equals("Triangle of Blue")) {
               cards[1][1].setText("\u25B2");
               cards[1][1].setForeground(Color.BLUE);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[5].equals("Triangle of Green")) {
               cards[1][1].setText("\u25B2");
               cards[1][1].setForeground(Color.GREEN);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[5].equals("Triangle of Red")) {
               cards[1][1].setText("\u25B2");
               cards[1][1].setForeground(Color.RED);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[5].equals("Triangle of Yellow")) {
               cards[1][1].setText("\u25B2");
               cards[1][1].setForeground(Color.YELLOW);
               cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[5];
               pos1 = 6;
            }
            else if (pos1 != 6) {
               picks[1] = deck[5];
               pos2 = 6;
            }
            
            break;
            
            case 7:
            if(deck[6].equals("Square of Blue")) {
               cards[1][2].setText("\u25A0");
               cards[1][2].setForeground(Color.BLUE);
               cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[6].equals("Square of Green")) {
               cards[1][2].setText("\u25A0");
               cards[1][2].setForeground(Color.GREEN);
               cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[6].equals("Square of Red")) {
               cards[1][2].setText("\u25A0");
               cards[1][2].setForeground(Color.RED);
               cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[6].equals("Square of Yellow")) {
               cards[1][2].setText("\u25A0");
               cards[1][2].setForeground(Color.YELLOW);
               cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[6].equals("Triangle of Blue")) {
               cards[1][2].setText("\u25B2");
               cards[1][2].setForeground(Color.BLUE);
               cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[6].equals("Triangle of Green")) {
               cards[1][2].setText("\u25B2");
               cards[1][2].setForeground(Color.GREEN);
               cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[6].equals("Triangle of Red")) {
               cards[1][2].setText("\u25B2");
               cards[1][2].setForeground(Color.RED);
               cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[6].equals("Triangle of Yellow")) {
               cards[1][2].setText("\u25B2");
               cards[1][2].setForeground(Color.YELLOW);
               cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[6];
               pos1 = 7;
            }
            else if (pos1 != 7) {
               picks[1] = deck[6];
               pos2 = 7;
            }
            
            break;
            
            case 8:
            if(deck[7].equals("Square of Blue")) {
               cards[1][3].setText("\u25A0");
               cards[1][3].setForeground(Color.BLUE);
               cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[7].equals("Square of Green")) {
               cards[1][3].setText("\u25A0");
               cards[1][3].setForeground(Color.GREEN);
               cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[7].equals("Square of Red")) {
               cards[1][3].setText("\u25A0");
               cards[1][3].setForeground(Color.RED);
               cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[7].equals("Square of Yellow")) {
               cards[1][3].setText("\u25A0");
               cards[1][3].setForeground(Color.YELLOW);
               cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[7].equals("Triangle of Blue")) {
               cards[1][3].setText("\u25B2");
               cards[1][3].setForeground(Color.BLUE);
               cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[7].equals("Triangle of Green")) {
               cards[1][3].setText("\u25B2");
               cards[1][3].setForeground(Color.GREEN);
               cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[7].equals("Triangle of Red")) {
               cards[1][3].setText("\u25B2");
               cards[1][3].setForeground(Color.RED);
               cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[7].equals("Triangle of Yellow")) {
               cards[1][3].setText("\u25B2");
               cards[1][3].setForeground(Color.YELLOW);
               cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[7];
               pos1 = 8;
            }
            else if (pos1 != 8) {
               picks[1] = deck[7];
               pos2 = 8;
            }
            
            break;
            
            case 9:
            if(deck[8].equals("Square of Blue")) {
               cards[2][0].setText("\u25A0");
               cards[2][0].setForeground(Color.BLUE);
               cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[8].equals("Square of Green")) {
               cards[2][0].setText("\u25A0");
               cards[2][0].setForeground(Color.GREEN);
               cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[8].equals("Square of Red")) {
               cards[2][0].setText("\u25A0");
               cards[2][0].setForeground(Color.RED);
               cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[8].equals("Square of Yellow")) {
               cards[2][0].setText("\u25A0");
               cards[2][0].setForeground(Color.YELLOW);
               cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[8].equals("Triangle of Blue")) {
               cards[2][0].setText("\u25B2");
               cards[2][0].setForeground(Color.BLUE);
               cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[8].equals("Triangle of Green")) {
               cards[2][0].setText("\u25B2");
               cards[2][0].setForeground(Color.GREEN);
               cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[8].equals("Triangle of Red")) {
               cards[2][0].setText("\u25B2");
               cards[2][0].setForeground(Color.RED);
               cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[8].equals("Triangle of Yellow")) {
               cards[2][0].setText("\u25B2");
               cards[2][0].setForeground(Color.YELLOW);
               cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[8];
               pos1 = 9;
            }
            else if (pos1 != 9) {
               picks[1] = deck[8];
               pos2 = 9;
            }
            
            break;
            
            case 10:
            if(deck[9].equals("Square of Blue")) {
               cards[2][1].setText("\u25A0");
               cards[2][1].setForeground(Color.BLUE);
               cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[9].equals("Square of Green")) {
               cards[2][1].setText("\u25A0");
               cards[2][1].setForeground(Color.GREEN);
               cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[9].equals("Square of Red")) {
               cards[2][1].setText("\u25A0");
               cards[2][1].setForeground(Color.RED);
               cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[9].equals("Square of Yellow")) {
               cards[2][1].setText("\u25A0");
               cards[2][1].setForeground(Color.YELLOW);
               cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[9].equals("Triangle of Blue")) {
               cards[2][1].setText("\u25B2");
               cards[2][1].setForeground(Color.BLUE);
               cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[9].equals("Triangle of Green")) {
               cards[2][1].setText("\u25B2");
               cards[2][1].setForeground(Color.GREEN);
               cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[9].equals("Triangle of Red")) {
               cards[2][1].setText("\u25B2");
               cards[2][1].setForeground(Color.RED);
               cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[9].equals("Triangle of Yellow")) {
               cards[2][1].setText("\u25B2");
               cards[2][1].setForeground(Color.YELLOW);
               cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[9];
               pos1 = 10;
            }
            else if (pos1 != 10) {
               picks[1] = deck[9];
               pos2 = 10;
            }
            
            break;
            
            case 11:
            if(deck[10].equals("Square of Blue")) {
               cards[2][2].setText("\u25A0");
               cards[2][2].setForeground(Color.BLUE);
               cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[10].equals("Square of Green")) {
               cards[2][2].setText("\u25A0");
               cards[2][2].setForeground(Color.GREEN);
               cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[10].equals("Square of Red")) {
               cards[2][2].setText("\u25A0");
               cards[2][2].setForeground(Color.RED);
               cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[10].equals("Square of Yellow")) {
               cards[2][2].setText("\u25A0");
               cards[2][2].setForeground(Color.YELLOW);
               cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[10].equals("Triangle of Blue")) {
               cards[2][2].setText("\u25B2");
               cards[2][2].setForeground(Color.BLUE);
               cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[10].equals("Triangle of Green")) {
               cards[2][2].setText("\u25B2");
               cards[2][2].setForeground(Color.GREEN);
               cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[10].equals("Triangle of Red")) {
               cards[2][2].setText("\u25B2");
               cards[2][2].setForeground(Color.RED);
               cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[10].equals("Triangle of Yellow")) {
               cards[2][2].setText("\u25B2");
               cards[2][2].setForeground(Color.YELLOW);
               cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[10];
               pos1 = 11;
            }
            else if (pos1 != 11) {
               picks[1] = deck[10];
               pos2 = 11;
            }
            
            break;
            
            case 12:
            if(deck[11].equals("Square of Blue")) {
               cards[2][3].setText("\u25A0");
               cards[2][3].setForeground(Color.BLUE);
               cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[11].equals("Square of Green")) {
               cards[2][3].setText("\u25A0");
               cards[2][3].setForeground(Color.GREEN);
               cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[11].equals("Square of Red")) {
               cards[2][3].setText("\u25A0");
               cards[2][3].setForeground(Color.RED);
               cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[11].equals("Square of Yellow")) {
               cards[2][3].setText("\u25A0");
               cards[2][3].setForeground(Color.YELLOW);
               cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[11].equals("Triangle of Blue")) {
               cards[2][3].setText("\u25B2");
               cards[2][3].setForeground(Color.BLUE);
               cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[11].equals("Triangle of Green")) {
               cards[2][3].setText("\u25B2");
               cards[2][3].setForeground(Color.GREEN);
               cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[11].equals("Triangle of Red")) {
               cards[2][3].setText("\u25B2");
               cards[2][3].setForeground(Color.RED);
               cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[11].equals("Triangle of Yellow")) {
               cards[2][3].setText("\u25B2");
               cards[2][3].setForeground(Color.YELLOW);
               cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[11];
               pos1 = 12;
            }
            else if (pos1 != 12) {
               picks[1] = deck[11];
               pos2 = 12;
            }
            
           break;
           
           case 13:
           if(deck[12].equals("Square of Blue")) {
               cards[3][0].setText("\u25A0");
               cards[3][0].setForeground(Color.BLUE);
               cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[12].equals("Square of Green")) {
               cards[3][0].setText("\u25A0");
               cards[3][0].setForeground(Color.GREEN);
               cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[12].equals("Square of Red")) {
               cards[3][0].setText("\u25A0");
               cards[3][0].setForeground(Color.RED);
               cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[12].equals("Square of Yellow")) {
               cards[3][0].setText("\u25A0");
               cards[3][0].setForeground(Color.YELLOW);
               cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[12].equals("Triangle of Blue")) {
               cards[3][0].setText("\u25B2");
               cards[3][0].setForeground(Color.BLUE);
               cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[12].equals("Triangle of Green")) {
               cards[3][0].setText("\u25B2");
               cards[3][0].setForeground(Color.GREEN);
               cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[12].equals("Triangle of Red")) {
               cards[3][0].setText("\u25B2");
               cards[3][0].setForeground(Color.RED);
               cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[12].equals("Triangle of Yellow")) {
               cards[3][0].setText("\u25B2");
               cards[3][0].setForeground(Color.YELLOW);
               cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[12];
               pos1 = 13;
            }
            else if (pos1 != 13) {
               picks[1] = deck[12];
               pos2 = 13;
            }

            break;
            
            case 14:
            if(deck[13].equals("Square of Blue")) {
               cards[3][1].setText("\u25A0");
               cards[3][1].setForeground(Color.BLUE);
               cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[13].equals("Square of Green")) {
               cards[3][1].setText("\u25A0");
               cards[3][1].setForeground(Color.GREEN);
               cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[13].equals("Square of Red")) {
               cards[3][1].setText("\u25A0");
               cards[3][1].setForeground(Color.RED);
               cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[13].equals("Square of Yellow")) {
               cards[3][1].setText("\u25A0");
               cards[3][1].setForeground(Color.YELLOW);
               cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[13].equals("Triangle of Blue")) {
               cards[3][1].setText("\u25B2");
               cards[3][1].setForeground(Color.BLUE);
               cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[13].equals("Triangle of Green")) {
               cards[3][1].setText("\u25B2");
               cards[3][1].setForeground(Color.GREEN);
               cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[13].equals("Triangle of Red")) {
               cards[3][1].setText("\u25B2");
               cards[3][1].setForeground(Color.RED);
               cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[13].equals("Triangle of Yellow")) {
               cards[3][1].setText("\u25B2");
               cards[3][1].setForeground(Color.YELLOW);
               cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[13];
               pos1 = 14;
            }
            else if (pos1 != 14) {
               picks[1] = deck[13];
               pos2 = 14;
            }
            
            break;
            
            case 15:
            if(deck[14].equals("Square of Blue")) {
               cards[3][2].setText("\u25A0");
               cards[3][2].setForeground(Color.BLUE);
               cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[14].equals("Square of Green")) {
               cards[3][2].setText("\u25A0");
               cards[3][2].setForeground(Color.GREEN);
               cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[14].equals("Square of Red")) {
               cards[3][2].setText("\u25A0");
               cards[3][2].setForeground(Color.RED);
               cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[14].equals("Square of Yellow")) {
               cards[3][2].setText("\u25A0");
               cards[3][2].setForeground(Color.YELLOW);
               cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[14].equals("Triangle of Blue")) {
               cards[3][2].setText("\u25B2");
               cards[3][2].setForeground(Color.BLUE);
               cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[14].equals("Triangle of Green")) {
               cards[3][2].setText("\u25B2");
               cards[3][2].setForeground(Color.GREEN);
               cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[14].equals("Triangle of Red")) {
               cards[3][2].setText("\u25B2");
               cards[3][2].setForeground(Color.RED);
               cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[14].equals("Triangle of Yellow")) {
               cards[3][2].setText("\u25B2");
               cards[3][2].setForeground(Color.YELLOW);
               cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[14];
               pos1 = 15;
            }
            else if (pos1 != 15) {
               picks[1] = deck[14];
               pos2 = 15;
            }
            
            break;
            
            case 16:
            if(deck[15].equals("Square of Blue")) {
               cards[3][3].setText("\u25A0");
               cards[3][3].setForeground(Color.BLUE);
               cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[15].equals("Square of Green")) {
               cards[3][3].setText("\u25A0");
               cards[3][3].setForeground(Color.GREEN);
               cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[15].equals("Square of Red")) {
               cards[3][3].setText("\u25A0");
               cards[3][3].setForeground(Color.RED);
               cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[15].equals("Square of Yellow")) {
               cards[3][3].setText("\u25A0");
               cards[3][3].setForeground(Color.YELLOW);
               cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[15].equals("Triangle of Blue")) {
               cards[3][3].setText("\u25B2");
               cards[3][3].setForeground(Color.BLUE);
               cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));

            }
            else if (deck[15].equals("Triangle of Green")) {
               cards[3][3].setText("\u25B2");
               cards[3][3].setForeground(Color.GREEN);
               cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[15].equals("Triangle of Red")) {
               cards[3][3].setText("\u25B2");
               cards[3][3].setForeground(Color.RED);
               cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            else if (deck[15].equals("Triangle of Yellow")) {
               cards[3][3].setText("\u25B2");
               cards[3][3].setForeground(Color.YELLOW);
               cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
            }
            if(picks[0] == null) {
               picks[0] = deck[15];
               pos1 = 16;
            }
            else if (pos1 != 16) {
               picks[1] = deck[15];
               pos2 = 16;
            }
            
            break;
      }
     } 
     //same thing but for 6x6
     if (gameLength == 6) {
      switch (action) {
         case 1:
         if(deck[0].equals("Square of Blue")){
            cards[0][0].setText("\u25A0");
            cards[0][0].setForeground(Color.BLUE);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Square of Green")){
            cards[0][0].setText("\u25A0");
            cards[0][0].setForeground(Color.GREEN);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Square of Red")){
            cards[0][0].setText("\u25A0");
            cards[0][0].setForeground(Color.RED);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Square of Yellow")) {
            cards[0][0].setText("\u25A0");
            cards[0][0].setForeground(Color.YELLOW);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Square of Magenta")) {
            cards[0][0].setText("\u25A0");
            cards[0][0].setForeground(Color.MAGENTA);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Square of Black")) {
            cards[0][0].setText("\u25A0");
            cards[0][0].setForeground(Color.BLACK);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Triangle of Blue")){
            cards[0][0].setText("\u25B2");
            cards[0][0].setForeground(Color.BLUE);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Triangle of Green")){
            cards[0][0].setText("\u25B2");
            cards[0][0].setForeground(Color.GREEN);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Triangle of Red")){
            cards[0][0].setText("\u25B2");
            cards[0][0].setForeground(Color.RED);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Triangle of Yellow")) {
            cards[0][0].setText("\u25B2");
            cards[0][0].setForeground(Color.YELLOW);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Triangle of Magenta")) {
            cards[0][0].setText("\u25B2");
            cards[0][0].setForeground(Color.MAGENTA);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Triangle of Black")) {
            cards[0][0].setText("\u25B2");
            cards[0][0].setForeground(Color.BLACK);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Circle of Blue")){
            cards[0][0].setText("\u25CF");
            cards[0][0].setForeground(Color.BLUE);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Circle of Green")){
            cards[0][0].setText("\u25CF");
            cards[0][0].setForeground(Color.GREEN);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Circle of Red")){
            cards[0][0].setText("\u25CF");
            cards[0][0].setForeground(Color.RED);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Circle of Yellow")) {
            cards[0][0].setText("\u25CF");
            cards[0][0].setForeground(Color.YELLOW);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Circle of Magenta")) {
            cards[0][0].setText("\u25CF");
            cards[0][0].setForeground(Color.MAGENTA);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[0].equals("Circle of Black")) {
            cards[0][0].setText("\u25CF");
            cards[0][0].setForeground(Color.BLACK);
            cards[0][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[0];
            pos1 = 1;
         }
         else if (pos1 != 1) {
            picks[1] = deck[0];
            pos2 = 1;
         }
         break;
         
         case 2:
         if(deck[1].equals("Square of Blue")){
            cards[0][1].setText("\u25A0");
            cards[0][1].setForeground(Color.BLUE);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Square of Green")){
            cards[0][0].setText("\u25A0");
            cards[0][1].setForeground(Color.GREEN);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Square of Red")){
            cards[0][1].setText("\u25A0");
            cards[0][1].setForeground(Color.RED);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Square of Yellow")) {
            cards[0][1].setText("\u25A0");
            cards[0][1].setForeground(Color.YELLOW);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Square of Magenta")) {
            cards[0][1].setText("\u25A0");
            cards[0][1].setForeground(Color.MAGENTA);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Square of Black")) {
            cards[0][1].setText("\u25A0");
            cards[0][1].setForeground(Color.BLACK);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Triangle of Blue")){
            cards[0][1].setText("\u25B2");
            cards[0][1].setForeground(Color.BLUE);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Triangle of Green")){
            cards[0][1].setText("\u25B2");
            cards[0][1].setForeground(Color.GREEN);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Triangle of Red")){
            cards[0][1].setText("\u25B2");
            cards[0][1].setForeground(Color.RED);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Triangle of Yellow")) {
            cards[0][1].setText("\u25B2");
            cards[0][1].setForeground(Color.YELLOW);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Triangle of Magenta")) {
            cards[0][1].setText("\u25B2");
            cards[0][1].setForeground(Color.MAGENTA);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Triangle of Black")) {
            cards[0][1].setText("\u25B2");
            cards[0][1].setForeground(Color.BLACK);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Circle of Blue")){
            cards[0][1].setText("\u25CF");
            cards[0][1].setForeground(Color.BLUE);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Circle of Green")){
            cards[0][1].setText("\u25CF");
            cards[0][1].setForeground(Color.GREEN);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Circle of Red")){
            cards[0][1].setText("\u25CF");
            cards[0][1].setForeground(Color.RED);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Circle of Yellow")) {
            cards[0][1].setText("\u25CF");
            cards[0][1].setForeground(Color.YELLOW);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Circle of Magenta")) {
            cards[0][1].setText("\u25CF");
            cards[0][1].setForeground(Color.MAGENTA);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[1].equals("Circle of Black")) {
            cards[0][1].setText("\u25CF");
            cards[0][1].setForeground(Color.BLACK);
            cards[0][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[1];
            pos1 = 2;
         }
         else if (pos1 != 2) {
            picks[1] = deck[1];
            pos2 = 2;
         }
         
         break;
         
         case 3:
         if(deck[2].equals("Square of Blue")){
            cards[0][2].setText("\u25A0");
            cards[0][2].setForeground(Color.BLUE);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Square of Green")){
            cards[0][2].setText("\u25A0");
            cards[0][2].setForeground(Color.GREEN);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Square of Red")){
            cards[0][2].setText("\u25A0");
            cards[0][2].setForeground(Color.RED);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Square of Yellow")) {
            cards[0][2].setText("\u25A0");
            cards[0][2].setForeground(Color.YELLOW);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Square of Magenta")) {
            cards[0][2].setText("\u25A0");
            cards[0][2].setForeground(Color.MAGENTA);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Square of Black")) {
            cards[0][2].setText("\u25A0");
            cards[0][2].setForeground(Color.BLACK);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Triangle of Blue")){
            cards[0][2].setText("\u25B2");
            cards[0][2].setForeground(Color.BLUE);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Triangle of Green")){
            cards[0][2].setText("\u25B2");
            cards[0][2].setForeground(Color.GREEN);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Triangle of Red")){
            cards[0][2].setText("\u25B2");
            cards[0][2].setForeground(Color.RED);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Triangle of Yellow")) {
            cards[0][2].setText("\u25B2");
            cards[0][2].setForeground(Color.YELLOW);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Triangle of Magenta")) {
            cards[0][2].setText("\u25B2");
            cards[0][2].setForeground(Color.MAGENTA);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Triangle of Black")) {
            cards[0][2].setText("\u25B2");
            cards[0][2].setForeground(Color.BLACK);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Circle of Blue")){
            cards[0][2].setText("\u25CF");
            cards[0][2].setForeground(Color.BLUE);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Circle of Green")){
            cards[0][2].setText("\u25CF");
            cards[0][2].setForeground(Color.GREEN);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Circle of Red")){
            cards[0][2].setText("\u25CF");
            cards[0][2].setForeground(Color.RED);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Circle of Yellow")) {
            cards[0][2].setText("\u25CF");
            cards[0][2].setForeground(Color.YELLOW);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Circle of Magenta")) {
            cards[0][2].setText("\u25CF");
            cards[0][2].setForeground(Color.MAGENTA);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[2].equals("Circle of Black")) {
            cards[0][2].setText("\u25CF");
            cards[0][2].setForeground(Color.BLACK);
            cards[0][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[2];
            pos1 = 3;
         }
         else if (pos1 != 3) {
            picks[1] = deck[2];
            pos2 = 3;
         }
         
         break;
         
         case 4:
         if(deck[3].equals("Square of Blue")){
            cards[0][3].setText("\u25A0");
            cards[0][3].setForeground(Color.BLUE);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Square of Green")){
            cards[0][3].setText("\u25A0");
            cards[0][3].setForeground(Color.GREEN);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Square of Red")){
            cards[0][3].setText("\u25A0");
            cards[0][3].setForeground(Color.RED);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Square of Yellow")) {
            cards[0][3].setText("\u25A0");
            cards[0][3].setForeground(Color.YELLOW);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Square of Magenta")) {
            cards[0][3].setText("\u25A0");
            cards[0][3].setForeground(Color.MAGENTA);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Square of Black")) {
            cards[0][3].setText("\u25A0");
            cards[0][3].setForeground(Color.BLACK);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Triangle of Blue")){
            cards[0][3].setText("\u25B2");
            cards[0][3].setForeground(Color.BLUE);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Triangle of Green")){
            cards[0][3].setText("\u25B2");
            cards[0][3].setForeground(Color.GREEN);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Triangle of Red")){
            cards[0][3].setText("\u25B2");
            cards[0][3].setForeground(Color.RED);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Triangle of Yellow")) {
            cards[0][3].setText("\u25B2");
            cards[0][3].setForeground(Color.YELLOW);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Triangle of Magenta")) {
            cards[0][3].setText("\u25B2");
            cards[0][3].setForeground(Color.MAGENTA);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Triangle of Black")) {
            cards[0][3].setText("\u25B2");
            cards[0][3].setForeground(Color.BLACK);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Circle of Blue")){
            cards[0][3].setText("\u25CF");
            cards[0][3].setForeground(Color.BLUE);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Circle of Green")){
            cards[0][3].setText("\u25CF");
            cards[0][3].setForeground(Color.GREEN);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Circle of Red")){
            cards[0][3].setText("\u25CF");
            cards[0][3].setForeground(Color.RED);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Circle of Yellow")) {
            cards[0][3].setText("\u25CF");
            cards[0][3].setForeground(Color.YELLOW);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Circle of Magenta")) {
            cards[0][3].setText("\u25CF");
            cards[0][3].setForeground(Color.MAGENTA);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[3].equals("Circle of Black")) {
            cards[0][3].setText("\u25CF");
            cards[0][3].setForeground(Color.BLACK);
            cards[0][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[3];
            pos1 = 4;
         }
         else if (pos1 != 4) {
            picks[1] = deck[3];
            pos2 = 4;
         }
         
         break;
         
         case 5:
         if(deck[4].equals("Square of Blue")){
            cards[0][4].setText("\u25A0");
            cards[0][4].setForeground(Color.BLUE);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Square of Green")){
            cards[0][4].setText("\u25A0");
            cards[0][4].setForeground(Color.GREEN);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Square of Red")){
            cards[0][4].setText("\u25A0");
            cards[0][4].setForeground(Color.RED);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Square of Yellow")) {
            cards[0][4].setText("\u25A0");
            cards[0][4].setForeground(Color.YELLOW);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Square of Magenta")) {
            cards[0][4].setText("\u25A0");
            cards[0][4].setForeground(Color.MAGENTA);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Square of Black")) {
            cards[0][4].setText("\u25A0");
            cards[0][4].setForeground(Color.BLACK);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Triangle of Blue")){
            cards[0][4].setText("\u25B2");
            cards[0][4].setForeground(Color.BLUE);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Triangle of Green")){
            cards[0][4].setText("\u25B2");
            cards[0][4].setForeground(Color.GREEN);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Triangle of Red")){
            cards[0][4].setText("\u25B2");
            cards[0][4].setForeground(Color.RED);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Triangle of Yellow")) {
            cards[0][4].setText("\u25B2");
            cards[0][4].setForeground(Color.YELLOW);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Triangle of Magenta")) {
            cards[0][4].setText("\u25B2");
            cards[0][4].setForeground(Color.MAGENTA);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Triangle of Black")) {
            cards[0][4].setText("\u25B2");
            cards[0][4].setForeground(Color.BLACK);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Circle of Blue")){
            cards[0][4].setText("\u25CF");
            cards[0][4].setForeground(Color.BLUE);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Circle of Green")){
            cards[0][4].setText("\u25CF");
            cards[0][4].setForeground(Color.GREEN);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Circle of Red")){
            cards[0][4].setText("\u25CF");
            cards[0][4].setForeground(Color.RED);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Circle of Yellow")) {
            cards[0][4].setText("\u25CF");
            cards[0][4].setForeground(Color.YELLOW);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Circle of Magenta")) {
            cards[0][4].setText("\u25CF");
            cards[0][4].setForeground(Color.MAGENTA);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[4].equals("Circle of Black")) {
            cards[0][4].setText("\u25CF");
            cards[0][4].setForeground(Color.BLACK);
            cards[0][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[4];
            pos1 = 5;
         }
         else if (pos1 != 5) {
            picks[1] = deck[4];
            pos2 = 5;
         }
         
         break;
         
         case 6:
         if(deck[5].equals("Square of Blue")){
            cards[0][5].setText("\u25A0");
            cards[0][5].setForeground(Color.BLUE);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Square of Green")){
            cards[0][5].setText("\u25A0");
            cards[0][5].setForeground(Color.GREEN);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Square of Red")){
            cards[0][5].setText("\u25A0");
            cards[0][5].setForeground(Color.RED);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Square of Yellow")) {
            cards[0][5].setText("\u25A0");
            cards[0][5].setForeground(Color.YELLOW);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Square of Magenta")) {
            cards[0][5].setText("\u25A0");
            cards[0][5].setForeground(Color.MAGENTA);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Square of Black")) {
            cards[0][5].setText("\u25A0");
            cards[0][5].setForeground(Color.BLACK);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Triangle of Blue")){
            cards[0][5].setText("\u25B2");
            cards[0][5].setForeground(Color.BLUE);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Triangle of Green")){
            cards[0][5].setText("\u25B2");
            cards[0][5].setForeground(Color.GREEN);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Triangle of Red")){
            cards[0][5].setText("\u25B2");
            cards[0][5].setForeground(Color.RED);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Triangle of Yellow")) {
            cards[0][5].setText("\u25B2");
            cards[0][5].setForeground(Color.YELLOW);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Triangle of Magenta")) {
            cards[0][5].setText("\u25B2");
            cards[0][5].setForeground(Color.MAGENTA);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Triangle of Black")) {
            cards[0][5].setText("\u25B2");
            cards[0][5].setForeground(Color.BLACK);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Circle of Blue")){
            cards[0][5].setText("\u25CF");
            cards[0][5].setForeground(Color.BLUE);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Circle of Green")){
            cards[0][5].setText("\u25CF");
            cards[0][5].setForeground(Color.GREEN);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Circle of Red")){
            cards[0][5].setText("\u25CF");
            cards[0][5].setForeground(Color.RED);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Circle of Yellow")) {
            cards[0][5].setText("\u25CF");
            cards[0][5].setForeground(Color.YELLOW);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Circle of Magenta")) {
            cards[0][5].setText("\u25CF");
            cards[0][5].setForeground(Color.MAGENTA);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[5].equals("Circle of Black")) {
            cards[0][5].setText("\u25CF");
            cards[0][5].setForeground(Color.BLACK);
            cards[0][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[5];
            pos1 = 6;
         }
         else if (pos1 != 6) {
            picks[1] = deck[5];
            pos2 = 6;
         }
        
        break;
        
        case 7:
        if(deck[6].equals("Square of Blue")){
            cards[1][0].setText("\u25A0");
            cards[1][0].setForeground(Color.BLUE);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Square of Green")){
            cards[1][0].setText("\u25A0");
            cards[1][0].setForeground(Color.GREEN);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Square of Red")){
            cards[1][0].setText("\u25A0");
            cards[1][0].setForeground(Color.RED);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Square of Yellow")) {
            cards[1][0].setText("\u25A0");
            cards[1][0].setForeground(Color.YELLOW);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Square of Magenta")) {
            cards[1][0].setText("\u25A0");
            cards[1][0].setForeground(Color.MAGENTA);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Square of Black")) {
            cards[1][0].setText("\u25A0");
            cards[1][0].setForeground(Color.BLACK);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Triangle of Blue")){
            cards[1][0].setText("\u25B2");
            cards[1][0].setForeground(Color.BLUE);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Triangle of Green")){
            cards[1][0].setText("\u25B2");
            cards[1][0].setForeground(Color.GREEN);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Triangle of Red")){
            cards[1][0].setText("\u25B2");
            cards[1][0].setForeground(Color.RED);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Triangle of Yellow")) {
            cards[1][0].setText("\u25B2");
            cards[1][0].setForeground(Color.YELLOW);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Triangle of Magenta")) {
            cards[1][0].setText("\u25B2");
            cards[1][0].setForeground(Color.MAGENTA);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Triangle of Black")) {
            cards[1][0].setText("\u25B2");
            cards[1][0].setForeground(Color.BLACK);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Circle of Blue")){
            cards[1][0].setText("\u25CF");
            cards[1][0].setForeground(Color.BLUE);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Circle of Green")){
            cards[1][0].setText("\u25CF");
            cards[1][0].setForeground(Color.GREEN);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Circle of Red")){
            cards[1][0].setText("\u25CF");
            cards[1][0].setForeground(Color.RED);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Circle of Yellow")) {
            cards[1][0].setText("\u25CF");
            cards[1][0].setForeground(Color.YELLOW);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Circle of Magenta")) {
            cards[1][0].setText("\u25CF");
            cards[1][0].setForeground(Color.MAGENTA);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[6].equals("Circle of Black")) {
            cards[1][0].setText("\u25CF");
            cards[1][0].setForeground(Color.BLACK);
            cards[1][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[6];
            pos1 = 7;
         }
         else if (pos1 != 7) {
            picks[1] = deck[6];
            pos2 = 7;
         }
         
         break;
         
         case 8:
         if(deck[7].equals("Square of Blue")){
            cards[1][1].setText("\u25A0");
            cards[1][1].setForeground(Color.BLUE);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Square of Green")){
            cards[1][1].setText("\u25A0");
            cards[1][1].setForeground(Color.GREEN);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Square of Red")){
            cards[1][1].setText("\u25A0");
            cards[1][1].setForeground(Color.RED);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Square of Yellow")) {
            cards[1][1].setText("\u25A0");
            cards[1][1].setForeground(Color.YELLOW);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Square of Magenta")) {
            cards[1][1].setText("\u25A0");
            cards[1][1].setForeground(Color.MAGENTA);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Square of Black")) {
            cards[1][1].setText("\u25A0");
            cards[1][1].setForeground(Color.BLACK);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Triangle of Blue")){
            cards[1][1].setText("\u25B2");
            cards[1][1].setForeground(Color.BLUE);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Triangle of Green")){
            cards[1][1].setText("\u25B2");
            cards[1][1].setForeground(Color.GREEN);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Triangle of Red")){
            cards[1][1].setText("\u25B2");
            cards[1][1].setForeground(Color.RED);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Triangle of Yellow")) {
            cards[1][1].setText("\u25B2");
            cards[1][1].setForeground(Color.YELLOW);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Triangle of Magenta")) {
            cards[1][1].setText("\u25B2");
            cards[1][1].setForeground(Color.MAGENTA);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Triangle of Black")) {
            cards[1][1].setText("\u25B2");
            cards[1][1].setForeground(Color.BLACK);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Circle of Blue")){
            cards[1][1].setText("\u25CF");
            cards[1][1].setForeground(Color.BLUE);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Circle of Green")){
            cards[1][1].setText("\u25CF");
            cards[1][1].setForeground(Color.GREEN);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Circle of Red")){
            cards[1][1].setText("\u25CF");
            cards[1][1].setForeground(Color.RED);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Circle of Yellow")) {
            cards[1][1].setText("\u25CF");
            cards[1][1].setForeground(Color.YELLOW);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Circle of Magenta")) {
            cards[1][1].setText("\u25CF");
            cards[1][1].setForeground(Color.MAGENTA);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[7].equals("Circle of Black")) {
            cards[1][1].setText("\u25CF");
            cards[1][1].setForeground(Color.BLACK);
            cards[1][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[7];
            pos1 = 8;
         }
         else if (pos1 != 8) {
            picks[1] = deck[7];
            pos2 = 8;
         }
         
         break;
         
         case 9:
         if(deck[8].equals("Square of Blue")){
            cards[1][2].setText("\u25A0");
            cards[1][2].setForeground(Color.BLUE);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Square of Green")){
            cards[1][2].setText("\u25A0");
            cards[1][2].setForeground(Color.GREEN);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Square of Red")){
            cards[1][2].setText("\u25A0");
            cards[1][2].setForeground(Color.RED);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Square of Yellow")) {
            cards[1][2].setText("\u25A0");
            cards[1][2].setForeground(Color.YELLOW);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Square of Magenta")) {
            cards[1][2].setText("\u25A0");
            cards[1][2].setForeground(Color.MAGENTA);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Square of Black")) {
            cards[1][2].setText("\u25A0");
            cards[1][2].setForeground(Color.BLACK);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Triangle of Blue")){
            cards[1][2].setText("\u25B2");
            cards[1][2].setForeground(Color.BLUE);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Triangle of Green")){
            cards[1][2].setText("\u25B2");
            cards[1][2].setForeground(Color.GREEN);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Triangle of Red")){
            cards[1][2].setText("\u25B2");
            cards[1][2].setForeground(Color.RED);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Triangle of Yellow")) {
            cards[1][2].setText("\u25B2");
            cards[1][2].setForeground(Color.YELLOW);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Triangle of Magenta")) {
            cards[1][2].setText("\u25B2");
            cards[1][2].setForeground(Color.MAGENTA);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Triangle of Black")) {
            cards[1][2].setText("\u25B2");
            cards[1][2].setForeground(Color.BLACK);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Circle of Blue")){
            cards[1][2].setText("\u25CF");
            cards[1][2].setForeground(Color.BLUE);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Circle of Green")){
            cards[1][2].setText("\u25CF");
            cards[1][2].setForeground(Color.GREEN);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Circle of Red")){
            cards[1][2].setText("\u25CF");
            cards[1][2].setForeground(Color.RED);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Circle of Yellow")) {
            cards[1][2].setText("\u25CF");
            cards[1][2].setForeground(Color.YELLOW);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Circle of Magenta")) {
            cards[1][2].setText("\u25CF");
            cards[1][2].setForeground(Color.MAGENTA);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[8].equals("Circle of Black")) {
            cards[1][2].setText("\u25CF");
            cards[1][2].setForeground(Color.BLACK);
            cards[1][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[8];
            pos1 = 9;
         }
         else if (pos1 != 9) {
            picks[1] = deck[8];
            pos2 = 9;
         }
         
         break;
         
         case 10:
         if(deck[9].equals("Square of Blue")){
            cards[1][3].setText("\u25A0");
            cards[1][3].setForeground(Color.BLUE);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Square of Green")){
            cards[1][3].setText("\u25A0");
            cards[1][3].setForeground(Color.GREEN);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Square of Red")){
            cards[1][3].setText("\u25A0");
            cards[1][3].setForeground(Color.RED);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Square of Yellow")) {
            cards[1][3].setText("\u25A0");
            cards[1][3].setForeground(Color.YELLOW);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Square of Magenta")) {
            cards[1][3].setText("\u25A0");
            cards[1][3].setForeground(Color.MAGENTA);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Square of Black")) {
            cards[1][3].setText("\u25A0");
            cards[1][3].setForeground(Color.BLACK);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Triangle of Blue")){
            cards[1][3].setText("\u25B2");
            cards[1][3].setForeground(Color.BLUE);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Triangle of Green")){
            cards[1][3].setText("\u25B2");
            cards[1][3].setForeground(Color.GREEN);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Triangle of Red")){
            cards[1][3].setText("\u25B2");
            cards[1][3].setForeground(Color.RED);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Triangle of Yellow")) {
            cards[1][3].setText("\u25B2");
            cards[1][3].setForeground(Color.YELLOW);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Triangle of Magenta")) {
            cards[1][3].setText("\u25B2");
            cards[1][3].setForeground(Color.MAGENTA);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Triangle of Black")) {
            cards[1][3].setText("\u25B2");
            cards[1][3].setForeground(Color.BLACK);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Circle of Blue")){
            cards[1][3].setText("\u25CF");
            cards[1][3].setForeground(Color.BLUE);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Circle of Green")){
            cards[1][3].setText("\u25CF");
            cards[1][3].setForeground(Color.GREEN);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Circle of Red")){
            cards[1][3].setText("\u25CF");
            cards[1][3].setForeground(Color.RED);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Circle of Yellow")) {
            cards[1][3].setText("\u25CF");
            cards[1][3].setForeground(Color.YELLOW);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Circle of Magenta")) {
            cards[1][3].setText("\u25CF");
            cards[1][3].setForeground(Color.MAGENTA);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[9].equals("Circle of Black")) {
            cards[1][3].setText("\u25CF");
            cards[1][3].setForeground(Color.BLACK);
            cards[1][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[9];
            pos1 = 10;
         }
         else if (pos1 != 10) {
            picks[1] = deck[9];
            pos2 = 10;
         }
         
         break;
         
         case 11:
         if(deck[10].equals("Square of Blue")){
            cards[1][4].setText("\u25A0");
            cards[1][4].setForeground(Color.BLUE);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Square of Green")){
            cards[1][4].setText("\u25A0");
            cards[1][4].setForeground(Color.GREEN);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Square of Red")){
            cards[1][4].setText("\u25A0");
            cards[1][4].setForeground(Color.RED);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Square of Yellow")) {
            cards[1][4].setText("\u25A0");
            cards[1][4].setForeground(Color.YELLOW);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Square of Magenta")) {
            cards[1][4].setText("\u25A0");
            cards[1][4].setForeground(Color.MAGENTA);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Square of Black")) {
            cards[1][4].setText("\u25A0");
            cards[1][4].setForeground(Color.BLACK);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Triangle of Blue")){
            cards[1][4].setText("\u25B2");
            cards[1][4].setForeground(Color.BLUE);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Triangle of Green")){
            cards[1][4].setText("\u25B2");
            cards[1][4].setForeground(Color.GREEN);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Triangle of Red")){
            cards[1][4].setText("\u25B2");
            cards[1][4].setForeground(Color.RED);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Triangle of Yellow")) {
            cards[1][4].setText("\u25B2");
            cards[1][4].setForeground(Color.YELLOW);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Triangle of Magenta")) {
            cards[1][4].setText("\u25B2");
            cards[1][4].setForeground(Color.MAGENTA);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Triangle of Black")) {
            cards[1][4].setText("\u25B2");
            cards[1][4].setForeground(Color.BLACK);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Circle of Blue")){
            cards[1][4].setText("\u25CF");
            cards[1][4].setForeground(Color.BLUE);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Circle of Green")){
            cards[1][4].setText("\u25CF");
            cards[1][4].setForeground(Color.GREEN);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Circle of Red")){
            cards[1][4].setText("\u25CF");
            cards[1][4].setForeground(Color.RED);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Circle of Yellow")) {
            cards[1][4].setText("\u25CF");
            cards[1][4].setForeground(Color.YELLOW);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Circle of Magenta")) {
            cards[1][4].setText("\u25CF");
            cards[1][4].setForeground(Color.MAGENTA);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[10].equals("Circle of Black")) {
            cards[1][4].setText("\u25CF");
            cards[1][4].setForeground(Color.BLACK);
            cards[1][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[10];
            pos1 = 11;
         }
         else if (pos1 != 11) {
            picks[1] = deck[10];
            pos2 = 11;
         }
         
         break;
         
         case 12:
         if(deck[11].equals("Square of Blue")){
            cards[1][5].setText("\u25A0");
            cards[1][5].setForeground(Color.BLUE);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Square of Green")){
            cards[1][5].setText("\u25A0");
            cards[1][5].setForeground(Color.GREEN);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Square of Red")){
            cards[1][5].setText("\u25A0");
            cards[1][5].setForeground(Color.RED);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Square of Yellow")) {
            cards[1][5].setText("\u25A0");
            cards[1][5].setForeground(Color.YELLOW);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Square of Magenta")) {
            cards[1][5].setText("\u25A0");
            cards[1][5].setForeground(Color.MAGENTA);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Square of Black")) {
            cards[1][5].setText("\u25A0");
            cards[1][5].setForeground(Color.BLACK);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Triangle of Blue")){
            cards[1][5].setText("\u25B2");
            cards[1][5].setForeground(Color.BLUE);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Triangle of Green")){
            cards[1][5].setText("\u25B2");
            cards[1][5].setForeground(Color.GREEN);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Triangle of Red")){
            cards[1][5].setText("\u25B2");
            cards[1][5].setForeground(Color.RED);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Triangle of Yellow")) {
            cards[1][5].setText("\u25B2");
            cards[1][5].setForeground(Color.YELLOW);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Triangle of Magenta")) {
            cards[1][5].setText("\u25B2");
            cards[1][5].setForeground(Color.MAGENTA);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Triangle of Black")) {
            cards[1][5].setText("\u25B2");
            cards[1][5].setForeground(Color.BLACK);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Circle of Blue")){
            cards[1][5].setText("\u25CF");
            cards[1][5].setForeground(Color.BLUE);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Circle of Green")){
            cards[1][5].setText("\u25CF");
            cards[1][5].setForeground(Color.GREEN);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Circle of Red")){
            cards[1][5].setText("\u25CF");
            cards[1][5].setForeground(Color.RED);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Circle of Yellow")) {
            cards[1][5].setText("\u25CF");
            cards[1][5].setForeground(Color.YELLOW);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Circle of Magenta")) {
            cards[1][5].setText("\u25CF");
            cards[1][5].setForeground(Color.MAGENTA);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[11].equals("Circle of Black")) {
            cards[1][5].setText("\u25CF");
            cards[1][5].setForeground(Color.BLACK);
            cards[1][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[11];
            pos1 = 12;
         }
         else if (pos1 != 12) {
            picks[1] = deck[11];
            pos2 = 12;
         }
         
         break;
         
         case 13:
         if(deck[12].equals("Square of Blue")){
            cards[2][0].setText("\u25A0");
            cards[2][0].setForeground(Color.BLUE);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Square of Green")){
            cards[2][0].setText("\u25A0");
            cards[2][0].setForeground(Color.GREEN);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Square of Red")){
            cards[2][0].setText("\u25A0");
            cards[2][0].setForeground(Color.RED);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Square of Yellow")) {
            cards[2][0].setText("\u25A0");
            cards[2][0].setForeground(Color.YELLOW);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Square of Magenta")) {
            cards[2][0].setText("\u25A0");
            cards[2][0].setForeground(Color.MAGENTA);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Square of Black")) {
            cards[2][0].setText("\u25A0");
            cards[2][0].setForeground(Color.BLACK);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Triangle of Blue")){
            cards[2][0].setText("\u25B2");
            cards[2][0].setForeground(Color.BLUE);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Triangle of Green")){
            cards[2][0].setText("\u25B2");
            cards[2][0].setForeground(Color.GREEN);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Triangle of Red")){
            cards[2][0].setText("\u25B2");
            cards[2][0].setForeground(Color.RED);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Triangle of Yellow")) {
            cards[2][0].setText("\u25B2");
            cards[2][0].setForeground(Color.YELLOW);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Triangle of Magenta")) {
            cards[2][0].setText("\u25B2");
            cards[2][0].setForeground(Color.MAGENTA);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Triangle of Black")) {
            cards[2][0].setText("\u25B2");
            cards[2][0].setForeground(Color.BLACK);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Circle of Blue")){
            cards[2][0].setText("\u25CF");
            cards[2][0].setForeground(Color.BLUE);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Circle of Green")){
            cards[2][0].setText("\u25CF");
            cards[2][0].setForeground(Color.GREEN);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Circle of Red")){
            cards[2][0].setText("\u25CF");
            cards[2][0].setForeground(Color.RED);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Circle of Yellow")) {
            cards[2][0].setText("\u25CF");
            cards[2][0].setForeground(Color.YELLOW);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Circle of Magenta")) {
            cards[2][0].setText("\u25CF");
            cards[2][0].setForeground(Color.MAGENTA);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[12].equals("Circle of Black")) {
            cards[2][0].setText("\u25CF");
            cards[2][0].setForeground(Color.BLACK);
            cards[2][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[12];
            pos1 = 13;
         }
         else if (pos1 != 13) {
            picks[1] = deck[12];
            pos2 = 13;
         }
         
         break;
         
         case 14:
         if(deck[13].equals("Square of Blue")){
            cards[2][1].setText("\u25A0");
            cards[2][1].setForeground(Color.BLUE);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Square of Green")){
            cards[2][1].setText("\u25A0");
            cards[2][1].setForeground(Color.GREEN);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Square of Red")){
            cards[2][1].setText("\u25A0");
            cards[2][1].setForeground(Color.RED);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Square of Yellow")) {
            cards[2][1].setText("\u25A0");
            cards[2][1].setForeground(Color.YELLOW);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Square of Magenta")) {
            cards[2][1].setText("\u25A0");
            cards[2][1].setForeground(Color.MAGENTA);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Square of Black")) {
            cards[2][1].setText("\u25A0");
            cards[2][1].setForeground(Color.BLACK);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Triangle of Blue")){
            cards[2][1].setText("\u25B2");
            cards[2][1].setForeground(Color.BLUE);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Triangle of Green")){
            cards[2][1].setText("\u25B2");
            cards[2][1].setForeground(Color.GREEN);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Triangle of Red")){
            cards[2][1].setText("\u25B2");
            cards[2][1].setForeground(Color.RED);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Triangle of Yellow")) {
            cards[2][1].setText("\u25B2");
            cards[2][1].setForeground(Color.YELLOW);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Triangle of Magenta")) {
            cards[2][1].setText("\u25B2");
            cards[2][1].setForeground(Color.MAGENTA);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Triangle of Black")) {
            cards[2][1].setText("\u25B2");
            cards[2][1].setForeground(Color.BLACK);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Circle of Blue")){
            cards[2][1].setText("\u25CF");
            cards[2][1].setForeground(Color.BLUE);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Circle of Green")){
            cards[2][1].setText("\u25CF");
            cards[2][1].setForeground(Color.GREEN);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Circle of Red")){
            cards[2][1].setText("\u25CF");
            cards[2][1].setForeground(Color.RED);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Circle of Yellow")) {
            cards[2][1].setText("\u25CF");
            cards[2][1].setForeground(Color.YELLOW);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Circle of Magenta")) {
            cards[2][1].setText("\u25CF");
            cards[2][1].setForeground(Color.MAGENTA);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[13].equals("Circle of Black")) {
            cards[2][1].setText("\u25CF");
            cards[2][1].setForeground(Color.BLACK);
            cards[2][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[13];
            pos1 = 14;
         }
         else if (pos1 != 14) {
            picks[1] = deck[13];
            pos2 = 14;
         }
         
         break;
         
         case 15:
         if(deck[14].equals("Square of Blue")){
            cards[2][2].setText("\u25A0");
            cards[2][2].setForeground(Color.BLUE);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Square of Green")){
            cards[2][2].setText("\u25A0");
            cards[2][2].setForeground(Color.GREEN);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Square of Red")){
            cards[2][2].setText("\u25A0");
            cards[2][2].setForeground(Color.RED);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Square of Yellow")) {
            cards[2][2].setText("\u25A0");
            cards[2][2].setForeground(Color.YELLOW);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Square of Magenta")) {
            cards[2][2].setText("\u25A0");
            cards[2][2].setForeground(Color.MAGENTA);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Square of Black")) {
            cards[2][2].setText("\u25A0");
            cards[2][2].setForeground(Color.BLACK);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Triangle of Blue")){
            cards[2][2].setText("\u25B2");
            cards[2][2].setForeground(Color.BLUE);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Triangle of Green")){
            cards[2][2].setText("\u25B2");
            cards[2][2].setForeground(Color.GREEN);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Triangle of Red")){
            cards[2][2].setText("\u25B2");
            cards[2][2].setForeground(Color.RED);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Triangle of Yellow")) {
            cards[2][2].setText("\u25B2");
            cards[2][2].setForeground(Color.YELLOW);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Triangle of Magenta")) {
            cards[2][2].setText("\u25B2");
            cards[2][2].setForeground(Color.MAGENTA);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Triangle of Black")) {
            cards[2][2].setText("\u25B2");
            cards[2][2].setForeground(Color.BLACK);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Circle of Blue")){
            cards[2][2].setText("\u25CF");
            cards[2][2].setForeground(Color.BLUE);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Circle of Green")){
            cards[2][2].setText("\u25CF");
            cards[2][2].setForeground(Color.GREEN);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Circle of Red")){
            cards[2][2].setText("\u25CF");
            cards[2][2].setForeground(Color.RED);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Circle of Yellow")) {
            cards[2][2].setText("\u25CF");
            cards[2][2].setForeground(Color.YELLOW);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Circle of Magenta")) {
            cards[2][2].setText("\u25CF");
            cards[2][2].setForeground(Color.MAGENTA);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[14].equals("Circle of Black")) {
            cards[2][2].setText("\u25CF");
            cards[2][2].setForeground(Color.BLACK);
            cards[2][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[14];
            pos1 = 15;
         }
         else if (pos1 != 15) {
            picks[1] = deck[14];
            pos2 = 15;
         }
         
         break;
         
         case 16:
         if(deck[15].equals("Square of Blue")){
            cards[2][3].setText("\u25A0");
            cards[2][3].setForeground(Color.BLUE);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Square of Green")){
            cards[2][3].setText("\u25A0");
            cards[2][3].setForeground(Color.GREEN);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Square of Red")){
            cards[2][3].setText("\u25A0");
            cards[2][3].setForeground(Color.RED);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Square of Yellow")) {
            cards[2][3].setText("\u25A0");
            cards[2][3].setForeground(Color.YELLOW);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Square of Magenta")) {
            cards[2][3].setText("\u25A0");
            cards[2][3].setForeground(Color.MAGENTA);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Square of Black")) {
            cards[2][3].setText("\u25A0");
            cards[2][3].setForeground(Color.BLACK);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Triangle of Blue")){
            cards[2][3].setText("\u25B2");
            cards[2][3].setForeground(Color.BLUE);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Triangle of Green")){
            cards[2][3].setText("\u25B2");
            cards[2][3].setForeground(Color.GREEN);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Triangle of Red")){
            cards[2][3].setText("\u25B2");
            cards[2][3].setForeground(Color.RED);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Triangle of Yellow")) {
            cards[2][3].setText("\u25B2");
            cards[2][3].setForeground(Color.YELLOW);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Triangle of Magenta")) {
            cards[2][3].setText("\u25B2");
            cards[2][3].setForeground(Color.MAGENTA);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Triangle of Black")) {
            cards[2][3].setText("\u25B2");
            cards[2][3].setForeground(Color.BLACK);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Circle of Blue")){
            cards[2][3].setText("\u25CF");
            cards[2][3].setForeground(Color.BLUE);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Circle of Green")){
            cards[2][3].setText("\u25CF");
            cards[2][3].setForeground(Color.GREEN);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Circle of Red")){
            cards[2][3].setText("\u25CF");
            cards[2][3].setForeground(Color.RED);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Circle of Yellow")) {
            cards[2][3].setText("\u25CF");
            cards[2][3].setForeground(Color.YELLOW);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Circle of Magenta")) {
            cards[2][3].setText("\u25CF");
            cards[2][3].setForeground(Color.MAGENTA);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[15].equals("Circle of Black")) {
            cards[2][3].setText("\u25CF");
            cards[2][3].setForeground(Color.BLACK);
            cards[2][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[15];
            pos1 = 16;
         }
         else if (pos1 != 16) {
            picks[1] = deck[15];
            pos2 = 16;
         }
         
         break;
         
         case 17:
         if(deck[16].equals("Square of Blue")){
            cards[2][4].setText("\u25A0");
            cards[2][4].setForeground(Color.BLUE);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Square of Green")){
            cards[2][4].setText("\u25A0");
            cards[2][4].setForeground(Color.GREEN);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Square of Red")){
            cards[2][4].setText("\u25A0");
            cards[2][4].setForeground(Color.RED);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Square of Yellow")) {
            cards[2][4].setText("\u25A0");
            cards[2][4].setForeground(Color.YELLOW);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Square of Magenta")) {
            cards[2][4].setText("\u25A0");
            cards[2][4].setForeground(Color.MAGENTA);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Square of Black")) {
            cards[2][4].setText("\u25A0");
            cards[2][4].setForeground(Color.BLACK);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Triangle of Blue")){
            cards[2][4].setText("\u25B2");
            cards[2][4].setForeground(Color.BLUE);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Triangle of Green")){
            cards[2][4].setText("\u25B2");
            cards[2][4].setForeground(Color.GREEN);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Triangle of Red")){
            cards[2][4].setText("\u25B2");
            cards[2][4].setForeground(Color.RED);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Triangle of Yellow")) {
            cards[2][4].setText("\u25B2");
            cards[2][4].setForeground(Color.YELLOW);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Triangle of Magenta")) {
            cards[2][4].setText("\u25B2");
            cards[2][4].setForeground(Color.MAGENTA);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Triangle of Black")) {
            cards[2][4].setText("\u25B2");
            cards[2][4].setForeground(Color.BLACK);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Circle of Blue")){
            cards[2][4].setText("\u25CF");
            cards[2][4].setForeground(Color.BLUE);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Circle of Green")){
            cards[2][4].setText("\u25CF");
            cards[2][4].setForeground(Color.GREEN);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Circle of Red")){
            cards[2][4].setText("\u25CF");
            cards[2][4].setForeground(Color.RED);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Circle of Yellow")) {
            cards[2][4].setText("\u25CF");
            cards[2][4].setForeground(Color.YELLOW);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Circle of Magenta")) {
            cards[2][4].setText("\u25CF");
            cards[2][4].setForeground(Color.MAGENTA);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[16].equals("Circle of Black")) {
            cards[2][4].setText("\u25CF");
            cards[2][4].setForeground(Color.BLACK);
            cards[2][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[16];
            pos1 = 17;
         }
         else if (pos1 != 17) {
            picks[1] = deck[16];
            pos2 = 17;
         }
         
         break;
         
         case 18:
         if(deck[17].equals("Square of Blue")){
            cards[2][5].setText("\u25A0");
            cards[2][5].setForeground(Color.BLUE);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Square of Green")){
            cards[2][5].setText("\u25A0");
            cards[2][5].setForeground(Color.GREEN);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Square of Red")){
            cards[2][5].setText("\u25A0");
            cards[2][5].setForeground(Color.RED);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Square of Yellow")) {
            cards[2][5].setText("\u25A0");
            cards[2][5].setForeground(Color.YELLOW);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Square of Magenta")) {
            cards[2][5].setText("\u25A0");
            cards[2][5].setForeground(Color.MAGENTA);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Square of Black")) {
            cards[2][5].setText("\u25A0");
            cards[2][5].setForeground(Color.BLACK);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Triangle of Blue")){
            cards[2][5].setText("\u25B2");
            cards[2][5].setForeground(Color.BLUE);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Triangle of Green")){
            cards[2][5].setText("\u25B2");
            cards[2][5].setForeground(Color.GREEN);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Triangle of Red")){
            cards[2][5].setText("\u25B2");
            cards[2][5].setForeground(Color.RED);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Triangle of Yellow")) {
            cards[2][5].setText("\u25B2");
            cards[2][5].setForeground(Color.YELLOW);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Triangle of Magenta")) {
            cards[2][5].setText("\u25B2");
            cards[2][5].setForeground(Color.MAGENTA);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Triangle of Black")) {
            cards[2][5].setText("\u25B2");
            cards[2][5].setForeground(Color.BLACK);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Circle of Blue")){
            cards[2][5].setText("\u25CF");
            cards[2][5].setForeground(Color.BLUE);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Circle of Green")){
            cards[2][5].setText("\u25CF");
            cards[2][5].setForeground(Color.GREEN);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Circle of Red")){
            cards[2][5].setText("\u25CF");
            cards[2][5].setForeground(Color.RED);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Circle of Yellow")) {
            cards[2][5].setText("\u25CF");
            cards[2][5].setForeground(Color.YELLOW);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Circle of Magenta")) {
            cards[2][5].setText("\u25CF");
            cards[2][5].setForeground(Color.MAGENTA);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[17].equals("Circle of Black")) {
            cards[2][5].setText("\u25CF");
            cards[2][5].setForeground(Color.BLACK);
            cards[2][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[17];
            pos1 = 18;
         }
         else if (pos1 != 18) {
            picks[1] = deck[17];
            pos2 = 18;
         }
         
         break;
         
         case 19:
         if(deck[18].equals("Square of Blue")){
            cards[3][0].setText("\u25A0");
            cards[3][0].setForeground(Color.BLUE);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Square of Green")){
            cards[3][0].setText("\u25A0");
            cards[3][0].setForeground(Color.GREEN);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Square of Red")){
            cards[3][0].setText("\u25A0");
            cards[3][0].setForeground(Color.RED);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Square of Yellow")) {
            cards[3][0].setText("\u25A0");
            cards[3][0].setForeground(Color.YELLOW);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Square of Magenta")) {
            cards[3][0].setText("\u25A0");
            cards[3][0].setForeground(Color.MAGENTA);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Square of Black")) {
            cards[3][0].setText("\u25A0");
            cards[3][0].setForeground(Color.BLACK);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Triangle of Blue")){
            cards[3][0].setText("\u25B2");
            cards[3][0].setForeground(Color.BLUE);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Triangle of Green")){
            cards[3][0].setText("\u25B2");
            cards[3][0].setForeground(Color.GREEN);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Triangle of Red")){
            cards[3][0].setText("\u25B2");
            cards[3][0].setForeground(Color.RED);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Triangle of Yellow")) {
            cards[3][0].setText("\u25B2");
            cards[3][0].setForeground(Color.YELLOW);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Triangle of Magenta")) {
            cards[3][0].setText("\u25B2");
            cards[3][0].setForeground(Color.MAGENTA);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Triangle of Black")) {
            cards[3][0].setText("\u25B2");
            cards[3][0].setForeground(Color.BLACK);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Circle of Blue")){
            cards[3][0].setText("\u25CF");
            cards[3][0].setForeground(Color.BLUE);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Circle of Green")){
            cards[3][0].setText("\u25CF");
            cards[3][0].setForeground(Color.GREEN);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Circle of Red")){
            cards[3][0].setText("\u25CF");
            cards[3][0].setForeground(Color.RED);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Circle of Yellow")) {
            cards[3][0].setText("\u25CF");
            cards[3][0].setForeground(Color.YELLOW);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Circle of Magenta")) {
            cards[3][0].setText("\u25CF");
            cards[3][0].setForeground(Color.MAGENTA);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[18].equals("Circle of Black")) {
            cards[3][0].setText("\u25CF");
            cards[3][0].setForeground(Color.BLACK);
            cards[3][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[18];
            pos1 = 19;
         }
         else if (pos1 != 19) {
            picks[1] = deck[18];
            pos2 = 19;
         }
         
         break;
         
         case 20:
         if(deck[19].equals("Square of Blue")){
            cards[3][1].setText("\u25A0");
            cards[3][1].setForeground(Color.BLUE);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Square of Green")){
            cards[3][1].setText("\u25A0");
            cards[3][1].setForeground(Color.GREEN);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Square of Red")){
            cards[3][1].setText("\u25A0");
            cards[3][1].setForeground(Color.RED);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Square of Yellow")) {
            cards[3][1].setText("\u25A0");
            cards[3][1].setForeground(Color.YELLOW);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Square of Magenta")) {
            cards[3][1].setText("\u25A0");
            cards[3][1].setForeground(Color.MAGENTA);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Square of Black")) {
            cards[3][1].setText("\u25A0");
            cards[3][1].setForeground(Color.BLACK);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Triangle of Blue")){
            cards[3][1].setText("\u25B2");
            cards[3][1].setForeground(Color.BLUE);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Triangle of Green")){
            cards[3][1].setText("\u25B2");
            cards[3][1].setForeground(Color.GREEN);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Triangle of Red")){
            cards[3][1].setText("\u25B2");
            cards[3][1].setForeground(Color.RED);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Triangle of Yellow")) {
            cards[3][1].setText("\u25B2");
            cards[3][1].setForeground(Color.YELLOW);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Triangle of Magenta")) {
            cards[3][1].setText("\u25B2");
            cards[3][1].setForeground(Color.MAGENTA);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Triangle of Black")) {
            cards[3][1].setText("\u25B2");
            cards[3][1].setForeground(Color.BLACK);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Circle of Blue")){
            cards[3][1].setText("\u25CF");
            cards[3][1].setForeground(Color.BLUE);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Circle of Green")){
            cards[3][1].setText("\u25CF");
            cards[3][1].setForeground(Color.GREEN);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Circle of Red")){
            cards[3][1].setText("\u25CF");
            cards[3][1].setForeground(Color.RED);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Circle of Yellow")) {
            cards[3][1].setText("\u25CF");
            cards[3][1].setForeground(Color.YELLOW);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Circle of Magenta")) {
            cards[3][1].setText("\u25CF");
            cards[3][1].setForeground(Color.MAGENTA);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[19].equals("Circle of Black")) {
            cards[3][1].setText("\u25CF");
            cards[3][1].setForeground(Color.BLACK);
            cards[3][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[19];
            pos1 = 20;
         }
         else if (pos1 != 20) {
            picks[1] = deck[19];
            pos2 = 20;
         }
         
         break;
         
         case 21:
         if(deck[20].equals("Square of Blue")){
            cards[3][2].setText("\u25A0");
            cards[3][2].setForeground(Color.BLUE);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Square of Green")){
            cards[3][2].setText("\u25A0");
            cards[3][2].setForeground(Color.GREEN);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Square of Red")){
            cards[3][2].setText("\u25A0");
            cards[3][2].setForeground(Color.RED);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Square of Yellow")) {
            cards[3][2].setText("\u25A0");
            cards[3][2].setForeground(Color.YELLOW);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Square of Magenta")) {
            cards[3][2].setText("\u25A0");
            cards[3][2].setForeground(Color.MAGENTA);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Square of Black")) {
            cards[3][2].setText("\u25A0");
            cards[3][2].setForeground(Color.BLACK);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Triangle of Blue")){
            cards[3][2].setText("\u25B2");
            cards[3][2].setForeground(Color.BLUE);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Triangle of Green")){
            cards[3][2].setText("\u25B2");
            cards[3][2].setForeground(Color.GREEN);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Triangle of Red")){
            cards[3][2].setText("\u25B2");
            cards[3][2].setForeground(Color.RED);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Triangle of Yellow")) {
            cards[3][2].setText("\u25B2");
            cards[3][2].setForeground(Color.YELLOW);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Triangle of Magenta")) {
            cards[3][2].setText("\u25B2");
            cards[3][2].setForeground(Color.MAGENTA);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Triangle of Black")) {
            cards[3][2].setText("\u25B2");
            cards[3][2].setForeground(Color.BLACK);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Circle of Blue")){
            cards[3][2].setText("\u25CF");
            cards[3][2].setForeground(Color.BLUE);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Circle of Green")){
            cards[3][2].setText("\u25CF");
            cards[3][2].setForeground(Color.GREEN);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Circle of Red")){
            cards[3][2].setText("\u25CF");
            cards[3][2].setForeground(Color.RED);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Circle of Yellow")) {
            cards[3][2].setText("\u25CF");
            cards[3][2].setForeground(Color.YELLOW);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Circle of Magenta")) {
            cards[3][2].setText("\u25CF");
            cards[3][2].setForeground(Color.MAGENTA);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[20].equals("Circle of Black")) {
            cards[3][2].setText("\u25CF");
            cards[3][2].setForeground(Color.BLACK);
            cards[3][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[20];
            pos1 = 21;
         }
         else if (pos1 != 21) {
            picks[1] = deck[20];
            pos2 = 21;
         }
         
         break;
         
         case 22:
         if(deck[21].equals("Square of Blue")){
            cards[3][3].setText("\u25A0");
            cards[3][3].setForeground(Color.BLUE);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Square of Green")){
            cards[3][3].setText("\u25A0");
            cards[3][3].setForeground(Color.GREEN);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Square of Red")){
            cards[3][3].setText("\u25A0");
            cards[3][3].setForeground(Color.RED);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Square of Yellow")) {
            cards[3][3].setText("\u25A0");
            cards[3][3].setForeground(Color.YELLOW);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Square of Magenta")) {
            cards[3][3].setText("\u25A0");
            cards[3][3].setForeground(Color.MAGENTA);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Square of Black")) {
            cards[3][3].setText("\u25A0");
            cards[3][3].setForeground(Color.BLACK);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Triangle of Blue")){
            cards[3][3].setText("\u25B2");
            cards[3][3].setForeground(Color.BLUE);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Triangle of Green")){
            cards[3][3].setText("\u25B2");
            cards[3][3].setForeground(Color.GREEN);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Triangle of Red")){
            cards[3][3].setText("\u25B2");
            cards[3][3].setForeground(Color.RED);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Triangle of Yellow")) {
            cards[3][3].setText("\u25B2");
            cards[3][3].setForeground(Color.YELLOW);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Triangle of Magenta")) {
            cards[3][3].setText("\u25B2");
            cards[3][3].setForeground(Color.MAGENTA);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Triangle of Black")) {
            cards[3][3].setText("\u25B2");
            cards[3][3].setForeground(Color.BLACK);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Circle of Blue")){
            cards[3][3].setText("\u25CF");
            cards[3][3].setForeground(Color.BLUE);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Circle of Green")){
            cards[3][3].setText("\u25CF");
            cards[3][3].setForeground(Color.GREEN);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Circle of Red")){
            cards[3][3].setText("\u25CF");
            cards[3][3].setForeground(Color.RED);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Circle of Yellow")) {
            cards[3][3].setText("\u25CF");
            cards[3][3].setForeground(Color.YELLOW);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Circle of Magenta")) {
            cards[3][3].setText("\u25CF");
            cards[3][3].setForeground(Color.MAGENTA);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[21].equals("Circle of Black")) {
            cards[3][3].setText("\u25CF");
            cards[3][3].setForeground(Color.BLACK);
            cards[3][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[21];
            pos1 = 22;
         }
         else if (pos1 != 22) {
            picks[1] = deck[21];
            pos2 = 22;
         }
         
         break;
         
         case 23:
         if(deck[22].equals("Square of Blue")){
            cards[3][4].setText("\u25A0");
            cards[3][4].setForeground(Color.BLUE);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Square of Green")){
            cards[3][4].setText("\u25A0");
            cards[3][4].setForeground(Color.GREEN);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Square of Red")){
            cards[3][4].setText("\u25A0");
            cards[3][4].setForeground(Color.RED);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Square of Yellow")) {
            cards[3][4].setText("\u25A0");
            cards[3][4].setForeground(Color.YELLOW);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Square of Magenta")) {
            cards[3][4].setText("\u25A0");
            cards[3][4].setForeground(Color.MAGENTA);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Square of Black")) {
            cards[3][4].setText("\u25A0");
            cards[3][4].setForeground(Color.BLACK);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Triangle of Blue")){
            cards[3][4].setText("\u25B2");
            cards[3][4].setForeground(Color.BLUE);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Triangle of Green")){
            cards[3][4].setText("\u25B2");
            cards[3][4].setForeground(Color.GREEN);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Triangle of Red")){
            cards[3][4].setText("\u25B2");
            cards[3][4].setForeground(Color.RED);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Triangle of Yellow")) {
            cards[3][4].setText("\u25B2");
            cards[3][4].setForeground(Color.YELLOW);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Triangle of Magenta")) {
            cards[3][4].setText("\u25B2");
            cards[3][4].setForeground(Color.MAGENTA);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Triangle of Black")) {
            cards[3][4].setText("\u25B2");
            cards[3][4].setForeground(Color.BLACK);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Circle of Blue")){
            cards[3][4].setText("\u25CF");
            cards[3][4].setForeground(Color.BLUE);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Circle of Green")){
            cards[3][4].setText("\u25CF");
            cards[3][4].setForeground(Color.GREEN);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Circle of Red")){
            cards[3][4].setText("\u25CF");
            cards[3][4].setForeground(Color.RED);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Circle of Yellow")) {
            cards[3][4].setText("\u25CF");
            cards[3][4].setForeground(Color.YELLOW);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Circle of Magenta")) {
            cards[3][4].setText("\u25CF");
            cards[3][4].setForeground(Color.MAGENTA);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[22].equals("Circle of Black")) {
            cards[3][4].setText("\u25CF");
            cards[3][4].setForeground(Color.BLACK);
            cards[3][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[22];
            pos1 = 23;
         }
         else if (pos1 != 23) {
            picks[1] = deck[22];
            pos2 = 23;
         }
         
         break;
         
         case 24:
         if(deck[23].equals("Square of Blue")){
            cards[3][5].setText("\u25A0");
            cards[3][5].setForeground(Color.BLUE);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Square of Green")){
            cards[3][5].setText("\u25A0");
            cards[3][5].setForeground(Color.GREEN);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Square of Red")){
            cards[3][5].setText("\u25A0");
            cards[3][5].setForeground(Color.RED);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Square of Yellow")) {
            cards[3][5].setText("\u25A0");
            cards[3][5].setForeground(Color.YELLOW);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Square of Magenta")) {
            cards[3][5].setText("\u25A0");
            cards[3][5].setForeground(Color.MAGENTA);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Square of Black")) {
            cards[3][5].setText("\u25A0");
            cards[3][5].setForeground(Color.BLACK);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Triangle of Blue")){
            cards[3][5].setText("\u25B2");
            cards[3][5].setForeground(Color.BLUE);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Triangle of Green")){
            cards[3][5].setText("\u25B2");
            cards[3][5].setForeground(Color.GREEN);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Triangle of Red")){
            cards[3][5].setText("\u25B2");
            cards[3][5].setForeground(Color.RED);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Triangle of Yellow")) {
            cards[3][5].setText("\u25B2");
            cards[3][5].setForeground(Color.YELLOW);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Triangle of Magenta")) {
            cards[3][5].setText("\u25B2");
            cards[3][5].setForeground(Color.MAGENTA);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Triangle of Black")) {
            cards[3][5].setText("\u25B2");
            cards[3][5].setForeground(Color.BLACK);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Circle of Blue")){
            cards[3][5].setText("\u25CF");
            cards[3][5].setForeground(Color.BLUE);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Circle of Green")){
            cards[3][5].setText("\u25CF");
            cards[3][5].setForeground(Color.GREEN);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Circle of Red")){
            cards[3][5].setText("\u25CF");
            cards[3][5].setForeground(Color.RED);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Circle of Yellow")) {
            cards[3][5].setText("\u25CF");
            cards[3][5].setForeground(Color.YELLOW);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Circle of Magenta")) {
            cards[3][5].setText("\u25CF");
            cards[3][5].setForeground(Color.MAGENTA);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[23].equals("Circle of Black")) {
            cards[3][5].setText("\u25CF");
            cards[3][5].setForeground(Color.BLACK);
            cards[3][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[23];
            pos1 = 24;
         }
         else if (pos1 != 24) {
            picks[1] = deck[23];
            pos2 = 24;
         }
         
         break;
         
         case 25:
         if(deck[24].equals("Square of Blue")){
            cards[4][0].setText("\u25A0");
            cards[4][0].setForeground(Color.BLUE);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Square of Green")){
            cards[4][0].setText("\u25A0");
            cards[4][0].setForeground(Color.GREEN);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Square of Red")){
            cards[4][0].setText("\u25A0");
            cards[4][0].setForeground(Color.RED);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Square of Yellow")) {
            cards[4][0].setText("\u25A0");
            cards[4][0].setForeground(Color.YELLOW);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Square of Magenta")) {
            cards[4][0].setText("\u25A0");
            cards[4][0].setForeground(Color.MAGENTA);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Square of Black")) {
            cards[4][0].setText("\u25A0");
            cards[4][0].setForeground(Color.BLACK);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Triangle of Blue")){
            cards[4][0].setText("\u25B2");
            cards[4][0].setForeground(Color.BLUE);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Triangle of Green")){
            cards[4][0].setText("\u25B2");
            cards[4][0].setForeground(Color.GREEN);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Triangle of Red")){
            cards[4][0].setText("\u25B2");
            cards[4][0].setForeground(Color.RED);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Triangle of Yellow")) {
            cards[4][0].setText("\u25B2");
            cards[4][0].setForeground(Color.YELLOW);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Triangle of Magenta")) {
            cards[4][0].setText("\u25B2");
            cards[4][0].setForeground(Color.MAGENTA);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Triangle of Black")) {
            cards[4][0].setText("\u25B2");
            cards[4][0].setForeground(Color.BLACK);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Circle of Blue")){
            cards[4][0].setText("\u25CF");
            cards[4][0].setForeground(Color.BLUE);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Circle of Green")){
            cards[4][0].setText("\u25CF");
            cards[4][0].setForeground(Color.GREEN);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Circle of Red")){
            cards[4][0].setText("\u25CF");
            cards[4][0].setForeground(Color.RED);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Circle of Yellow")) {
            cards[4][0].setText("\u25CF");
            cards[4][0].setForeground(Color.YELLOW);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Circle of Magenta")) {
            cards[4][0].setText("\u25CF");
            cards[4][0].setForeground(Color.MAGENTA);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[24].equals("Circle of Black")) {
            cards[4][0].setText("\u25CF");
            cards[4][0].setForeground(Color.BLACK);
            cards[4][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[24];
            pos1 = 25;
         }
         else if (pos1 != 25) {
            picks[1] = deck[24];
            pos2 = 25;
         }
         
         break;
         
         case 26:
         if(deck[25].equals("Square of Blue")){
            cards[4][1].setText("\u25A0");
            cards[4][1].setForeground(Color.BLUE);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Square of Green")){
            cards[4][1].setText("\u25A0");
            cards[4][1].setForeground(Color.GREEN);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Square of Red")){
            cards[4][1].setText("\u25A0");
            cards[4][1].setForeground(Color.RED);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Square of Yellow")) {
            cards[4][1].setText("\u25A0");
            cards[4][1].setForeground(Color.YELLOW);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Square of Magenta")) {
            cards[4][1].setText("\u25A0");
            cards[4][1].setForeground(Color.MAGENTA);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Square of Black")) {
            cards[4][1].setText("\u25A0");
            cards[4][1].setForeground(Color.BLACK);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Triangle of Blue")){
            cards[4][1].setText("\u25B2");
            cards[4][1].setForeground(Color.BLUE);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Triangle of Green")){
            cards[4][1].setText("\u25B2");
            cards[4][1].setForeground(Color.GREEN);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Triangle of Red")){
            cards[4][1].setText("\u25B2");
            cards[4][1].setForeground(Color.RED);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Triangle of Yellow")) {
            cards[4][1].setText("\u25B2");
            cards[4][1].setForeground(Color.YELLOW);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Triangle of Magenta")) {
            cards[4][1].setText("\u25B2");
            cards[4][1].setForeground(Color.MAGENTA);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Triangle of Black")) {
            cards[4][1].setText("\u25B2");
            cards[4][1].setForeground(Color.BLACK);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Circle of Blue")){
            cards[4][1].setText("\u25CF");
            cards[4][1].setForeground(Color.BLUE);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Circle of Green")){
            cards[4][1].setText("\u25CF");
            cards[4][1].setForeground(Color.GREEN);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Circle of Red")){
            cards[4][1].setText("\u25CF");
            cards[4][1].setForeground(Color.RED);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Circle of Yellow")) {
            cards[4][1].setText("\u25CF");
            cards[4][1].setForeground(Color.YELLOW);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Circle of Magenta")) {
            cards[4][1].setText("\u25CF");
            cards[4][1].setForeground(Color.MAGENTA);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[25].equals("Circle of Black")) {
            cards[4][1].setText("\u25CF");
            cards[4][1].setForeground(Color.BLACK);
            cards[4][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[25];
            pos1 = 26;
         }
         else if (pos1 != 26) {
            picks[1] = deck[25];
            pos2 = 26;
         } 
         
         break;
         
         case 27:
         if(deck[26].equals("Square of Blue")){
            cards[4][2].setText("\u25A0");
            cards[4][2].setForeground(Color.BLUE);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Square of Green")){
            cards[4][2].setText("\u25A0");
            cards[4][2].setForeground(Color.GREEN);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Square of Red")){
            cards[4][2].setText("\u25A0");
            cards[4][2].setForeground(Color.RED);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Square of Yellow")) {
            cards[4][2].setText("\u25A0");
            cards[4][2].setForeground(Color.YELLOW);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Square of Magenta")) {
            cards[4][2].setText("\u25A0");
            cards[4][2].setForeground(Color.MAGENTA);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Square of Black")) {
            cards[4][2].setText("\u25A0");
            cards[4][2].setForeground(Color.BLACK);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Triangle of Blue")){
            cards[4][2].setText("\u25B2");
            cards[4][2].setForeground(Color.BLUE);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Triangle of Green")){
            cards[4][2].setText("\u25B2");
            cards[4][2].setForeground(Color.GREEN);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Triangle of Red")){
            cards[4][2].setText("\u25B2");
            cards[4][2].setForeground(Color.RED);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Triangle of Yellow")) {
            cards[4][2].setText("\u25B2");
            cards[4][2].setForeground(Color.YELLOW);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Triangle of Magenta")) {
            cards[4][2].setText("\u25B2");
            cards[4][2].setForeground(Color.MAGENTA);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Triangle of Black")) {
            cards[4][2].setText("\u25B2");
            cards[4][2].setForeground(Color.BLACK);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Circle of Blue")){
            cards[4][2].setText("\u25CF");
            cards[4][2].setForeground(Color.BLUE);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Circle of Green")){
            cards[4][2].setText("\u25CF");
            cards[4][2].setForeground(Color.GREEN);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Circle of Red")){
            cards[4][2].setText("\u25CF");
            cards[4][2].setForeground(Color.RED);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Circle of Yellow")) {
            cards[4][2].setText("\u25CF");
            cards[4][2].setForeground(Color.YELLOW);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Circle of Magenta")) {
            cards[4][2].setText("\u25CF");
            cards[4][2].setForeground(Color.MAGENTA);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[26].equals("Circle of Black")) {
            cards[4][2].setText("\u25CF");
            cards[4][2].setForeground(Color.BLACK);
            cards[4][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[26];
            pos1 = 27;
         }
         else if (pos1 != 27) {
            picks[1] = deck[26];
            pos2 = 27;
         }
         
         break;
         
         case 28:
         if(deck[27].equals("Square of Blue")){
            cards[4][3].setText("\u25A0");
            cards[4][3].setForeground(Color.BLUE);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Square of Green")){
            cards[4][3].setText("\u25A0");
            cards[4][3].setForeground(Color.GREEN);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Square of Red")){
            cards[4][3].setText("\u25A0");
            cards[4][3].setForeground(Color.RED);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Square of Yellow")) {
            cards[4][3].setText("\u25A0");
            cards[4][3].setForeground(Color.YELLOW);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Square of Magenta")) {
            cards[4][3].setText("\u25A0");
            cards[4][3].setForeground(Color.MAGENTA);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Square of Black")) {
            cards[4][3].setText("\u25A0");
            cards[4][3].setForeground(Color.BLACK);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Triangle of Blue")){
            cards[4][3].setText("\u25B2");
            cards[4][3].setForeground(Color.BLUE);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Triangle of Green")){
            cards[4][3].setText("\u25B2");
            cards[4][3].setForeground(Color.GREEN);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Triangle of Red")){
            cards[4][3].setText("\u25B2");
            cards[4][3].setForeground(Color.RED);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Triangle of Yellow")) {
            cards[4][3].setText("\u25B2");
            cards[4][3].setForeground(Color.YELLOW);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Triangle of Magenta")) {
            cards[4][3].setText("\u25B2");
            cards[4][3].setForeground(Color.MAGENTA);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Triangle of Black")) {
            cards[4][3].setText("\u25B2");
            cards[4][3].setForeground(Color.BLACK);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Circle of Blue")){
            cards[4][3].setText("\u25CF");
            cards[4][3].setForeground(Color.BLUE);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Circle of Green")){
            cards[4][3].setText("\u25CF");
            cards[4][3].setForeground(Color.GREEN);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Circle of Red")){
            cards[4][3].setText("\u25CF");
            cards[4][3].setForeground(Color.RED);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Circle of Yellow")) {
            cards[4][3].setText("\u25CF");
            cards[4][3].setForeground(Color.YELLOW);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Circle of Magenta")) {
            cards[4][3].setText("\u25CF");
            cards[4][3].setForeground(Color.MAGENTA);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[27].equals("Circle of Black")) {
            cards[4][3].setText("\u25CF");
            cards[4][3].setForeground(Color.BLACK);
            cards[4][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[27];
            pos1 = 28;
         }
         else if (pos1 != 28) {
            picks[1] = deck[27];
            pos2 = 28;
         }
         
         break;
         
         case 29:
         if(deck[28].equals("Square of Blue")){
            cards[4][4].setText("\u25A0");
            cards[4][4].setForeground(Color.BLUE);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Square of Green")){
            cards[4][4].setText("\u25A0");
            cards[4][4].setForeground(Color.GREEN);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Square of Red")){
            cards[4][4].setText("\u25A0");
            cards[4][4].setForeground(Color.RED);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Square of Yellow")) {
            cards[4][4].setText("\u25A0");
            cards[4][4].setForeground(Color.YELLOW);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Square of Magenta")) {
            cards[4][4].setText("\u25A0");
            cards[4][4].setForeground(Color.MAGENTA);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Square of Black")) {
            cards[4][4].setText("\u25A0");
            cards[4][4].setForeground(Color.BLACK);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Triangle of Blue")){
            cards[4][4].setText("\u25B2");
            cards[4][4].setForeground(Color.BLUE);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Triangle of Green")){
            cards[4][4].setText("\u25B2");
            cards[4][4].setForeground(Color.GREEN);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Triangle of Red")){
            cards[4][4].setText("\u25B2");
            cards[4][4].setForeground(Color.RED);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Triangle of Yellow")) {
            cards[4][4].setText("\u25B2");
            cards[4][4].setForeground(Color.YELLOW);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Triangle of Magenta")) {
            cards[4][4].setText("\u25B2");
            cards[4][4].setForeground(Color.MAGENTA);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Triangle of Black")) {
            cards[4][4].setText("\u25B2");
            cards[4][4].setForeground(Color.BLACK);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Circle of Blue")){
            cards[4][4].setText("\u25CF");
            cards[4][4].setForeground(Color.BLUE);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Circle of Green")){
            cards[4][4].setText("\u25CF");
            cards[4][4].setForeground(Color.GREEN);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Circle of Red")){
            cards[4][4].setText("\u25CF");
            cards[4][4].setForeground(Color.RED);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Circle of Yellow")) {
            cards[4][4].setText("\u25CF");
            cards[4][4].setForeground(Color.YELLOW);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Circle of Magenta")) {
            cards[4][4].setText("\u25CF");
            cards[4][4].setForeground(Color.MAGENTA);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[28].equals("Circle of Black")) {
            cards[4][4].setText("\u25CF");
            cards[4][4].setForeground(Color.BLACK);
            cards[4][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[28];
            pos1 = 29;
         }
         else if (pos1 != 29) {
            picks[1] = deck[28];
            pos2 = 29;
         }
         
         break;
         
         case 30:
         if(deck[29].equals("Square of Blue")){
            cards[4][5].setText("\u25A0");
            cards[4][5].setForeground(Color.BLUE);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Square of Green")){
            cards[4][5].setText("\u25A0");
            cards[4][5].setForeground(Color.GREEN);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Square of Red")){
            cards[4][5].setText("\u25A0");
            cards[4][5].setForeground(Color.RED);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Square of Yellow")) {
            cards[4][5].setText("\u25A0");
            cards[4][5].setForeground(Color.YELLOW);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Square of Magenta")) {
            cards[4][5].setText("\u25A0");
            cards[4][5].setForeground(Color.MAGENTA);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Square of Black")) {
            cards[4][5].setText("\u25A0");
            cards[4][5].setForeground(Color.BLACK);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Triangle of Blue")){
            cards[4][5].setText("\u25B2");
            cards[4][5].setForeground(Color.BLUE);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Triangle of Green")){
            cards[4][5].setText("\u25B2");
            cards[4][5].setForeground(Color.GREEN);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Triangle of Red")){
            cards[4][5].setText("\u25B2");
            cards[4][5].setForeground(Color.RED);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Triangle of Yellow")) {
            cards[4][5].setText("\u25B2");
            cards[4][5].setForeground(Color.YELLOW);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Triangle of Magenta")) {
            cards[4][5].setText("\u25B2");
            cards[4][5].setForeground(Color.MAGENTA);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Triangle of Black")) {
            cards[4][5].setText("\u25B2");
            cards[4][5].setForeground(Color.BLACK);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Circle of Blue")){
            cards[4][5].setText("\u25CF");
            cards[4][5].setForeground(Color.BLUE);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Circle of Green")){
            cards[4][5].setText("\u25CF");
            cards[4][5].setForeground(Color.GREEN);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Circle of Red")){
            cards[4][5].setText("\u25CF");
            cards[4][5].setForeground(Color.RED);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Circle of Yellow")) {
            cards[4][5].setText("\u25CF");
            cards[4][5].setForeground(Color.YELLOW);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Circle of Magenta")) {
            cards[4][5].setText("\u25CF");
            cards[4][5].setForeground(Color.MAGENTA);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[29].equals("Circle of Black")) {
            cards[4][5].setText("\u25CF");
            cards[4][5].setForeground(Color.BLACK);
            cards[4][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[29];
            pos1 = 30;
         }
         else if (pos1 != 30) {
            picks[1] = deck[29];
            pos2 = 30;
         }
         
         break;
         
         case 31:
         if(deck[30].equals("Square of Blue")){
            cards[5][0].setText("\u25A0");
            cards[5][0].setForeground(Color.BLUE);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Square of Green")){
            cards[5][0].setText("\u25A0");
            cards[5][0].setForeground(Color.GREEN);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Square of Red")){
            cards[5][0].setText("\u25A0");
            cards[5][0].setForeground(Color.RED);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Square of Yellow")) {
            cards[5][0].setText("\u25A0");
            cards[5][0].setForeground(Color.YELLOW);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Square of Magenta")) {
            cards[5][0].setText("\u25A0");
            cards[5][0].setForeground(Color.MAGENTA);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Square of Black")) {
            cards[5][0].setText("\u25A0");
            cards[5][0].setForeground(Color.BLACK);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Triangle of Blue")){
            cards[5][0].setText("\u25B2");
            cards[5][0].setForeground(Color.BLUE);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Triangle of Green")){
            cards[5][0].setText("\u25B2");
            cards[5][0].setForeground(Color.GREEN);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Triangle of Red")){
            cards[5][0].setText("\u25B2");
            cards[5][0].setForeground(Color.RED);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Triangle of Yellow")) {
            cards[5][0].setText("\u25B2");
            cards[5][0].setForeground(Color.YELLOW);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Triangle of Magenta")) {
            cards[5][0].setText("\u25B2");
            cards[5][0].setForeground(Color.MAGENTA);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Triangle of Black")) {
            cards[5][0].setText("\u25B2");
            cards[5][0].setForeground(Color.BLACK);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Circle of Blue")){
            cards[5][0].setText("\u25CF");
            cards[5][0].setForeground(Color.BLUE);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Circle of Green")){
            cards[5][0].setText("\u25CF");
            cards[5][0].setForeground(Color.GREEN);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Circle of Red")){
            cards[5][0].setText("\u25CF");
            cards[5][0].setForeground(Color.RED);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Circle of Yellow")) {
            cards[5][0].setText("\u25CF");
            cards[5][0].setForeground(Color.YELLOW);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Circle of Magenta")) {
            cards[5][0].setText("\u25CF");
            cards[5][0].setForeground(Color.MAGENTA);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[30].equals("Circle of Black")) {
            cards[5][0].setText("\u25CF");
            cards[5][0].setForeground(Color.BLACK);
            cards[5][0].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[30];
            pos1 = 31;
         }
         else if (pos1 != 31) {
            picks[1] = deck[30];
            pos2 = 31;
         }
         
         break;
         
         case 32:
         if(deck[31].equals("Square of Blue")){
            cards[5][1].setText("\u25A0");
            cards[5][1].setForeground(Color.BLUE);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Square of Green")){
            cards[5][1].setText("\u25A0");
            cards[5][1].setForeground(Color.GREEN);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Square of Red")){
            cards[5][1].setText("\u25A0");
            cards[5][1].setForeground(Color.RED);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Square of Yellow")) {
            cards[5][1].setText("\u25A0");
            cards[5][1].setForeground(Color.YELLOW);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Square of Magenta")) {
            cards[5][1].setText("\u25A0");
            cards[5][1].setForeground(Color.MAGENTA);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Square of Black")) {
            cards[5][1].setText("\u25A0");
            cards[5][1].setForeground(Color.BLACK);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Triangle of Blue")){
            cards[5][1].setText("\u25B2");
            cards[5][1].setForeground(Color.BLUE);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Triangle of Green")){
            cards[5][1].setText("\u25B2");
            cards[5][1].setForeground(Color.GREEN);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Triangle of Red")){
            cards[5][1].setText("\u25B2");
            cards[5][1].setForeground(Color.RED);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Triangle of Yellow")) {
            cards[5][1].setText("\u25B2");
            cards[5][1].setForeground(Color.YELLOW);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Triangle of Magenta")) {
            cards[5][1].setText("\u25B2");
            cards[5][1].setForeground(Color.MAGENTA);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Triangle of Black")) {
            cards[5][1].setText("\u25B2");
            cards[5][1].setForeground(Color.BLACK);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Circle of Blue")){
            cards[5][1].setText("\u25CF");
            cards[5][1].setForeground(Color.BLUE);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Circle of Green")){
            cards[5][1].setText("\u25CF");
            cards[5][1].setForeground(Color.GREEN);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Circle of Red")){
            cards[5][1].setText("\u25CF");
            cards[5][1].setForeground(Color.RED);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Circle of Yellow")) {
            cards[5][1].setText("\u25CF");
            cards[5][1].setForeground(Color.YELLOW);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Circle of Magenta")) {
            cards[5][1].setText("\u25CF");
            cards[5][1].setForeground(Color.MAGENTA);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[31].equals("Circle of Black")) {
            cards[5][1].setText("\u25CF");
            cards[5][1].setForeground(Color.BLACK);
            cards[5][1].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[31];
            pos1 = 32;
         }
         else if (pos1 != 32) {
            picks[1] = deck[31];
            pos2 = 32;
         }
         
         break;
         
         case 33:
         if(deck[32].equals("Square of Blue")){
            cards[5][2].setText("\u25A0");
            cards[5][2].setForeground(Color.BLUE);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Square of Green")){
            cards[5][2].setText("\u25A0");
            cards[5][2].setForeground(Color.GREEN);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Square of Red")){
            cards[5][2].setText("\u25A0");
            cards[5][2].setForeground(Color.RED);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Square of Yellow")) {
            cards[5][2].setText("\u25A0");
            cards[5][2].setForeground(Color.YELLOW);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Square of Magenta")) {
            cards[5][2].setText("\u25A0");
            cards[5][2].setForeground(Color.MAGENTA);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Square of Black")) {
            cards[5][2].setText("\u25A0");
            cards[5][2].setForeground(Color.BLACK);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Triangle of Blue")){
            cards[5][2].setText("\u25B2");
            cards[5][2].setForeground(Color.BLUE);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Triangle of Green")){
            cards[5][2].setText("\u25B2");
            cards[5][2].setForeground(Color.GREEN);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Triangle of Red")){
            cards[5][2].setText("\u25B2");
            cards[5][2].setForeground(Color.RED);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Triangle of Yellow")) {
            cards[5][2].setText("\u25B2");
            cards[5][2].setForeground(Color.YELLOW);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Triangle of Magenta")) {
            cards[5][2].setText("\u25B2");
            cards[5][2].setForeground(Color.MAGENTA);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Triangle of Black")) {
            cards[5][2].setText("\u25B2");
            cards[5][2].setForeground(Color.BLACK);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Circle of Blue")){
            cards[5][2].setText("\u25CF");
            cards[5][2].setForeground(Color.BLUE);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Circle of Green")){
            cards[5][2].setText("\u25CF");
            cards[5][2].setForeground(Color.GREEN);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Circle of Red")){
            cards[5][2].setText("\u25CF");
            cards[5][2].setForeground(Color.RED);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Circle of Yellow")) {
            cards[5][2].setText("\u25CF");
            cards[5][2].setForeground(Color.YELLOW);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Circle of Magenta")) {
            cards[5][2].setText("\u25CF");
            cards[5][2].setForeground(Color.MAGENTA);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[32].equals("Circle of Black")) {
            cards[5][2].setText("\u25CF");
            cards[5][2].setForeground(Color.BLACK);
            cards[5][2].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[32];
            pos1 = 33;
         }
         else if (pos1 != 33) {
            picks[1] = deck[32];
            pos2 = 33;
         }
         
         break;
         
         case 34:
         if(deck[33].equals("Square of Blue")){
            cards[5][3].setText("\u25A0");
            cards[5][3].setForeground(Color.BLUE);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Square of Green")){
            cards[5][3].setText("\u25A0");
            cards[5][3].setForeground(Color.GREEN);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Square of Red")){
            cards[5][3].setText("\u25A0");
            cards[5][3].setForeground(Color.RED);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Square of Yellow")) {
            cards[5][3].setText("\u25A0");
            cards[5][3].setForeground(Color.YELLOW);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Square of Magenta")) {
            cards[5][3].setText("\u25A0");
            cards[5][3].setForeground(Color.MAGENTA);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Square of Black")) {
            cards[5][3].setText("\u25A0");
            cards[5][3].setForeground(Color.BLACK);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Triangle of Blue")){
            cards[5][3].setText("\u25B2");
            cards[5][3].setForeground(Color.BLUE);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Triangle of Green")){
            cards[5][3].setText("\u25B2");
            cards[5][3].setForeground(Color.GREEN);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Triangle of Red")){
            cards[5][3].setText("\u25B2");
            cards[5][3].setForeground(Color.RED);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Triangle of Yellow")) {
            cards[5][3].setText("\u25B2");
            cards[5][3].setForeground(Color.YELLOW);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Triangle of Magenta")) {
            cards[5][3].setText("\u25B2");
            cards[5][3].setForeground(Color.MAGENTA);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Triangle of Black")) {
            cards[5][3].setText("\u25B2");
            cards[5][3].setForeground(Color.BLACK);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Circle of Blue")){
            cards[5][3].setText("\u25CF");
            cards[5][3].setForeground(Color.BLUE);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Circle of Green")){
            cards[5][3].setText("\u25CF");
            cards[5][3].setForeground(Color.GREEN);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Circle of Red")){
            cards[5][3].setText("\u25CF");
            cards[5][3].setForeground(Color.RED);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Circle of Yellow")) {
            cards[5][3].setText("\u25CF");
            cards[5][3].setForeground(Color.YELLOW);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Circle of Magenta")) {
            cards[5][3].setText("\u25CF");
            cards[5][3].setForeground(Color.MAGENTA);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[33].equals("Circle of Black")) {
            cards[5][3].setText("\u25CF");
            cards[5][3].setForeground(Color.BLACK);
            cards[5][3].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[33];
            pos1 = 34;
         }
         else if (pos1 != 34) {
            picks[1] = deck[33];
            pos2 = 34;
         }
         
         break;
         
         case 35:
         if(deck[34].equals("Square of Blue")){
            cards[5][4].setText("\u25A0");
            cards[5][4].setForeground(Color.BLUE);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Square of Green")){
            cards[5][4].setText("\u25A0");
            cards[5][4].setForeground(Color.GREEN);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Square of Red")){
            cards[5][4].setText("\u25A0");
            cards[5][4].setForeground(Color.RED);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Square of Yellow")) {
            cards[5][4].setText("\u25A0");
            cards[5][4].setForeground(Color.YELLOW);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Square of Magenta")) {
            cards[5][4].setText("\u25A0");
            cards[5][4].setForeground(Color.MAGENTA);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Square of Black")) {
            cards[5][4].setText("\u25A0");
            cards[5][4].setForeground(Color.BLACK);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Triangle of Blue")){
            cards[5][4].setText("\u25B2");
            cards[5][4].setForeground(Color.BLUE);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Triangle of Green")){
            cards[5][4].setText("\u25B2");
            cards[5][4].setForeground(Color.GREEN);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Triangle of Red")){
            cards[5][4].setText("\u25B2");
            cards[5][4].setForeground(Color.RED);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Triangle of Yellow")) {
            cards[5][4].setText("\u25B2");
            cards[5][4].setForeground(Color.YELLOW);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Triangle of Magenta")) {
            cards[5][4].setText("\u25B2");
            cards[5][4].setForeground(Color.MAGENTA);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Triangle of Black")) {
            cards[5][4].setText("\u25B2");
            cards[5][4].setForeground(Color.BLACK);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Circle of Blue")){
            cards[5][4].setText("\u25CF");
            cards[5][4].setForeground(Color.BLUE);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Circle of Green")){
            cards[5][4].setText("\u25CF");
            cards[5][4].setForeground(Color.GREEN);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Circle of Red")){
            cards[5][4].setText("\u25CF");
            cards[5][4].setForeground(Color.RED);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Circle of Yellow")) {
            cards[5][4].setText("\u25CF");
            cards[5][4].setForeground(Color.YELLOW);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Circle of Magenta")) {
            cards[5][4].setText("\u25CF");
            cards[5][4].setForeground(Color.MAGENTA);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[34].equals("Circle of Black")) {
            cards[5][4].setText("\u25CF");
            cards[5][4].setForeground(Color.BLACK);
            cards[5][4].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[34];
            pos1 = 35;
         }
         else if (pos1 != 35) {
            picks[1] = deck[34];
            pos2 = 35;
         }
         
         break; 
         
         case 36:
         if(deck[35].equals("Square of Blue")){
            cards[5][5].setText("\u25A0");
            cards[5][5].setForeground(Color.BLUE);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Square of Green")){
            cards[5][5].setText("\u25A0");
            cards[5][5].setForeground(Color.GREEN);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Square of Red")){
            cards[5][5].setText("\u25A0");
            cards[5][5].setForeground(Color.RED);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Square of Yellow")) {
            cards[5][5].setText("\u25A0");
            cards[5][5].setForeground(Color.YELLOW);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Square of Magenta")) {
            cards[5][5].setText("\u25A0");
            cards[5][5].setForeground(Color.MAGENTA);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Square of Black")) {
            cards[5][5].setText("\u25A0");
            cards[5][5].setForeground(Color.BLACK);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Triangle of Blue")){
            cards[5][5].setText("\u25B2");
            cards[5][5].setForeground(Color.BLUE);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Triangle of Green")){
            cards[5][5].setText("\u25B2");
            cards[5][5].setForeground(Color.GREEN);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Triangle of Red")){
            cards[5][5].setText("\u25B2");
            cards[5][5].setForeground(Color.RED);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Triangle of Yellow")) {
            cards[5][5].setText("\u25B2");
            cards[5][5].setForeground(Color.YELLOW);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Triangle of Magenta")) {
            cards[5][5].setText("\u25B2");
            cards[5][5].setForeground(Color.MAGENTA);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Triangle of Black")) {
            cards[5][5].setText("\u25B2");
            cards[5][5].setForeground(Color.BLACK);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Circle of Blue")){
            cards[5][5].setText("\u25CF");
            cards[5][5].setForeground(Color.BLUE);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Circle of Green")){
            cards[5][5].setText("\u25CF");
            cards[5][5].setForeground(Color.GREEN);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Circle of Red")){
            cards[5][5].setText("\u25CF");
            cards[5][5].setForeground(Color.RED);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Circle of Yellow")) {
            cards[5][5].setText("\u25CF");
            cards[5][5].setForeground(Color.YELLOW);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Circle of Magenta")) {
            cards[5][5].setText("\u25CF");
            cards[5][5].setForeground(Color.MAGENTA);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         else if(deck[35].equals("Circle of Black")) {
            cards[5][5].setText("\u25CF");
            cards[5][5].setForeground(Color.BLACK);
            cards[5][5].setFont(new Font("Arial", Font.PLAIN, 100));
         }
         if(picks[0] == null) {
            picks[0] = deck[35];
            pos1 = 36;
         }
         else if (pos1 != 36) {
            picks[1] = deck[35];
            pos2 = 36;
         }
         
         break;
      }
     }  
     //runs through this scenario to check if the pick[x] equal eachother
     if (gameLength == 2) {
         if((picks[0].equals(picks[1]))&&picks[1]!=null&&picks[0]!=null){
            row1 = (pos1 - 1)/2;
            column1 = (pos1 - 1)%2;
            row2 = (pos2-1)/2;
            column2 = (pos2-1)%2;
            check = false;
            picks[1] = null;
            picks[0] = null;
            cards[row1][column1].setBackground(Color.LIGHT_GRAY);
            cards[row2][column2].setBackground(Color.LIGHT_GRAY);
            cards[row1][column1].setEnabled(false);
            cards[row2][column2].setEnabled(false);
            gameCount--;
            if(getGameCount() == 0) {
               gameCount++;
               System.out.println("GAME OVER");
               JFrame frame = new JFrame();
                //JOptionPane comes when game is over to ask if player wants to quit or keep playing
               String message = "Play Again?";
               int answer = JOptionPane.showConfirmDialog(frame, message);
               //if player clicks yes, exit out of curren JFrame and restart the game method
               if (answer == JOptionPane.YES_OPTION) {
                   dispose();
                  SrivastavaDeck test = new SrivastavaDeck(2);
                  test.Game();
    
                   return;
    //if player clicks no, close the program
    } else if (answer == JOptionPane.NO_OPTION) {
      System.exit(0);
    }

            }
         }
         else if(picks[0] != null && picks[1] != null) {
            timer.start();
            picks[0] = null;
            picks[1] = null;
            row1 = (pos1 - 1)/2;
            column1 = (pos1 - 1)%2;
            row2 = (pos2-1)/2;
            column2 = (pos2-1)%2;
            check = true;
         }

     }
     //same thing but for 4x4
     if (gameLength == 4) {
         if((picks[0].equals(picks[1]))&&picks[1]!=null&&picks[0]!=null){
            row1 = (pos1 - 1)/4;
            column1 = (pos1 - 1)%4;
            row2 = (pos2-1)/4;
            column2 = (pos2-1)%4;
            check = false;
            picks[1] = null;
            picks[0] = null;
            cards[row1][column1].setBackground(Color.LIGHT_GRAY);
            cards[row2][column2].setBackground(Color.LIGHT_GRAY);
            cards[row1][column1].setEnabled(false);
            cards[row2][column2].setEnabled(false);
            gameCount--;
            if(getGameCount() == 0) {
               gameCount++;
               System.out.println("GAME OVER");
               JFrame frame = new JFrame();
               String message = "Play Again?";
               int answer = JOptionPane.showConfirmDialog(frame, message);
               if (answer == JOptionPane.YES_OPTION) {
                   dispose();
                  SrivastavaDeck test = new SrivastavaDeck(4);
                  test.Game();
    
    } else if (answer == JOptionPane.NO_OPTION) {
      System.exit(0);
    }

            }
         }
         else if(picks[0] != null && picks[1] != null) {
            timer.start();
            picks[0] = null;
            picks[1] = null;
            row1 = (pos1 - 1)/4;
            column1 = (pos1 - 1)%4;
            row2 = (pos2-1)/4;
            column2 = (pos2-1)%4;
            check = true;
         }
     }
     //same thing but 6x6
     if (gameLength == 6) {
         if((picks[0].equals(picks[1]))&&picks[1]!=null&&picks[0]!=null){
            row1 = (pos1 - 1)/6;
            column1 = (pos1 - 1)%6;
            row2 = (pos2-1)/6;
            column2 = (pos2-1)%6;
            check = false;
            picks[1] = null;
            picks[0] = null;
            cards[row1][column1].setBackground(Color.LIGHT_GRAY);
            cards[row2][column2].setBackground(Color.LIGHT_GRAY);
            cards[row1][column1].setEnabled(false);
            cards[row2][column2].setEnabled(false);
            gameCount--;
            if(getGameCount() == 0) {
               gameCount++;
               System.out.println("GAME OVER");
               JFrame frame = new JFrame();
               String message = "Play Again?";
               int answer = JOptionPane.showConfirmDialog(frame, message);
               if (answer == JOptionPane.YES_OPTION) {
                   dispose();
                  SrivastavaDeck test = new SrivastavaDeck(6);
                  test.Game();
    
                   return;
    } else if (answer == JOptionPane.NO_OPTION) {
      System.exit(0);
    }

            }
         }
         else if(picks[0] != null && picks[1] != null) {
            timer.start();
            picks[0] = null;
            picks[1] = null;
            row1 = (pos1 - 1)/6;
            column1 = (pos1 - 1)%6;
            row2 = (pos2-1)/6;
            column2 = (pos2-1)%6;
            check = true;
         }
     }
     
   }
}