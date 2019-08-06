import java.util.Set;

public class GameboardFillingSettings {

    private int percentageOfTheBoard;
    private Set<Pattern> patterns;

    GameboardFillingSettings(int percentageOfTheBoard) {
        this.percentageOfTheBoard = percentageOfTheBoard;
    }

    GameboardFillingSettings(Set<Pattern> patterns) {
        this.patterns = patterns;
    }

    public int getPercentageOfTheBoard() {
        return percentageOfTheBoard;
    }

    public void setPercentageOfTheBoard(int percentageOfTheBoard) {
        this.percentageOfTheBoard = percentageOfTheBoard;
    }

    public Set<Pattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<Pattern> patterns) {
        this.patterns = patterns;
    }
}
