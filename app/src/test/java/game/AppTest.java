package game;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class AppTest {
    
    @Test public void testGetsRemainingAttempts() {
        WordChooser mockedChooser = mock(WordChooser.class);
        Game game = new Game(mockedChooser, "Name");
        assertEquals(game.getRemainingGuesses(), Integer.valueOf(10));
    }

}