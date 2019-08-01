import java.util.Set;

public class GameboardFillingSettings {

    private int percentageOfTheBoard;
    private Set<FillPattern> patterns;

    GameboardFillingSettings(int percentageOfTheBoard) {
        this.percentageOfTheBoard = percentageOfTheBoard;
    }

    GameboardFillingSettings(Set<FillPattern> patterns) {
        this.patterns = patterns;
    }

    public int getPercentageOfTheBoard() {
        return percentageOfTheBoard;
    }

    public void setPercentageOfTheBoard(int percentageOfTheBoard) {
        this.percentageOfTheBoard = percentageOfTheBoard;
    }

    public Set<FillPattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<FillPattern> patterns) {
        this.patterns = patterns;
    }
}
