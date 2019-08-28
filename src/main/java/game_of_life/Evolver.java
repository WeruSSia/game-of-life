package game_of_life;

import java.util.TimerTask;

class Evolver extends TimerTask {

    private GameSettings gameSettings;
    private boolean[][] gameboard;

    Evolver(GameSettings gameSettings, boolean[][] gameboard) {
        this.gameSettings = gameSettings;
        this.gameboard = gameboard;
    }

    @Override
    public void run() {
        System.out.println(toString());
        evolve();
    }

    private void evolve() {
        boolean[][] gameboardCopy = getGameboardCopy();
        for (int i = 1; i < gameboard.length - 1; i++) {
            for (int j = 1; j < gameboard[i].length - 1; j++) {
                gameboard[i][j] = willSurviveToNextGeneration(gameboardCopy, i, j);
            }
        }
    }

    private boolean[][] getGameboardCopy() {
        boolean[][] gameboardCopy = new boolean[gameboard.length][gameboard[0].length];
        for (int i = 0; i < gameboard.length; i++) {
            System.arraycopy(gameboard[i], 0, gameboardCopy[i], 0, gameboard[i].length);
        }
        return gameboardCopy;
    }

    private boolean willSurviveToNextGeneration(boolean[][] gameboardCopy, int i, int j) {
        int numberOfNeighbours = countLiveNeighbours(gameboardCopy, i, j);
        return gameSettings.willSurvive(gameboardCopy[i][j], numberOfNeighbours);
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
        for (int i = GameOfLife.BOARD_PADDING; i < gameboard.length - GameOfLife.BOARD_PADDING; i++) {
            boolean[] row = gameboard[i];
            for (int j = GameOfLife.BOARD_PADDING; j < row.length - GameOfLife.BOARD_PADDING; j++) {
                boolean cell = row[j];
                stringBuilder.append(cell ? "0" : ".").append("  ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
