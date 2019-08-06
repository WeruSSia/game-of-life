package game_of_life;

public class GameboardResolutionSettings {

    private int width;
    private int height;
    private int cellResolution;
    private int logicWidth;
    private int logicHeight;

    GameboardResolutionSettings(int width, int height, int cellResolution) {
        this.width = width;
        this.height = height;
        this.cellResolution = cellResolution;
        this.logicWidth = width / cellResolution;
        this.logicHeight = height / cellResolution;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCellResolution() {
        return cellResolution;
    }

    public int getLogicWidth() {
        return logicWidth;
    }

    public int getLogicHeight() {
        return logicHeight;
    }
}
