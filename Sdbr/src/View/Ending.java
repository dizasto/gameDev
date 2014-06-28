package View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ending {
    public void end(Graphics2D somebImg, GameField gf) {
        if (gf.ends()) {
            if (gf.getEndState() == 1) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("source/TryAgain.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                somebImg.drawImage(img, 200, 200, null);
            } else {
                if (gf.getEndState() == 2) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("source/GiveUp.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    somebImg.drawImage(img, 200, 200, null);
                }
            }
        } else {
            if (gf.isVic())
            {
                if (gf.getVicState() == 1) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("source/VicTryAgain.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    somebImg.drawImage(img, 200, 200, null);
                } else {
                    if (gf.getVicState() == 2) {
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File("source/VicMenu.png"));
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
