package enteties;

import Data.Data;
import Utilz.TimerManuel;
import main.GamePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EntetiesManager {
    private static ArrayList<Enteties_master> enteties = new ArrayList<>();

    public void render(Graphics g){
        for (int i = 0; i < enteties.size(); i++){
            enteties.get(i).render(g);
        }
    }

    public void update(){
        for (int i = 0; i < enteties.size(); i++){
            enteties.get(i).update();
        }
    }

    public static void appendSlave(int which, GamePanel gamePanel, int type){
        switch (which){
            case 0:
                if (type == which){
                    enteties.add(new Slave(gamePanel));
                } else {
                    enteties.add(new Slave(gamePanel, type));
                }
                break;
            case 1:
                if (type == which){
                    enteties.add(new SuperSlave(gamePanel));
                } else {
                    enteties.add(new SuperSlave(gamePanel, type));
                }
                break;
            case 2:
                if (type == which){
                    enteties.add(new HugeSlave(gamePanel));
                } else {
                    enteties.add(new HugeSlave(gamePanel, type));
                }
                break;
        }
    }

    public static void whipping(MouseEvent e){
        for (int i = 0; i < enteties.size(); i++){
            double[] position = enteties.get(i).getPosition();
            if (e.getX() >= position[0] - 96 && e.getX() <= position[0] + 96 && e.getY() >= position[1] - 96 && e.getY() <= position[1] + 96) {
                enteties.get(i).setWhipped(2);
                TimerManuel.appendEnity(enteties.get(i));
            }
        }
    }

    public static void removeSlaves(int which){
        for (int i = 0; i < enteties.size(); i++){
            if (enteties.get(i).getType() == which){
                enteties.remove(i);
                i--;
            }
        }
    }
}
