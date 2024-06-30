package Shop;

import Data.Data;
import enteties.EntetiesManager;
import main.Game;
import main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JPanel{
    private Game game;
    private GamePanel gamePanel;
    private Upgrades upgrades;
    private Label label;
    private int[] prices = {10,100,150,0,0,0};
    private int Status = 0;


    public Shop(Game game, GamePanel gamePanel){
        upgrades = new Upgrades(game, gamePanel);
        this.game = game;
        this.gamePanel = gamePanel;
        label = new Label(gamePanel);
        Dimension size = new Dimension(192, 192);
        setPreferredSize(size);
        setBackground(Color.lightGray);
        setLocation(getWidth() - 133, 35);
        setVisible(false);
        createSlaveButton();
    }

    public void setVisibleShop(boolean visibleShop){
        setVisible(visibleShop);
        upgrades.setVisible(visibleShop);
        if (!visibleShop) {
            label.setVisible(visibleShop);
        }
    }
    public void createSlaveButton(){
        JButton button = new JButton();
        button.setBounds(120, 120, 64, 32);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setText("Buy slave for: 10");
        //button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (prices[0] <= Data.money) {
                    calcSlave(0, "Slave", button);
                }
            }
        });
        add(button);
    }
    public void createSuperSlaveButton(){
        JButton button = new JButton();
        button.setBounds(120, 160, 64, 32);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setText("Buy Superslave for: 100");
        //button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (prices[1] <= Data.money) {
                    calcSlave(1, "Superslave", button);
                }
            }
        });
        add(button);
    }
    public void createHugeSlaveButton(){
        JButton button = new JButton();
        button.setBounds(120, 160, 64, 32);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setText("Buy Hugeslave for: 150");
        //button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (prices[2] <= Data.money) {
                    calcSlave(2, "Hugeslave", button);
                }
            }
        });
        add(button);
    }

    private void calcSlave(int which, String text, JButton button){
        upgrades.checkMilestone(which);
        Data.money -= prices[which];
        Data.slaveAmount[which] += 1;
        if (Data.slaveAmount[which] % 100 == 0){
            EntetiesManager.appendSlave(which, gamePanel, (which + 10000));
            removeSlave(1);
        } else if (Data.slaveAmount[which] % 10 == 0) {
            EntetiesManager.removeSlaves(which);
            EntetiesManager.appendSlave(which, gamePanel, (which + 1000));
            removeSlave(0);
        } else {
            EntetiesManager.appendSlave(which, gamePanel, which);
        }
        gamePanel.updateMoneyField();
        prices[which] = (int)(prices[which] * 1.3);
        button.setText("Buy " + text +" for: " + prices[which]);
    }

    private void removeSlave(int which){
        switch (which){
            case 3:
                EntetiesManager.removeSlaves((which + 100000));
            case 2:
                EntetiesManager.removeSlaves((which + 10000));
            case 1:
                EntetiesManager.removeSlaves((which + 1000));
            case 0:
                EntetiesManager.removeSlaves((which));
                break;
        }
    }





    public void updateShop(){
        switch (Status){
            case 0:
                if (Data.maxMoney >= 100){
                   Status = 1;
                    createSuperSlaveButton();
                } else {
                    break;
                }
            case 1:
                if (Data.maxMoney >= 1000){
                    Status = 2;
                    createHugeSlaveButton();
                } else {
                    break;
                }
        }
    }

    public Label getLabel(){
        return label;
    }
}
