package game;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // Static variables declared so they can be accessed at various times in loops.
    // Array lists used to store multiple game and player instances. 

    static Integer players;
    static ArrayList<Game> games = new ArrayList<Game>();
    static ArrayList<String> playerNames = new ArrayList<String>();
    static WordChooser chooser = new WordChooser();
    static Boolean result;

    // Multiple for loops allow for a dynamically selectable number of players without 
    // unnecessary repeating of messages that should only be output once.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many people would like to play?:");
        players = scanner.nextInt();
        
        // For loop beginning at 1 for human readable player numbers.

        for (int i = 1 ; i <= players ; i++) {
            
            System.out.println(String.format("Please enter a name for player %s:", i));
            String newName = scanner.next();
            playerNames.add(newName);

        }

        System.out.println("Welcome! Today your words to guess are:");

        for (int i = 0 ; i < players ; i++) {
            
            games.add(new Game(chooser, playerNames.get(i)));
            System.out.println(String.format("%s: %s", games.get(i).playerName, games.get(i).getWordToGuess()));

        }

        gameRunning: {
            
            do {
                
                for (int i = 0 ; i < players ; i++) {

                    // Initial text input accounts for user inputting quit (case insensitive), to end the program.
                    
                    System.out.println(String.format("%s: Enter one letter to guess, %s attempts remain", games.get(i).playerName, games.get(i).remainingGuesses));
                    String input = scanner.next().toLowerCase();
                    Character guess = input.toUpperCase().charAt(0);
                    if (input.contentEquals("quit")) {
                        System.exit(0);
                    } else {
                    result = games.get(i).guessLetter(guess);
                    }

                    // If a guess is a correct match the game will check to see if the game has been won by any player, and 
                    // if so break out of the nested loop. If nobody has won the loop will continue.

                    // If a guess is incorrect, the game will check to see if the current player is out of guesses, if so
                    // they will be eliminated from the game by removing their game instance from the Game ArrayList. This
                    // then lets remaining players continue and does not immediately break out of the loop.

                    if (result) {
                        if (games.get(i).isGameWon()) {
                            System.out.println(String.format("Congratulations, you have won %s!", games.get(i).playerName));
                            break gameRunning;
                        } else {
                        System.out.print("Correct! : ");
                        }
                    } else {
                        if (games.get(i).isGameLost()) {
                            System.out.println(String.format("Oh no! Out of tries %s!", games.get(i).playerName));
                            games.remove(i);
                            players --;
                            break;
                        } else {
                        System.out.print("Incorrect! : ");
                        }
                    }
                    System.out.println(games.get(i).getWordToGuess()+"\n");
                }

                // Outer loop will run until all players have been eliminated and players has been decrememnted to 0 by the loop.

            } while (players > 0);
        }
        scanner.close();
    }
}