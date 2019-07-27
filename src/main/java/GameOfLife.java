import java.util.Random;

public class GameOfLife {

    private boolean[][] gameboard;
    private final int BOARD_PADDING = 10;

    public void play(int screenResolutionX, int screenResolutionY, int cellResolution) {
        generateGameboard(screenResolutionX, screenResolutionY, cellResolution);
        populateGameboardWithCells(50);
        System.out.println(toString());
        evolve();
        System.out.println(toString());
    }

    private void generateGameboard(int screenResolutionX, int screenResolutionY, int pixelResolution) {
        gameboard = new boolean[(countLogicResolution(screenResolutionX, pixelResolution)) + BOARD_PADDING][(countLogicResolution(screenResolutionY, pixelResolution)) + BOARD_PADDING];
    }

    private int countLogicResolution(int screenDimension, int pixelResolution) {
        return screenDimension / pixelResolution;
    }

    private void populateGameboardWithCells(int percentOfTheBoard) {
        Random random = new Random();
        for (boolean[] row : gameboard) {
            for (int i = 0; i < row.length; i++) {
                int number = random.nextInt(gameboard.length);
                if (number % (100 / percentOfTheBoard) == 0) {
                    row[i] = true;
                } else {
                    row[i] = false;
                }
            }
        }
    }

    private void evolve() {
        boolean[][] gameboardCopy = copyGameboard();
        for (int i = 1; i < gameboard.length - 1; i++) {
            for (int j = 1; j < gameboard[i].length - 1; j++) {
                int numberOfNeighbours = countLiveNeighbours(gameboardCopy, i, j);
                if (gameboardCopy[i][j]) {
                    if (numberOfNeighbours < 2) {
                        gameboard[i][j] = false;
                    } else if (numberOfNeighbours == 2 || numberOfNeighbours == 3) {
                        gameboard[i][j] = true;
                    } else {
                        gameboard[i][j] = false;
                    }
                } else {
                    if (numberOfNeighbours == 3) {
                        gameboard[i][j] = true;
                    }
                }
            }
        }
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
        for (boolean[] row : gameboard) {
            for (boolean cell : row) {
                stringBuilder.append(cell ? "1" : "0").append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
