package Shop;

import main.Game;
import main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Upgrades extends JPanel {
    private Game game;
    private GamePanel gamePanel;
    private int[] purchases = {0, 0, 0, 0, 0, 0};
    private double[] amounts = {0.25, 0.3, 0.4};

    public Upgrades(Game game, GamePanel gamePanel) {
        this.game = game;
        this.gamePanel = gamePanel;
        Dimension size = new Dimension(64, 192);
        setPreferredSize(size);
        setBackground(Color.lightGray);
        setLocation(gamePanel.getWidth() - 64, 35);
        gamePanel.add(this);
        setVisible(false);
    }

    public void checkMilestone(int which) {
        purchases[which] += 1;
        switch (purchases[which]) {
            case 5:
                createUpgrade(which, 1);
                break;
            case 10:
                createUpgrade(which, 2);
                break;
            case 15:
                createUpgrade(which, 3);
                break;
            case 20:
                createUpgrade(which, 4);
                break;
        }
    }

    private void createUpgrade(int which, int milestone) {
        int calc_prize = (which + 1) * (int)(Math.pow(10, milestone));
        Upgrade upgrade = new Upgrade(amounts[which], which, calc_prize, this);
    }

    public GamePanel getGamePanel(){
        return gamePanel;
    }
}
