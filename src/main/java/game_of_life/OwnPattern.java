package game_of_life;

import java.util.Set;

public class OwnPattern {

    private boolean[][] pattern;
    private Set<Position> positions;

    public OwnPattern(boolean[][] pattern, Set<Position> positions) {
        this.pattern = pattern;
        this.positions = positions;
    }

    public boolean[][] getPattern() {
        return pattern;
    }

    public Set<Position> getPositions() {
        return positions;
    }
}
