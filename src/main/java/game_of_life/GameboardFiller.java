package game_of_life;

import java.util.Random;
import java.util.Set;

class GameboardFiller {

    private boolean[][] gameboard;
    private GameboardFillingSettings gameboardFillingSettings;

    GameboardFiller(boolean[][] gameboard, GameboardFillingSettings gameboardFillingSettings) {
        this.gameboard = gameboard;
        this.gameboardFillingSettings = gameboardFillingSettings;
    }

    void fill() {
        if (gameboardFillingSettings.getPercentageOfRandomFilling() != null) {
            fillRandomly(gameboardFillingSettings.getPercentageOfRandomFilling());
        } else {
            fillWithSetOfPatterns(gameboardFillingSettings.getPatternsOnPositions());
        }
    }

    private void fillRandomly(int percentageOfRandomFilling) {
        Random random = new Random();
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (random.nextInt(100) < percentageOfRandomFilling) {
                    gameboard[i][j] = true;
                }
            }
        }
    }

    private void fillWithSetOfPatterns(Set<PatternOnPosition> patternsOnPositions) {
        for (PatternOnPosition patternOnPosition : patternsOnPositions) {
            drawPattern(patternOnPosition.getPattern(), patternOnPosition.getPositionX(), patternOnPosition.getPositionY());
        }
    }

    private void drawPattern(Pattern pattern, int positionX, int positionY) {
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
