//This class creates the deck of cards used to play the game
//it alos randomizes each of the decks in order to keep the game random

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
import java.util.ArrayList;

public class SrivastavaDeck {
   //creates String array
   public static String[] deck;
   //creates stored value
   public int gameSize;
   //constructor for class
   public SrivastavaDeck (int x) {
      //needed because ther eare 3 game sizes
      gameSize = x;
      //creates the string of colors
      String[] color = {"Blue", "Green", "Red", "Yellow", "Magenta", "Black"};
      //creates the array of shapes
      String[] shape = {"Square", "Triangle", "Circle"};
      //creates the "deck" of cards
      deck = new String[gameSize*gameSize];
      int v = 0;
      int d = (gameSize * gameSize) / 2;
      //creates deck for 2x2
      if (gameSize == 2) {
         for (int i = 0; i < color.length-4; i++) {
            deck[i] = shape[0] + " of " + color[i];
         }
         for (int i = d; i < deck.length; i++) {
            deck[i] = shape[0] + " of " + color[v];
            v++;
         }
      }
      //creates deck for 4x4
      if (gameSize == 4) {
         for (int i = 0; i < shape.length-1; i++) {
            for (int j = 0; j < color.length-2; j++) {
               deck[v] = shape[i] + " of " + color[j];
               v++;
            }
         }
         for (int i = 0; i < shape.length-1; i++) {
            for (int j = 0; j < color.length-2; j++) {
               deck[d] = shape[i] + " of " + color[j];
               d++;
            }
         }

      }
      
      //creates deckk for 6x6
      if(gameSize == 6) {
         for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < color.length; j++) {
               deck[v] = shape[i] + " of " + color[j];
               v++;
            }
         }
         for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < color.length; j++) {
               deck[d] = shape[i] + " of " + color[j];
               d++;
            }
         }

      } 
   }   
   //shuffles array so that the game is not too easy
   Random rnd = new Random();
   public void randomize() {
      for (int i = 0; i < deck.length; i++){
         int index = rnd.nextInt(i + 1);
         String temp = deck[index];
         deck[index] = deck[i];
         deck[i] = temp;
      }
   }
   
   
   
   //compialtes and creates the game then runs it/
   public void Game() {
      SrivastavaMemory board = new SrivastavaMemory("Memory", gameSize);
    /*  int n= deck.length;
      for(int i = 0; i < n; i++){
         System.out.println(deck[i]);     
      }
      System.out.println(deck.length); */
      board.pack();
      board.setLocationRelativeTo(null);
      board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      board.setVisible(true);
   } 
}
