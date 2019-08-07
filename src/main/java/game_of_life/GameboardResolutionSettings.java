package game_of_life;

public class GameboardResolutionSettings {

    private int width;
    private int height;
    private int cellResolution;
    private int logicWidth;
    private int logicHeight;

    public GameboardResolutionSettings(int width, int height, int cellResolution) throws Exception {
        if (width <= 0 || height <= 0 || cellResolution <= 0) {
            throw new Exception("Value must be greater than 0!");
        }
        this.width = width;
        this.height = height;
        this.cellResolution = cellResolution;
        this.logicWidth = width / cellResolution;
        this.logicHeight = height / cellResolution;
    }

    public int getLogicWidth() {
        return logicWidth;
    }

    public int getLogicHeight() {
        return logicHeight;
    }
}
