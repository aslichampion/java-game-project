package game;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class MaskerTest {
    @Test
    public void testGetsMaskedWord() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWord()).thenReturn("DEVELOPER");
        Masker masker = new Masker();
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        guessedLetters.add('E');
        guessedLetters.add('V');

        assertEquals(masker.getMaskedWord("DEVELOPER", guessedLetters), "DEVE___E_");
    }
}
