

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dizasto on 17.06.2014.
 */
public class Pause {

    public void menu (Graphics2D somebImg, GameField gf) {
        if (gf.menuStat()) {
            if (gf.getState() == 1) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("source/Resume.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                somebImg.drawImage(img, 200, 200, null);
            } else {
                if (gf.getState() == 2) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("source/NewGame.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    somebImg.drawImage(img, 200, 200, null);
                } else {
                    if (gf.getState() == 3) {
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File("source/ExitToMenu.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        somebImg.drawImage(img, 200, 200, null);
                    }
                }
            }
        }
    }
}
