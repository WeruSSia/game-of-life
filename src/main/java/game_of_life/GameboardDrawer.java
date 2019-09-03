package game_of_life;

import javax.swing.*;
import java.awt.*;

class GameboardDrawer extends JPanel {

    private boolean[][] gameboard;
    private GameSettings gameSettings;
    private JFrame jFrame = new JFrame();

    GameboardDrawer(boolean[][] gameboard, GameSettings gameSettings) {
        this.gameboard = gameboard;
        this.gameSettings = gameSettings;
    }

    void prepareFrame() {
        GameboardDrawer drawer = new GameboardDrawer(gameboard, gameSettings);
        jFrame.setSize(gameSettings.getGameboardWidth(), gameSettings.getGameboardHeight());
        jFrame.getContentPane().add(drawer);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
    }

    void repaintGameboard() {
        jFrame.revalidate();
        jFrame.repaint();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setPaint(Color.RED);
        for (int i = GameOfLife.BOARD_PADDING; i < gameboard.length - GameOfLife.BOARD_PADDING; i++) {
            for (int j = GameOfLife.BOARD_PADDING; j < gameboard[i].length - GameOfLife.BOARD_PADDING; j++) {
                if (gameboard[i][j]) {
                    graphics2D.fillRect((j - GameOfLife.BOARD_PADDING) * gameSettings.getCellResolution(), (i - GameOfLife.BOARD_PADDING) * gameSettings.getCellResolution(), gameSettings.getCellResolution(), gameSettings.getCellResolution());
                }
            }
        }
    }
}
