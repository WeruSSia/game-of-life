package game_of_life;

public class Position {

    private int positionX;
    private int positionY;

    public Position(int positionX, int positionY) {
        this.positionX = positionX + GameOfLife.BOARD_PADDING;
        this.positionY = positionY + GameOfLife.BOARD_PADDING;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    //todo public getters without padding, private getters with padding
}
