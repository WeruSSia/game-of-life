package game_of_life;

class PatternDrawer {

    private boolean[][] gameboard;
    private int positionX;
    private int positionY;

    PatternDrawer(boolean[][] gameboard, Position position) {
        this.gameboard = gameboard;
        this.positionX = position.getPositionX();
        this.positionY = position.getPositionY();
    }

    void drawBlinker() {
        for (int j = positionX; j < positionX + 3; j++) {
            gameboard[positionY][j] = true;
        }
    }

    void drawToad() {
        for (int j = positionX + 1; j < positionX + 4; j++) {
            gameboard[positionY][j] = true;
        }
        for (int j = positionX; j < positionX + 3; j++) {
            gameboard[positionY + 1][j] = true;
        }
    }

    void drawBeacon() {
        for (int i = positionY; i < positionY + 2; i++) {
            for (int j = positionX; j < positionX + 2; j++) {
                gameboard[i][j] = true;
            }
        }
        for (int i = positionY + 2; i < positionY + 4; i++) {
            for (int j = positionX + 2; j < positionX + 4; j++) {
                gameboard[i][j] = true;
            }
        }
    }

    void drawPulsar() {
        for (int j = positionX + 2; j < positionX + 5; j++) {
            gameboard[positionY][j] = true;
        }
        for (int k = positionX + 8; k < positionX + 11; k++) {
            gameboard[positionY][k] = true;
        }
        for (int i = positionY + 2; i < positionY + 5; i++) {
            gameboard[i][positionX] = true;
            gameboard[i][positionX + 5] = true;
            gameboard[i][positionX + 7] = true;
            gameboard[i][positionX + 12] = true;
        }
        for (int j = positionX + 2; j < positionX + 5; j++) {
            gameboard[positionY + 5][j] = true;
        }
        for (int j = positionX + 8; j < positionX + 11; j++) {
            gameboard[positionY + 5][j] = true;
        }
        for (int j = positionX + 2; j < positionX + 5; j++) {
            gameboard[positionY + 7][j] = true;
        }
        for (int j = positionX + 8; j < positionX + 11; j++) {
            gameboard[positionY + 7][j] = true;
        }
        for (int i = positionY + 8; i < positionY + 11; i++) {
            gameboard[i][positionX] = true;
            gameboard[i][positionX + 5] = true;
            gameboard[i][positionX + 7] = true;
            gameboard[i][positionX + 12] = true;
        }
        for (int j = positionX + 2; j < positionX + 5; j++) {
            gameboard[positionY + 12][j] = true;
        }
        for (int j = positionX + 8; j < positionX + 11; j++) {
            gameboard[positionY + 12][j] = true;
        }
    }

    void drawPentadecathlon() {
        for (int i = positionY; i < positionY + 3; i++) {
            for (int j = positionX; j < positionX + 8; j++) {
                gameboard[i][j] = true;
            }
        }
        gameboard[positionY + 1][positionX + 1] = false;
        gameboard[positionY + 1][positionX + 6] = false;
    }

    void drawGlider() {
        gameboard[positionY][positionX + 1] = true;
        gameboard[positionY + 1][positionX + 2] = true;
        for (int j = positionX; j < positionX + 3; j++) {
            gameboard[positionY + 2][j] = true;
        }
    }

    void drawLightweightSpaceship() {
        for (int j = positionX + 1; j < positionX + 3; j++) {
            gameboard[positionY][j] = true;
        }
        for (int j = positionX; j < positionX + 4; j++) {
            gameboard[positionY + 1][j] = true;
        }
        for (int j = positionX; j < positionX + 5; j++) {
            gameboard[positionY + 2][j] = true;
        }
        for (int j = positionX + 2; j < positionX + 4; j++) {
            gameboard[positionY + 3][j] = true;
        }
        gameboard[positionY + 2][positionX + 2] = false;
    }

    void drawMiddleweightSpaceship() {
        for (int j = positionX + 1; j < positionX + 4; j++) {
            gameboard[positionY][j] = true;
        }
        for (int j = positionX; j < positionX + 5; j++) {
            gameboard[positionY + 1][j] = true;
        }
        for (int j = positionX; j < positionX + 6; j++) {
            gameboard[positionY + 2][j] = true;
        }
        for (int j = positionX + 3; j < positionX + 5; j++) {
            gameboard[positionY + 3][j] = true;
        }
        gameboard[positionY + 2][positionX + 3] = false;
    }

    void drawHeavyWeightSpaceship() {
        for (int j = positionX + 1; j < positionX + 5; j++) {
            gameboard[positionY][j] = true;
        }
        for (int j = positionX; j < positionX + 6; j++) {
            gameboard[positionY + 1][j] = true;
        }
        for (int j = positionX; j < positionX + 7; j++) {
            gameboard[positionY + 2][j] = true;
        }
        for (int j = positionX + 4; j < positionX + 6; j++) {
            gameboard[positionY + 3][j] = true;
        }
        gameboard[positionY + 2][positionX + 4] = false;
    }

    void drawOwnPattern(boolean[][] ownPattern) {
        for (int i = positionY; i < positionY + ownPattern.length; i++) {
            for (int j = positionX; j < positionX + ownPattern[0].length; j++) {
                gameboard[i][j] = ownPattern[i-positionY][j-positionX];
            }
        }
    }
}
