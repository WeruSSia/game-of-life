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

    private boolean checkIfPositionIsOnGameboard(PatternOnPosition patternOnPosition) {
        boolean[][] pattern = patternOnPosition.getPattern();
        int positionX = patternOnPosition.getPosition().getPositionX();
        int positionY = patternOnPosition.getPosition().getPositionY();
        int padding = 2 * GameOfLife.BOARD_PADDING;
        if (positionX > 0 && positionX < gameboard[0].length - padding && positionY > 0 && positionY < gameboard.length - padding) {
            if (positionX + pattern[0].length < gameboard[0].length - padding && positionY + pattern.length < gameboard.length - padding) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    private void fillWithSetOfPatterns(Set<PatternOnPosition> patternsOnPositions) {
        for (PatternOnPosition patternOnPosition : patternsOnPositions) {
            boolean[][] pattern = patternOnPosition.getPattern();
            int positionX = patternOnPosition.getPosition().getPositionXWithPadding();
            int positionY = patternOnPosition.getPosition().getPositionYWithPadding();
            if (checkIfPositionIsOnGameboard(patternOnPosition)) {
                for (int i = positionY; i < positionY + pattern.length; i++) {
                    System.arraycopy(pattern[i - positionY], 0, gameboard[i], positionX, positionX + pattern[0].length - positionX);
                }
            } else {
                System.out.println("One of the patterns couldn't be drawn, because it was out of gameboard!");
            }
        }
    }
}
