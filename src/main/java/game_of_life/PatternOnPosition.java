package game_of_life;

import java.util.Objects;

public class PatternOnPosition {

    private Pattern pattern;
    private int positionX;
    private int positionY;

    public PatternOnPosition(Pattern pattern, int positionX, int positionY) {
        this.pattern = pattern;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatternOnPosition that = (PatternOnPosition) o;
        return positionX == that.positionX &&
                positionY == that.positionY &&
                pattern == that.pattern;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern, positionX, positionY);
    }
}
