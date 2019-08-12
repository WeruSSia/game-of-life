package game_of_life;

import java.util.HashSet;
import java.util.Set;

public class GameVariationSettings {

    private Set<Integer> bFactors;
    private Set<Integer> sFactors;

    public GameVariationSettings() throws Exception {
        this("B23/S3");
    }

    public GameVariationSettings(String gameVariationCode) throws Exception {
        if (!gameVariationCode.matches("B[0-8]*[/]S[0-8]*")) {
            throw new Exception("Incorrect code.");
        }
        this.bFactors = getFactors(gameVariationCode.split("/")[0]);
        this.sFactors = getFactors(gameVariationCode.split("/")[1]);
    }

    private Set<Integer> getFactors(String sideOfVariationCode) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 1; i < sideOfVariationCode.length(); i++) {
            factors.add(Character.getNumericValue(sideOfVariationCode.charAt(i)));
        }
        return factors;
    }

    boolean willSurvive(boolean cell, int numberOfNeighbours) {
        if (cell) {
            return bFactors.contains(numberOfNeighbours);
        } else {
            return sFactors.contains(numberOfNeighbours);
        }
    }
}
