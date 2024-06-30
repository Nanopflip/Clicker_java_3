package enteties;

import Data.Data;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enteties_master {
    protected double[] position = new double[2];
    protected double[] desiredPosition = new double[2];
    protected double[] livingPosition = new double[2];
    protected BufferedImage icon;
    protected double factor = 1.0;
    protected int Status = 0;
    protected double walkingSpeed = 1;
    protected int workSpeed = 1;
    protected int workingProgress = 0;
    protected int moneyGain = 1;
    protected int type = 0;
    protected int amount = 0;
    protected int whipped = 1;
    protected GamePanel gamePanel;

    public void update(){
        switch (Status){
            case 0:
                if (position[0] >= desiredPosition[0] && position[1] <= desiredPosition[1]){ // aufpassen wegen position hütte und feld
                    this.Status = 1;
                } else {
                    position[0] += walkingSpeed * whipped;
                    position[1] += factor * walkingSpeed * whipped;
                }
                break;
            case 1:
                if (workingProgress >= 1000){
                    this.Status = 2;
                    workingProgress = 0;
                    normalize(livingPosition, desiredPosition);
                } else {
                    workingProgress += workSpeed * whipped;
                }
                break;
            case 2:
                if (position[0] <= livingPosition[0] && position[1] >= livingPosition[1]){ // aufpassen wegen position hütte und feld
                    this.Status = 0;
                    Data.money += moneyGain * Data.amount[amount];
                    Data.maxMoney += moneyGain * Data.amount[amount];
                    gamePanel.updateMoneyField();
                } else {
                    position[0] -= walkingSpeed * whipped;
                    position[1] -= factor * walkingSpeed * whipped;
                }
                break;
        }
    }

    protected void normalize(double[] arrayOne, double[] arrayTwo){
        double x = arrayOne[0] - arrayTwo[0];
        double y = arrayOne[1] - arrayTwo[1];
        this.factor = y / x;
    }

    public void render(Graphics g) {
        g.drawImage(icon, (int)(position[0]), (int)(position[1]), 32,32, null);
    }

    public double[] getPosition(){
        return position;
    }

    public void setWhipped(int value){
        whipped = value;
    }

    public int getType(){
        return type;
    }
}
