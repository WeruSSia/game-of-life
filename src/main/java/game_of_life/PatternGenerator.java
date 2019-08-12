package game_of_life;

import java.util.Arrays;

class PatternGenerator {

    PatternGenerator() {
    }

    private boolean[][] getBlinkerAsArray() {
        boolean[][] blinker = new boolean[1][3];
        Arrays.fill(blinker[0], true);
        return blinker;
    }

    private boolean[][] getToadAsArray() {
        boolean[][] toad = new boolean[2][4];
        Arrays.fill(toad[0], 1, 4, true);
        Arrays.fill(toad[1], 0, 3, true);
        return toad;
    }

    private boolean[][] getBeaconAsArray() {
        boolean[][] beacon = new boolean[4][4];
        Arrays.fill(beacon[0], 0, 2, true);
        Arrays.fill(beacon[3], 2, 4, true);
        beacon[1][0] = true;
        beacon[2][3] = true;
        return beacon;
    }

    private boolean[][] getPulsarAsArray() {
        boolean[][] pulsar = new boolean[13][13];
        for (int i = 2; i < 5; i++) {
            pulsar[0][i] = true;
            pulsar[5][i] = true;
            pulsar[7][i] = true;
            pulsar[12][i] = true;
        }
        for (int i = 8; i < 11; i++) {
            pulsar[0][i] = true;
            pulsar[5][i] = true;
            pulsar[7][i] = true;
            pulsar[12][i] = true;
        }
        for (int i = 2; i < 5; i++) {
            pulsar[i][0] = true;
            pulsar[i][5] = true;
            pulsar[i][7] = true;
            pulsar[i][12] = true;
        }
        for (int i = 8; i < 11; i++) {
            pulsar[i][0] = true;
            pulsar[i][5] = true;
            pulsar[i][7] = true;
            pulsar[i][12] = true;
        }
        return pulsar;
    }

    private boolean[][] getPentadecathlonAsArray() {
        boolean[][] pentadecathlon = new boolean[3][8];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                pentadecathlon[i][j] = true;
            }
        }
        pentadecathlon[1][1] = false;
        pentadecathlon[1][6] = false;
        return pentadecathlon;
    }

    private boolean[][] getGliderAsArray() {
        boolean[][] glider = new boolean[3][3];
        glider[0][1] = true;
        glider[1][2] = true;
        Arrays.fill(glider[2], true);
        return glider;
    }

    private boolean[][] getLightweightSpaceshipAsArray() {
        boolean[][] lightweightSpaceship = new boolean[4][5];
        Arrays.fill(lightweightSpaceship[0], 1, 3, true);
        Arrays.fill(lightweightSpaceship[1], 0, 4, true);
        Arrays.fill(lightweightSpaceship[2], true);
        Arrays.fill(lightweightSpaceship[3], 2, 4, true);
        lightweightSpaceship[2][2] = false;
        return lightweightSpaceship;
    }

    private boolean[][] getMiddleweightSpaceshipAsArray() {
        boolean[][] middleweightSpaceship = new boolean[4][6];
        Arrays.fill(middleweightSpaceship[0], 1, 4, true);
        Arrays.fill(middleweightSpaceship[1], 0, 5, true);
        Arrays.fill(middleweightSpaceship[2], 0, 6, true);
        Arrays.fill(middleweightSpaceship[3], 3, 5, true);
        middleweightSpaceship[2][3] = false;
        return middleweightSpaceship;
    }

    private boolean[][] getHeavyweightSpaceshipAsArray() {
        boolean[][] heavyweightSpaceship = new boolean[4][7];
        Arrays.fill(heavyweightSpaceship[0], 1, 5, true);
        Arrays.fill(heavyweightSpaceship[1], 0, 6, true);
        Arrays.fill(heavyweightSpaceship[2], 0, 7, true);
        Arrays.fill(heavyweightSpaceship[3], 4, 6, true);
        heavyweightSpaceship[2][4] = false;
        return heavyweightSpaceship;
    }

    boolean[][] getPatternAsArray(Pattern pattern) {
        switch (pattern) {
            case BLINKER:
                return getBlinkerAsArray();
            case TOAD:
                return getToadAsArray();
            case BEACON:
                return getBeaconAsArray();
            case PULSAR:
                return getPulsarAsArray();
            case PENTADECATHLON:
                return getPentadecathlonAsArray();
            case GLIDER:
                return getGliderAsArray();
            case LIGHTWEIGHT_SPACESHIP:
                return getLightweightSpaceshipAsArray();
            case MIDDLEWEIGHT_SPACESHIP:
                return getMiddleweightSpaceshipAsArray();
            case HEAVYWEIGHT_SPACESHIP:
                return getHeavyweightSpaceshipAsArray();
        }
        return null;
    }
}
