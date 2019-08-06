package game_of_life;

import java.util.HashSet;
import java.util.Set;

public class GameModificationSettings {

    private String gameModificationCode;

    public GameModificationSettings() {
        this.gameModificationCode = "23/3";
    }

    public GameModificationSettings(String gameModificationCode) {
        this.gameModificationCode = gameModificationCode;
    }

    private int getIndexOfSlash() {
        for (int i = 0; i < gameModificationCode.length(); i++) {
            if (gameModificationCode.charAt(i) == '/') {
                return i;
            }
        }
        return 0;
    }

    public Set<Character> getAmountOfCellsInOrderForLiveCellToLive() {
        Set<Character> amountOfCellsInOrderForLiveCellToLive = new HashSet<>();
        for (int i = 0; i < getIndexOfSlash(); i++) {
            amountOfCellsInOrderForLiveCellToLive.add(gameModificationCode.charAt(i));
        }
        return amountOfCellsInOrderForLiveCellToLive;
    }

    public Set<Character> getAmountOfCellsInOrderForDeadCellsToLive() {
        Set<Character> amountOfCellsInOrderForDeadCellToLive = new HashSet<>();
        for (int i = getIndexOfSlash()+1; i < gameModificationCode.length(); i++) {
            amountOfCellsInOrderForDeadCellToLive.add(gameModificationCode.charAt(i));
        }
        return amountOfCellsInOrderForDeadCellToLive;
    }
}
