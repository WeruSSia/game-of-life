package game_of_life;

public class GameOfLife {

    private boolean[][] gameboard;
    final static int BOARD_PADDING = 5;

    private GameboardResolutionSettings gameboardResolutionSettings;
    private GameboardFillingSettings gameboardFillingSettings;
    private GameModificationSettings gameModificationSettings;

    public GameOfLife(GameboardResolutionSettings gameboardResolutionSettings, GameboardFillingSettings gameboardFillingSettings, GameModificationSettings gameModificationSettings) {
        this.gameboardResolutionSettings = gameboardResolutionSettings;
        this.gameboardFillingSettings = gameboardFillingSettings;
        this.gameModificationSettings = gameModificationSettings;
    }

    public void play() {
        generateGameboard(gameboardResolutionSettings.getLogicWidth(), gameboardResolutionSettings.getLogicHeight());
        new GameboardFiller(gameboard, gameboardFillingSettings).fill();
        System.out.println(toString());
        evolve();
        System.out.println(toString());
    }

    private void generateGameboard(int logicWidth, int logicHeight) {
        gameboard = new boolean[logicWidth + (2 * BOARD_PADDING)][logicHeight + (2 * BOARD_PADDING)];
    }

    private void evolve() {
        boolean[][] gameboardCopy = copyGameboard();
        for (int i = 1; i < gameboard.length - 1; i++) {
            for (int j = 1; j < gameboard[i].length - 1; j++) {
                gameboard[i][j] = willSurviveToNextGeneration(gameboardCopy, i, j);
            }
        }
    }

    private boolean willSurviveToNextGeneration(boolean[][] gameboardCopy, int i, int j) {
        int numberOfNeighbours = countLiveNeighbours(gameboardCopy, i, j);
            return gameModificationSettings.willSurvive(gameboardCopy[i][j],numberOfNeighbours);
    }

    private boolean[][] copyGameboard() {
        boolean[][] gameboardCopy = new boolean[gameboard.length][gameboard[0].length];
        for (int i = 0; i < gameboard.length; i++) {
            System.arraycopy(gameboard[i], 0, gameboardCopy[i], 0, gameboard[i].length);
        }
        return gameboardCopy;
    }

    private int countLiveNeighbours(boolean[][] gameboardCopy, int i, int j) {
        int counter = 0;
        if (gameboardCopy[i][j - 1]) {
            counter++;
        }
        if (gameboardCopy[i][j + 1]) {
            counter++;
        }
        if (gameboardCopy[i - 1][j]) {
            counter++;
        }
        if (gameboardCopy[i - 1][j - 1]) {
            counter++;
        }
        if (gameboardCopy[i - 1][j + 1]) {
            counter++;
        }
        if (gameboardCopy[i + 1][j]) {
            counter++;
        }
        if (gameboardCopy[i + 1][j - 1]) {
            counter++;
        }
        if (gameboardCopy[i + 1][j + 1]) {
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = BOARD_PADDING; i < gameboard.length - BOARD_PADDING; i++) {
            boolean[] row = gameboard[i];
            for (int j = BOARD_PADDING; j < row.length - BOARD_PADDING; j++) {
                boolean cell = row[j];
                stringBuilder.append(cell ? "0" : ".").append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
