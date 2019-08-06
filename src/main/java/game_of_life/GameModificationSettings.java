package game_of_life;

import java.util.Set;

public class GameModificationSettings {

    private String gameModificationCode;
    private Set<Character> amountOfCellsInOrderForLiveCellToLive;
    private Set<Character> amountOfCellsInOrderForDeadCellToLive;

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

    public void getAmountOfCellsInOrderForLiveCellToLive() {
        for (int i = 0; i < getIndexOfSlash(); i++) {
            amountOfCellsInOrderForLiveCellToLive.add(gameModificationCode.charAt(i));
        }
    }

    public void getAmountOfCellsInOrderForDeadCellsToLive() {
        for (int i = getIndexOfSlash(); i < gameModificationCode.length(); i++) {
            amountOfCellsInOrderForDeadCellToLive.add(gameModificationCode.charAt(i));
        }
    }
}
