package game_of_life;

public class GameboardResolutionSettings {

    private int screenResolutionX;
    private int screenResolutionY;
    private int cellResolution;

    GameboardResolutionSettings(int screenResolutionX, int screenResolutionY, int cellResolution) {
        this.screenResolutionX = screenResolutionX;
        this.screenResolutionY = screenResolutionY;
        this.cellResolution = cellResolution;
    }

    public int getScreenResolutionX() {
        return screenResolutionX;
    }

    public void setScreenResolutionX(int screenResolutionX) {
        this.screenResolutionX = screenResolutionX;
    }

    public int getScreenResolutionY() {
        return screenResolutionY;
    }

    public void setScreenResolutionY(int screenResolutionY) {
        this.screenResolutionY = screenResolutionY;
    }

    public int getCellResolution() {
        return cellResolution;
    }

    public void setCellResolution(int cellResolution) {
        this.cellResolution = cellResolution;
    }
}
