package game;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class GameTest {
    
    @Test public void testGetsRemainingAttempts() {
        WordChooser mockedChooser = mock(WordChooser.class);
        Game game = new Game(mockedChooser, "Name");
        assertEquals(game.getRemainingGuesses(), Integer.valueOf(10));
    }

    @Test public void testGetsWordToGuess() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWord()).thenReturn("DEVELOPER");
        Game game = new Game(mockedChooser, "Name");
        assertEquals(game.getWordToGuess(), "D________");
    }

    @Test public void testCheckLetter() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWord()).thenReturn("DEVELOPER");
        Game game = new Game(mockedChooser, "Name");
        assertEquals(game.getWordToGuess(), "D________");
    }

    @Test public void testGuessLetterRightAndDisplayGuessedLetter() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWord()).thenReturn("MAKERS");
    
        Game game = new Game(mockedChooser, "Name");
    
        assertEquals(game.guessLetter('K'), true);
        assertEquals(game.getWordToGuess(), "M_K___");
    }
    
    @Test public void testGuessLetterWrong() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWord()).thenReturn("MAKERS");
    
    
        Game game = new Game(mockedChooser, "Name");
    
        assertEquals(game.guessLetter('O'), false);
        assertEquals(game.getWordToGuess(), "M_____");
    }

    @Test public void testIsWon() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWord()).thenReturn("TEA");
    
        Game game = new Game(mockedChooser, "Name");
        game.guessLetter('T');
        game.guessLetter('E');
        game.guessLetter('A');
    
        assertEquals(game.isGameWon(), true);
    }
    
    @Test public void testIsWonWithSpecialWord() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWord()).thenReturn("COOL");
    
        Game game = new Game(mockedChooser, "Name");
        game.guessLetter('C');
        game.guessLetter('O');
        game.guessLetter('L');
    
        assertEquals(game.isGameWon(), true);
    }



}