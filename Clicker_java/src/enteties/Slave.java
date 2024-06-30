package enteties;

import Data.Data;
import Utilz.Loadsave;
import main.GamePanel;

public class Slave extends Enteties_master{
    public Slave(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        position = Data.positionHut.clone();
        livingPosition = Data.positionHut.clone();
        desiredPosition = Data.positionField.clone();
        normalize(desiredPosition, livingPosition);
        icon = Loadsave.GetSpriteAtlas(Loadsave.slave);
    }

    public Slave(GamePanel gamePanel, int which){
        this.gamePanel = gamePanel;
        position = Data.positionHut.clone();
        livingPosition = Data.positionHut.clone();
        desiredPosition = Data.positionField.clone();
        normalize(desiredPosition, livingPosition);
        icon = Loadsave.GetSpriteAtlas(Loadsave.slave);
        this.type = which;
        switch (which){
            case 1000:
                this.moneyGain = 11;
                this.walkingSpeed = 1.1;
                break;
            case 10000:
                this.moneyGain = 120;
                this.walkingSpeed = 1.2;
        }
    }
}
