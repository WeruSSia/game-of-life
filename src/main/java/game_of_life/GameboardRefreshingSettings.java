package game_of_life;

public class GameboardRefreshingSettings {

    private int frequency;

    public GameboardRefreshingSettings(){
        this.frequency = 500;
    }

    public GameboardRefreshingSettings(int frequency){
        this.frequency=frequency;
    }

    int getFrequency(){
        return frequency;
    }
}
