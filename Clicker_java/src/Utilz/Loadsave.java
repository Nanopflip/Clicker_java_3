package Utilz;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Loadsave {
    public static final String whip = "/res/whip.png";
    public static final String slave = "/res/Sklave.png";
    public static final String superSlave = "/res/megasklave.png";
    public static final String hugeSlave = "/res/hugesklave.png";
    public static final String field = "/res/Field.png";
    public static final String sickel = "/res/sickel.png";

    public static BufferedImage GetSpriteAtlas(String filename){
        BufferedImage img = null;
        InputStream is = Loadsave.class.getResourceAsStream(filename);
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }
}
