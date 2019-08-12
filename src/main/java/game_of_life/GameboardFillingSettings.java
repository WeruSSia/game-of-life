package game_of_life;

import java.util.Set;

public class GameboardFillingSettings {

    private Integer percentageOfRandomFilling;
    private Set<PatternOnPosition> patternsOnPositions;

    public GameboardFillingSettings(int percentageOfRandomFilling) throws Exception {
        if (percentageOfRandomFilling < 0 || percentageOfRandomFilling > 100) {
            throw new Exception("Percentage must be between 0% and 100%");
        }
        this.percentageOfRandomFilling = percentageOfRandomFilling;
    }

    public GameboardFillingSettings(Set<PatternOnPosition> patternsOnPositions) throws Exception {
        if (patternsOnPositions == null) {
            throw new Exception("Patterns set is empty!");
        }
        this.patternsOnPositions = patternsOnPositions;
    }

    public Integer getPercentageOfRandomFilling() {
        return percentageOfRandomFilling;
    }

    public Set<PatternOnPosition> getPatternsOnPositions() {
        return patternsOnPositions;
    }

}
