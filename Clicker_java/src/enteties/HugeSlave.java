package enteties;

import Data.Data;
import Utilz.Loadsave;
import main.GamePanel;

public class HugeSlave extends Enteties_master {
    public HugeSlave(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        position = Data.positionHut.clone();
        livingPosition = Data.positionHut.clone();
        desiredPosition = Data.positionField.clone();
        normalize(desiredPosition, livingPosition);
        icon = Loadsave.GetSpriteAtlas(Loadsave.hugeSlave);
        this.moneyGain = 2;
        this.walkingSpeed = 2;
        this.workSpeed = 2;
        this.type = 2;
        this.amount = 2;
    }

    public HugeSlave(GamePanel gamePanel, int which){
        this.gamePanel = gamePanel;
        position = Data.positionHut.clone();
        livingPosition = Data.positionHut.clone();
        desiredPosition = Data.positionField.clone();
        normalize(desiredPosition, livingPosition);
        icon = Loadsave.GetSpriteAtlas(Loadsave.hugeSlave);
        this.type = which;
        this.workSpeed = 2;
        this.amount = 2;
        switch (which){
            case 1002:
                this.moneyGain = 22;
                this.walkingSpeed = 2.2;
                break;
            case 10002:
                this.moneyGain = 240;
                this.walkingSpeed = 2.4;
        }
    }
}
