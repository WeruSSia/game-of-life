package game_of_life;

import java.util.Set;

public class GameboardFillingSettings {

    private Integer percentageOfRandomFilling;
    private Set<PatternOnPosition> patternsOnPositions;

    GameboardFillingSettings(Integer percentageOfRandomFilling) {
        this.percentageOfRandomFilling = percentageOfRandomFilling;
    }

    GameboardFillingSettings(Set<PatternOnPosition> patternsOnPositions) {
        this.patternsOnPositions = patternsOnPositions;
    }

    public Integer getPercentageOfRandomFilling() {
        return percentageOfRandomFilling;
    }

    public Set<PatternOnPosition> getPatternsOnPositions() {
        return patternsOnPositions;
    }
}
