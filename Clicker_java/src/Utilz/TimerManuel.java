package Utilz;

import enteties.Enteties_master;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerManuel {
    private static boolean fieldTimer = true;
    private static boolean whipTimer = true;
    private static Timer timerFieldCooldown;
    private static Timer whipCooldown;
    private static ArrayList<Enteties_master> enteties = new ArrayList<>();

        public TimerManuel() {
            timerFieldCooldown = new Timer(25, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fieldTimer = true;
                }
            });
            whipCooldown = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whipTimer = true;
                    for (int i = 0; i < enteties.size(); i++) {
                        enteties.get(i).setWhipped(1);
                    }
                    enteties.clear();
                }
            });
            whipCooldown.setRepeats(false);
            timerFieldCooldown.setRepeats(false);
        }


    public static boolean getFieldTimer(){
        return fieldTimer;
    }

    public static void startFieldTimer(){
        fieldTimer = false;
        timerFieldCooldown.start();
    }

    public static boolean getWhipTimer(){
        return whipTimer;
    }

    public static void startWhipTimer(){
        whipTimer = false;
        whipCooldown.start();
    }

    public static void appendEnity(Enteties_master slave){
                enteties.add(slave);
    }

}
