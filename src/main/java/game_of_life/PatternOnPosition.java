package game_of_life;

import java.util.Objects;

public class PatternOnPosition {

    private boolean[][] pattern;
    private Position position;

    public PatternOnPosition(Pattern pattern, Position position) {
        this.pattern = new PatternDrawer().getPatternAsArray(pattern);
        this.position = position;
    }

    public PatternOnPosition(boolean[][] ownPattern, Position position) {
        this.pattern = ownPattern;
        this.position = position;
    }

    public boolean[][] getPattern() {
        return pattern;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatternOnPosition that = (PatternOnPosition) o;
        return pattern == that.pattern &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern, position);
    }
}
