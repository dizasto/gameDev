package View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu {
    public void menu(Graphics2D somebImg, GameField gf) {
        if (gf.isInMenu()) {
            if (gf.menuInt() == 1) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("source/MenuNew.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                somebImg.drawImage(img, 0, 0, null);
            } else {
                if (gf.menuInt() == 2) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("source/MenuExit.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    somebImg.drawImage(img, 0, 0, null);
                }
            }
        }
    }
}
