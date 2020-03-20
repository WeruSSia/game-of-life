import game_of_life.*;

public class Main {
    public static void main(String[] args) {

        GameSettings gameSettings = new GameSettings();
        new GameOfLife(gameSettings).play();
    }
}
