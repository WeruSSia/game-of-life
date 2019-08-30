package game_of_life;

import javax.swing.*;
import java.awt.*;

class GameboardDrawer extends JPanel {

    void draw(boolean[][] gameboard, GameSettings gameSettings){
        prepareFrame(gameSettings);
    }

    void prepareFrame(GameSettings gameSettings){
        JFrame jFrame = new JFrame();
        jFrame.setSize(gameSettings.getGameboardWidth(),gameSettings.getGameboardHeight());
        jFrame.getContentPane().add(new GameboardDrawer());
        jFrame.setLocationRelativeTo(null);
        jFrame.setBackground(Color.BLUE);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void paint(Graphics graphics){

    }
}
