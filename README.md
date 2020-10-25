# Memory
The game memory developed as a coding project to learn Java.
The game is based off the game Concentration , a game where a person tries to math two cards of the same design in a pile of face down cards.

# How it works
The game uses three classes to execute the game in its entirety.
The class MemoryGame.java is the executable file for the game. It prompts the user to pick from one of three board game sizes and begins the process
of playing the game.

The SrivastavaDeck.java class creates the deck of cards used to play the game, dependent on the board game size chosen in the MemoryGame.java class. 
Using prestored colors and shapes, it creates a deck with the exact number of cards needed.

The SrivastavaMemory.java class is the processor for the game. It determines the current states of each of the cards including the location of all the cards, 
whether a card has been selected, if it matches the card selected, and if the cards have already been mathced to a pair.

# How to Run
Download all the files into the same folder. Open the class MemoryGame.java and run the file.
