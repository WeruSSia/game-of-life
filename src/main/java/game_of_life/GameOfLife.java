package game_of_life;

public class GameOfLife {

    private boolean[][] gameboard;
    final static int BOARD_PADDING = 5;

    private GameboardResolutionSettings gameboardResolutionSettings;
    private GameboardFillingSettings gameboardFillingSettings;
    private GameVariationSettings gameVariationSettings;

    public GameOfLife(GameboardResolutionSettings gameboardResolutionSettings, GameboardFillingSettings gameboardFillingSettings, GameVariationSettings gameVariationSettings) {
        this.gameboardResolutionSettings = gameboardResolutionSettings;
        this.gameboardFillingSettings = gameboardFillingSettings;
        this.gameVariationSettings = gameVariationSettings;
    }

    public void play() {
        generateGameboard(gameboardResolutionSettings);
        new GameboardFiller(gameboard, gameboardFillingSettings).fill();
        for (int i = 0; i < 20; i++) {
            System.out.println(toString());
            evolve();
        }
    }

    private void generateGameboard(GameboardResolutionSettings gameboardResolutionSettings) {
        gameboard = new boolean[gameboardResolutionSettings.getLogicWidth() + (2 * BOARD_PADDING)][gameboardResolutionSettings.getLogicHeight() + (2 * BOARD_PADDING)];
    }

    boolean[][] getGameboardCopy() {
        boolean[][] gameboardCopy = new boolean[gameboard.length][gameboard[0].length];
        for (int i = 0; i < gameboard.length; i++) {
            System.arraycopy(gameboard[i], 0, gameboardCopy[i], 0, gameboard[i].length);
        }
        return gameboardCopy;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = BOARD_PADDING; i < gameboard.length - BOARD_PADDING; i++) {
            boolean[] row = gameboard[i];
            for (int j = BOARD_PADDING; j < row.length - BOARD_PADDING; j++) {
                boolean cell = row[j];
                stringBuilder.append(cell ? "0" : ".").append("  ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
