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
        PatternDrawer patternDrawer = new PatternDrawer(gameboard, positionX, positionY);
        switch (pattern) {
            case BLINKER:
                patternDrawer.drawBlinker();
                break;
            case TOAD:
                patternDrawer.drawToad();
                break;
            case BEACON:
                patternDrawer.drawBeacon();
                break;
            case PULSAR:
                patternDrawer.drawPulsar();
                break;
            case PENTADECATHLON:
                patternDrawer.drawPentadecathlon();
                break;
            case GLIDER:
                patternDrawer.drawGlider();
                break;
            case LIGHTWEIGHT_SPACESHIP:
                patternDrawer.drawLightweightSpaceship();
                break;
            case MIDDLEWEIGHT_SPACESHIP:
                patternDrawer.drawMiddleweightSpaceship();
                break;
            case HEAVYWEIGHT_SPACESHIP:
                patternDrawer.drawHeavyWeightSpaceship();
                break;
        }
    }
}
