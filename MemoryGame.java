//This is the class that you should run to start the game Memory
//the point of the game is to match the squares to their respective counterparts
//for example you want to match the blue square with the blue square
//and the red triangle with the red triangle
//when all the squares have been matched, you win

import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane;

public class MemoryGame {
   public static void main (String[] args) {
      //creates a variable for the game to run
      int n = 0;
      //creates array for the drop down menu
      String[] options = {"2x2", "4x4", "6x6"};
      //creates a JoptionPane cast to a string
      //this JOPtionPane has a dropdown menu that allows the user to choose between 2x2, 4x4, and 6x6
      String input = (String) JOptionPane.showInputDialog(null, "What size board do you want", "Memory", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      //check if value is 4x4
      //then creates a game that is 4x4 if true
      if(input.equals("4x4")) {
         n = 4;
      }
      //checks if game is 2x2
      //then creates game 2x if true
      else if (input.equals("2x2")) {
         n = 2;
      }
      //checks if user chose 6x6
      //if true then creates a game that 6x6
      else if (input.equals("6x6")) {
         n = 6;
      }
      //creates the object for the actual game
      SrivastavaDeck fa = new SrivastavaDeck(n);
      //allows the user to play the game
      fa.Game();
   }
}