package game_of_life;

public class Position {

    private int positionX;
    private int positionY;

    public Position(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    int getPositionXWithPadding() {
        return positionX + GameOfLife.BOARD_PADDING;
    }

    int getPositionYWithPadding() {
        return positionY + GameOfLife.BOARD_PADDING;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
