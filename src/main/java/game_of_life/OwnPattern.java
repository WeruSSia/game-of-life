package game_of_life;

import game_of_life.Position;

import java.util.Set;

public class OwnPattern {

    private boolean[][] pattern;
    private Set<Position> positions;

    public OwnPattern(boolean[][] pattern, Set<Position> positions) throws Exception {
        if(pattern==null){
            throw new Exception("There is no own pattern!");
        }
        if(positions.isEmpty()){
            throw new Exception("Positions set is empty!");
        }
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
