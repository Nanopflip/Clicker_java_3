package main;

import Data.Data;
import Input.MouseInput;
import Shop.Shop;
import Utilz.Loadsave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePanel extends JPanel {
    //private MouseInputs mouseInputs;

    private static Game game;
    private Shop shop;
    private MouseInput mouseInput;
    private boolean shopVisible = false;
    private JLabel moneyField;
    private GameWindow gameWindow;



    public GamePanel(Game game){
        this.game = game;
        shop = new Shop(game, this);
        //int[] dimension = gameWindow.getDimension();
        setPanelSize(1080, 256);
        setBackground(Color.green);
        add(shop);
        game.setShop(shop);
        mouseInput = new MouseInput(this);
        //addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
        createCloseButton();
        createMoneyField();
        createShopButton();
    }

    private void createCloseButton(){
        JButton button = new JButton();
        button.setBounds(getWidth()- 64, 3, 32, 32);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        button.setIcon(new ImageIcon("res/x.png"));
        add(button);
    }

    private void createShopButton(){
        JButton button = new JButton();
        button.setBounds(getWidth() - 133, 3, 64, 32);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                setShop();
            }
        });
        button.setIcon(new ImageIcon("res/Shop.png"));
        add(button);
    }

    private void createMoneyField(){
        moneyField = new JLabel();
        moneyField.setHorizontalAlignment(JTextField.RIGHT);
        Font font = new Font("Arial", Font.BOLD, 16);
        moneyField.setFont(font);
        moneyField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        moneyField.setBounds(0, 3, 64, 32);
        updateMoneyField();
        add(moneyField);
    }

    public void updateMoneyField(){
        moneyField.setText(Double.toString(Data.money));
        shop.updateShop();
    }

    public void setPanelSize(int x, int y){
        Dimension size = new Dimension(x,y);
        setPreferredSize(size);
    }

    public void setShop(){
        this.shopVisible = !this.shopVisible;
        shop.setVisibleShop(shopVisible);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        game.render(g);
    }

    public void draw(Graphics g){
        g.drawImage(getToolkit().getImage("res/Hut.png"), 32, 32, 32,32, this);
        g.drawImage(Loadsave.GetSpriteAtlas(Loadsave.field), 320, 0, 32,32, this);
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public Shop getShop(){
        return shop;
    }

    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
}
