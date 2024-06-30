package enteties;

import Data.Data;
import Utilz.Loadsave;
import main.GamePanel;

public class SuperSlave extends Enteties_master{
    public SuperSlave(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        position = Data.positionHut.clone();
        livingPosition = Data.positionHut.clone();
        desiredPosition = Data.positionField.clone();
        normalize(desiredPosition, livingPosition);
        icon = Loadsave.GetSpriteAtlas(Loadsave.superSlave);
        this.moneyGain = 10;
        this.walkingSpeed = 0.5;
        this.type = 1;
        this.amount = 1;
    }

    public SuperSlave(GamePanel gamePanel, int which){
        this.gamePanel = gamePanel;
        position = Data.positionHut.clone();
        livingPosition = Data.positionHut.clone();
        desiredPosition = Data.positionField.clone();
        normalize(desiredPosition, livingPosition);
        icon = Loadsave.GetSpriteAtlas(Loadsave.superSlave);
        this.type = which;
        this.amount = 1;
        switch (which){
            case 1001:
                this.moneyGain = 110;
                this.walkingSpeed = 0.6;
                break;
            case 10001:
                this.moneyGain = 1200;
                this.walkingSpeed = 0.7;
        }
    }
}
