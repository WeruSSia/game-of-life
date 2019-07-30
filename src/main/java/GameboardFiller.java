import java.util.Random;

class GameboardFiller {

    private boolean[][] gameboard;

    public GameboardFiller(boolean[][] gameboard) {
        this.gameboard = gameboard;
    }

    void fillRandomly(int percentage) {
        Random random = new Random();
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (random.nextInt(100) < percentage) {
                    gameboard[i][j] = true;
                }
            }
        }
    }

    void fillUsingPattern(FillPattern pattern, int positionX, int positionY) {
        PatternDrawer patternDrawer = new PatternDrawer(positionX, positionY);
        switch (pattern) {
            case BLINKER:
                break;
            case TOAD:
                break;
            case BEACON:
                break;
            case PULSAR:
                break;
            case PENTADECATHLON:
                break;
            case GLIDER:
                break;
            case LIGHTWEIGHT_SPACESHIP:
                break;
            case MIDDLEWEIGHT_SPACESHIP:
                break;
            case HEAVYWEIGHT_SPACESHIP:
                break;
        }
    }
}
