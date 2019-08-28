package game_of_life;

import java.util.Random;
import java.util.Set;

class GameboardFiller {

    private boolean[][] gameboard;
    private GameSettings gameSettings;

    GameboardFiller(boolean[][] gameboard, GameSettings gameSettings) {
        this.gameboard = gameboard;
        this.gameSettings = gameSettings;
    }

    void fill() {
        if (gameSettings.getPercentageOfRandomFilling() != null) {
            fillRandomly(gameSettings.getPercentageOfRandomFilling());
        } else {
            fillWithSetOfPatterns(gameSettings.getPatternsOnPositions());
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

    private boolean isPositionOnGameboard(PatternOnPosition patternOnPosition) {
        boolean[][] pattern = patternOnPosition.getPattern();
        int positionX = patternOnPosition.getPosition().getPositionX();
        int positionY = patternOnPosition.getPosition().getPositionY();
        int padding = 2 * GameOfLife.BOARD_PADDING;
        final boolean exceedsLeftEdge = positionX < 0;
        final boolean exceedsRightEdge = positionX + pattern[0].length > gameboard[0].length - padding;
        final boolean exceedsUpperEdge = positionY < 0;
        final boolean exceedsBottomEdge = positionY + pattern.length > gameboard.length - padding;
        return !exceedsLeftEdge && !exceedsUpperEdge && !exceedsRightEdge && !exceedsBottomEdge;
    }

    private void fillWithSetOfPatterns(Set<PatternOnPosition> patternsOnPositions) {
        for (PatternOnPosition patternOnPosition : patternsOnPositions) {
            boolean[][] pattern = patternOnPosition.getPattern();
            int positionX = patternOnPosition.getPosition().getPositionXWithPadding();
            int positionY = patternOnPosition.getPosition().getPositionYWithPadding();
            if (isPositionOnGameboard(patternOnPosition)) {
                for (int i = positionY; i < positionY + pattern.length; i++) {
                    System.arraycopy(pattern[i - positionY], 0, gameboard[i], positionX, positionX + pattern[0].length - positionX);
                }
            } else {
                System.out.println("One of the patterns couldn't be drawn, because it was out of gameboard!");
            }
        }
    }
}
