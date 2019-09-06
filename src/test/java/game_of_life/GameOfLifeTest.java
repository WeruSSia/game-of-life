package game_of_life;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {

    private GameOfLife gameOfLife;
    private GameSettings defaultSettings = new GameSettings();

    @Before
    public void setUp(){
        gameOfLife = new GameOfLife(defaultSettings);
    }

    @Test
    public void play() {
    }
}