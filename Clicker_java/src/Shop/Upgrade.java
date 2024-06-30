package Shop;

import Data.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Upgrade  extends JButton {
    protected int prize = 0;
    protected double amount = 0.0;
    protected int which = 0;
    protected Upgrades upgrades;

    public Upgrade(double amount, int which, int prize, Upgrades upgrades){
        this.upgrades = upgrades;
        this.prize = prize;
        this.amount = amount;
        this.which = which;
        setBounds(32, 32, 32, 32);
        setOpaque(false);
        setContentAreaFilled(false);
        setText("prize: " + prize);
        //button.setBorderPainted(false);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (Data.money >= prize){
                    Data.money -= prize;
                    System.out.println(which);
                    Data.amount[which] += amount;
                    upgrades.getGamePanel().updateMoneyField();
                    removeSelf();
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //upgrades.getGamePanel().getShop().getLabel().setVisibleAndMore(true, "test");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                upgrades.getGamePanel().getShop().getLabel().setVisibleAndMore(false, "");
            }
        });
        upgrades.add(this);
    }
    private void removeSelf() {
        if (upgrades != null) {
            upgrades.remove(this);
            upgrades.revalidate();
            upgrades.repaint();
            upgrades.getGamePanel().getShop().getLabel().setVisibleAndMore(false, "");
        }
    }
}
