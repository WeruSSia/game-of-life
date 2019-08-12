package game_of_life;

public class Position {

    //todo "padding" in the names
    private int positionX;
    private int positionY;

    public Position(int positionX, int positionY) {
        this.positionX = positionX + GameOfLife.BOARD_PADDING;
        this.positionY = positionY + GameOfLife.BOARD_PADDING;
    }

    //todo not private
    private int getPositionXWithPadding() {
        return positionX;
    }

    private int getPositionYWithPadding() {
        return positionY;
    }

    public int getPositionX() {
        return positionX - GameOfLife.BOARD_PADDING;
    }

    public int getPositionY() {
        return positionY - GameOfLife.BOARD_PADDING;
    }
}
