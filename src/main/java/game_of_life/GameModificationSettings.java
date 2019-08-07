package game_of_life;

import java.util.HashSet;
import java.util.Set;

public class GameModificationSettings {

    private String gameModificationCode;
    private Set<Integer> bFactors;
    private Set<Integer> sFactors;

    public GameModificationSettings() {
        this.gameModificationCode = "23/3";
        this.bFactors = getBFactors();
        this.sFactors = getSFactors();
    }

    public GameModificationSettings(String gameModificationCode) {
        this.gameModificationCode = gameModificationCode;
        this.bFactors = getBFactors();
        this.sFactors = getSFactors();
    }

    private int getIndexOfSlash() {
        for (int i = 0; i < gameModificationCode.length(); i++) {
            if (gameModificationCode.charAt(i) == '/') {
                return i;
            }
        }
        return 0;
    }

    private Set<Integer> getBFactors() {
        Set<Integer> bFactors = new HashSet<>();
        for (int i = 0; i < getIndexOfSlash(); i++) {
            bFactors.add(Character.getNumericValue(gameModificationCode.charAt(i)));
        }
        return bFactors;
    }

    private Set<Integer> getSFactors() {
        Set<Integer> sFactors = new HashSet<>();
        for (int i = getIndexOfSlash() + 1; i < gameModificationCode.length(); i++) {
            sFactors.add(Character.getNumericValue(gameModificationCode.charAt(i)));
        }
        return sFactors;
    }

    boolean willSurvive(boolean cell, int numberOfNeighbours) {
        if (cell) {
            return bFactors.contains(numberOfNeighbours);
        } else {
            return sFactors.contains(numberOfNeighbours);
        }
    }
}
