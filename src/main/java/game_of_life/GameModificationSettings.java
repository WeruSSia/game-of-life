package game_of_life;

import java.util.HashSet;
import java.util.Set;

public class GameModificationSettings {

    private String[] gameModificationCode;
    private Set<Integer> bFactors;
    private Set<Integer> sFactors;

    //todo it should be named "rule"
    public GameModificationSettings() {
        //todo suffices this("23/3");
        this.gameModificationCode = new String[]{"23", "3"};
        this.bFactors = getBFactors(this.gameModificationCode[0]);
        this.sFactors = getSFactors(this.gameModificationCode[1]);
    }

    public GameModificationSettings(String gameModificationCode) throws Exception {
        if (!gameModificationCode.matches("[0-8]*[/][0-8]*")) {
            throw new Exception("Incorrect code.");
        }
        this.gameModificationCode = gameModificationCode.split("/"); //todo can be replaced with own better implementation
        this.bFactors = getBFactors(this.gameModificationCode[0]);
        this.sFactors = getSFactors(this.gameModificationCode[1]);
    }

    //todo redundant method
    private Set<Integer> getBFactors(String leftSide) {
        Set<Integer> bFactors = new HashSet<>();
        for (int i = 0; i < leftSide.length(); i++) {
            bFactors.add(Character.getNumericValue(leftSide.charAt(i)));
        }
        return bFactors;
    }

    private Set<Integer> getSFactors(String rightSide) {
        Set<Integer> sFactors = new HashSet<>();
        for (int i = 0; i < rightSide.length(); i++) {
            sFactors.add(Character.getNumericValue(rightSide.charAt(i)));
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
