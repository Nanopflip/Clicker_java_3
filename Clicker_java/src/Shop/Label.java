package Shop;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Label extends JPanel {
    private JLabel jLabel;
    public Label(GamePanel gamePanel){
        Dimension size = new Dimension(96, 32);
        setPreferredSize(size);
        setBackground(Color.darkGray);
        setLocation(getWidth() - 300, 35);
        setVisible(false);
        jLabel = new JLabel();
        add(jLabel);
        gamePanel.add(this);

    }

    public void setVisibleAndMore(boolean visible, String text){
        setVisible(visible);
        jLabel.setText(text);
    }
}
