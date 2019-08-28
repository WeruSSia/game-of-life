package game_of_life;

import java.util.Timer;

public class GameOfLife {

    private boolean[][] gameboard;
    final static int BOARD_PADDING = 5;

    private GameSettings gameSettings;

    public GameOfLife(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public void play() {
        generateGameboard(gameSettings);
        new GameboardFiller(gameboard, gameSettings).fill();
        Timer timer = new Timer();
        timer.schedule(new Evolver(gameSettings, gameboard), gameSettings.getRefreshingPeriodInMilliseconds(), gameSettings.getRefreshingPeriodInMilliseconds());
    }

    private void generateGameboard(GameSettings gameSettings) {
        gameboard = new boolean[gameSettings.getLogicHeight() + (2 * BOARD_PADDING)][gameSettings.getLogicWidth() + (2 * BOARD_PADDING)];
    }
}
