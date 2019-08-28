package game_of_life;

import java.util.Timer;

public class GameOfLife {

    private boolean[][] gameboard;
    final static int BOARD_PADDING = 5;

    private GameboardResolutionSettings gameboardResolutionSettings;
    private GameboardFillingSettings gameboardFillingSettings;
    private GameVariationSettings gameVariationSettings;
    private GameboardRefreshingSettings gameboardRefreshingSettings;

    public GameOfLife(GameboardResolutionSettings gameboardResolutionSettings, GameboardFillingSettings gameboardFillingSettings, GameVariationSettings gameVariationSettings, GameboardRefreshingSettings gameboardRefreshingSettings) {
        this.gameboardResolutionSettings = gameboardResolutionSettings;
        this.gameboardFillingSettings = gameboardFillingSettings;
        this.gameVariationSettings = gameVariationSettings;
        this.gameboardRefreshingSettings=gameboardRefreshingSettings;
    }

    public void play() {
        generateGameboard(gameboardResolutionSettings);
        new GameboardFiller(gameboard, gameboardFillingSettings).fill();
        Timer timer = new Timer();
        timer.schedule(new Evolver(gameVariationSettings, gameboard), gameboardRefreshingSettings.getPeriodInMilliseconds(), gameboardRefreshingSettings.getPeriodInMilliseconds());
    }

    private void generateGameboard(GameboardResolutionSettings gameboardResolutionSettings) {
        gameboard = new boolean[gameboardResolutionSettings.getLogicWidth() + (2 * BOARD_PADDING)][gameboardResolutionSettings.getLogicHeight() + (2 * BOARD_PADDING)];
    }
}
