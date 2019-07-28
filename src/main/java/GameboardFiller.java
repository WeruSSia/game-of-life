import java.util.Random;

class GameboardFiller {

    void fillRandomly(boolean[][] gameboard, int percentage) {
        Random random = new Random();
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (random.nextInt(100) < percentage) {
                    gameboard[i][j] = true;
                }
            }
        }
    }
}
