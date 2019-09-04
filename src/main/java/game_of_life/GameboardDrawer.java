package game_of_life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

class GameboardDrawer extends JPanel {

    private boolean[][] gameboard;
    private GameSettings gameSettings;
    private JFrame jFrame = new JFrame();

    GameboardDrawer(boolean[][] gameboard, GameSettings gameSettings) {
        this.gameboard = gameboard;
        this.gameSettings = gameSettings;
    }

    void prepareFrame() {
        jFrame.setSize(gameSettings.getGameboardWidth(), gameSettings.getGameboardHeight());
        jFrame.getContentPane().add(new GameboardDrawer(gameboard, gameSettings));
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
        jFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel");
        jFrame.getRootPane().getActionMap().put("Cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
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
