package main;




import Utilz.Loadsave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;

public class GameWindow extends JFrame {
    GamePanel gamePanel;
    public GameWindow(GamePanel gamePanel){
        setUndecorated(true);
        this.gamePanel = gamePanel;
        add(gamePanel);
        gamePanel.setGameWindow(this);
        setResizable(false);
        pack();
        int[] dimension = getDimension();
        setLocation(dimension[0], dimension[1]);
        gamePanel.setPanelSize(dimension[0], dimension[1]);
        setVisible(true);
        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                //gamePanel.getGame().windowFocusLost();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {

            }
        });
        setCursorMode(0);
    }

    public int[] getDimension(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int[] dimension = new int[2];
        dimension[0] = (screenSize.width - getWidth()) / 2;
        dimension[1] = screenSize.height - getHeight();
        return dimension;
    }
    public void setCursorMode(int mode){
        BufferedImage cursorImage = null;
        switch (mode){
            case 0:
                cursorImage = Loadsave.GetSpriteAtlas(Loadsave.whip);
                break;
            case 1:
                cursorImage = Loadsave.GetSpriteAtlas(Loadsave.sickel);
                break;
        }
        java.awt.Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImage, new Point(0, 0), "custom cursor");
        this.setCursor(customCursor);
    }

}