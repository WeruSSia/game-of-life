import game_of_life.GameOfLife;
import game_of_life.GameSettings;

public class Main {
    public static void main(String[] args) throws Exception {

        GameSettings gameSettings = new GameSettings();
        new GameOfLife(gameSettings).play();
    }
}
