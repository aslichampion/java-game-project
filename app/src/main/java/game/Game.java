package game;
import java.util.ArrayList;

public class Game {
    
    public String word;
    public String playerName;
    public ArrayList<Character> guessedLetters = new ArrayList<Character>();
    public Integer remainingGuesses = 10;

    public Game(WordChooser wordChooser, String name) {
        word = wordChooser.getRandomWord();
        playerName = name;
    }

    public Integer getRemainingGuesses() {

        return remainingGuesses;

    }

    public String getWordToGuess() {

        Masker maskedWord = new Masker();
        return maskedWord.getMaskedWord(word, guessedLetters);

    }

    public Boolean guessLetter(Character letter) {
        if (this.word.indexOf(letter) != -1) {
            guessedLetters.add(letter);
            return true;
        } else {
            remainingGuesses--;
            return false;
        }
    }

    public Boolean isGameWon() {

        for (int i = 1 ; i < word.length() ; i++) {
            Character letter = word.charAt(i);
            if (guessedLetters.indexOf(letter) == -1) {
                return false;
            }
        }
        return true;
    }

    public Boolean isGameLost() {
        
        if (remainingGuesses == 0) {
            return true;
        } 
        return false;
    }
}