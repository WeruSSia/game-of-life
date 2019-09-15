package game_of_life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

class GameboardDrawer extends JFrame {

    private boolean[][] gameboard;
    private GameSettings gameSettings;

    GameboardDrawer(boolean[][] gameboard, GameSettings gameSettings) {
        this.gameboard = gameboard;
        this.gameSettings = gameSettings;
        setFrame();
    }

    private void setFrame() {
        Panel panel = new Panel();
        panel.setPreferredSize(new Dimension(gameSettings.getGameboardWidth(), gameSettings.getGameboardHeight()));
        getContentPane().add(panel);
        setResizable(false);
        setUndecorated(true);
        pack();
        setVisible(true);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel");
        getRootPane().getActionMap().put("Cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    void repaintGameboard() {
        revalidate();
        repaint();
    }

    private class Panel extends JPanel {
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            setBackground(gameSettings.getBackgroundColor());
            graphics.setColor(gameSettings.getCellColor());
            setLocationRelativeTo(null);
            for (int i = GameOfLife.BOARD_PADDING; i < gameboard.length - GameOfLife.BOARD_PADDING; i++) {
                for (int j = GameOfLife.BOARD_PADDING; j < gameboard[i].length - GameOfLife.BOARD_PADDING; j++) {
                    if (gameboard[i][j]) {
                        graphics.fillRect((j - GameOfLife.BOARD_PADDING) * gameSettings.getCellResolution(), (i - GameOfLife.BOARD_PADDING) * gameSettings.getCellResolution(), gameSettings.getCellResolution(), gameSettings.getCellResolution());
                    }
                }
            }
        }
    }

}
