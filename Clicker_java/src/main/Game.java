package main;

import Shop.Shop;
import Utilz.TimerManuel;
import enteties.EntetiesManager;

import java.awt.*;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private EntetiesManager entetiesManager;
    private Shop shop;


    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    public Game(){
        entetiesManager = new EntetiesManager();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        new TimerManuel();
        startGameLoop();
    }

    private void startGameLoop(){
        gameThread = new Thread(this::run);
        gameThread.start();
    }

    public void render(Graphics g){
        entetiesManager.render(g);
    }

    public void update(){
        entetiesManager.update();
    }

    public void setShop(Shop shop){
        this.shop = shop;
    }

    public EntetiesManager getEntetiesManager() {
        return entetiesManager;
    }

    public void run(){
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long lastFrame = System.nanoTime();
        long previesTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0.0;
        double deltaF = 0.0;
        while (true){
            long currentTime = System.nanoTime();

            deltaU += (currentTime- previesTime)/ timePerUpdate;
            deltaF += (currentTime- previesTime)/ timePerFrame;
            previesTime = currentTime;

            if (deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }
            if (deltaF >= 1){
                gamePanel.repaint();
                deltaF--;
                frames++;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + "  | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
}
