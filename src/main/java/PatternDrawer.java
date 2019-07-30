class PatternDrawer {

    private boolean[][] gameboard;
    private int positionX;
    private int positionY;

    PatternDrawer(boolean[][] gameboard, int positionX, int positionY) {
        this.gameboard = gameboard;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    void drawBlinker() {
        for (int i = positionY; i < positionY + 1; i++) {
            for (int j = positionX; j < positionX + 3; j++) {
                gameboard[i][j] = true;
            }
        }
    }

    void drawToad() {
        for (int i = positionY; i < positionY + 1; i++) {
            for (int j = positionX + 1; j < positionX + 4; j++) {
                gameboard[i][j] = true;
            }
        }
        for (int i = positionY + 1; i < positionY + 2; i++) {
            for (int j = positionX; j < positionX + 3; j++) {
                gameboard[i][j] = true;
            }
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
        for (int i = positionY; i < positionY + 1; i++) {
            for (int j = positionX + 2; j < positionX + 5; j++) {
                gameboard[i][j] = true;
            }
            for (int k = positionX + 8; k < positionX + 11; k++) {
                gameboard[i][k] = true;
            }
        }
        for (int i = positionY + 2; i < positionY + 5; i++) {
            for (int j = positionX; j < positionX + 1; j++) {
                gameboard[i][j] = true;
            }
            for (int j = positionX + 5; j < positionX + 6; j++) {
                gameboard[i][j] = true;
            }
            for (int j = positionX + 7; j < positionX + 8; j++) {
                gameboard[i][j] = true;
            }
            for (int j = positionX + 12; j < positionX + 13; j++) {
                gameboard[i][j] = true;
            }
        }
        for (int i = positionY + 5; i < positionY + 6; i++) {
            for (int j = positionX + 2; j < positionX + 5; j++) {
                gameboard[i][j] = true;
            }
            for (int j = positionX + 8; j < positionX + 11; j++) {
                gameboard[i][j] = true;
            }
        }
        for (int i = positionY + 7; i < positionY + 8; i++) {
            for (int j = positionX + 2; j < positionX + 5; j++) {
                gameboard[i][j] = true;
            }
            for (int j = positionX + 8; j < positionX + 11; j++) {
                gameboard[i][j] = true;
            }
        }
        for (int i = positionY + 8; i < positionY + 11; i++) {
            for (int j = positionX; j < positionX + 1; j++) {
                gameboard[i][j] = true;
            }
            for (int j = positionX + 5; j < positionX + 6; j++) {
                gameboard[i][j] = true;
            }
            for (int j = positionX + 7; j < positionX + 8; j++) {
                gameboard[i][j] = true;
            }
            for (int j = positionX + 12; j < positionX + 13; j++) {
                gameboard[i][j] = true;
            }
        }
        for (int i = positionY + 12; i < positionY + 13; i++) {
            for (int j = positionX + 2; j < positionX + 5; j++) {
                gameboard[i][j] = true;
            }
            for (int j = positionX + 8; j < positionX + 11; j++) {
                gameboard[i][j] = true;
            }
        }
    }

    void drawPentadecathlon() {
        for (int i = positionY; i < positionY + 3; i++) {
            for (int j = positionX; j < positionX + 8; j++) {
                gameboard[i][j] = true;
            }
        }
        gameboard[positionX + 1][positionY + 1] = false;
        gameboard[positionX + 1][positionY + 6] = false;
    }
}
