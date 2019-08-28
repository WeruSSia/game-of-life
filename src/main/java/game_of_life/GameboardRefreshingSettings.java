package game_of_life;

public class GameboardRefreshingSettings {

    private int periodInMilliseconds;

    public GameboardRefreshingSettings(){
        this.periodInMilliseconds = 500;
    }

    public GameboardRefreshingSettings(int periodInMilliseconds){
        this.periodInMilliseconds = periodInMilliseconds;
    }

    int getPeriodInMilliseconds(){
        return periodInMilliseconds;
    }
}
