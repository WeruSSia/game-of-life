package game_of_life;

import java.util.HashSet;
import java.util.Set;

public class GameModificationSettings {

    private String gameModificationCode;
    private Set<Integer> bFactors;
    private Set<Integer> sFactors;

    public GameModificationSettings() {
        this.gameModificationCode = "23/3";
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

    public Set<Integer> getBFactors() {
        Set<Integer> amountOfCellsInOrderForLiveCellToLive = new HashSet<>();
        for (int i = 0; i < getIndexOfSlash(); i++) {
            amountOfCellsInOrderForLiveCellToLive.add(Character.getNumericValue(gameModificationCode.charAt(i)));
        }
        return amountOfCellsInOrderForLiveCellToLive;
    }

    public Set<Integer> getSFactors() {
        Set<Integer> amountOfCellsInOrderForDeadCellToLive = new HashSet<>();
        for (int i = getIndexOfSlash() + 1; i < gameModificationCode.length(); i++) {
            amountOfCellsInOrderForDeadCellToLive.add(Character.getNumericValue(gameModificationCode.charAt(i)));
        }
        return amountOfCellsInOrderForDeadCellToLive;
    }

    //public boolean survive(boolean alive, int numberOfNeighbours){getBFactors().contains()}
}
