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
            boolean[][] pattern = patternOnPosition.getPattern();
            int positionX = patternOnPosition.getPosition().getPositionXWithPadding();
            int positionY = patternOnPosition.getPosition().getPositionYWithPadding();
            try {
                for (int i = positionY; i < positionY + pattern.length; i++) {
                    System.arraycopy(pattern[i - positionY], 0, gameboard[i], positionX, positionX + pattern[0].length - positionX);
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("The position is out of gameboard bounds!");
                return;
            }

        }
    }
}
