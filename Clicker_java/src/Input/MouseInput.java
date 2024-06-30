package Input;

import Data.Data;
import Utilz.TimerManuel;
import enteties.EntetiesManager;
import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;
    private boolean whipActiv = true;
    public MouseInput(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (whipActiv){
            if (TimerManuel.getWhipTimer()){
                TimerManuel.startWhipTimer();
                EntetiesManager.whipping(e);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        checkFieldBox(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        checkFieldBox(e);
    }

    private void checkFieldBox(MouseEvent e) {
            if (e.getX() >= Data.positionField[0] - 32 && e.getX() <= Data.positionField[0] + 32 && e.getY() >= Data.positionField[1] - 16 && e.getY() <= Data.positionField[1] + 16) {
                if (TimerManuel.getFieldTimer()){
                    Data.money += 1;
                    Data.maxMoney += 1;
                    gamePanel.updateMoneyField();
                    if (whipActiv) {
                        gamePanel.getGameWindow().setCursorMode(1);
                        whipActiv = false;
                    }
                    TimerManuel.startFieldTimer();
                }
            } else {
                if (!whipActiv){
                    gamePanel.getGameWindow().setCursorMode(0);
                    whipActiv = true;
                }
            }
        }
    }

