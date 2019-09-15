package game_of_life;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class GameOfLifeTest {

    private GameOfLife gameOfLife;
    private GameSettings defaultSettings = mock(GameSettings.class);

    @Before
    public void setUp() {
        gameOfLife = new GameOfLife(defaultSettings);
    }

    @Test
    public void play() {
    }
}