


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HUD {

    public void update (Graphics2D somebImg, GameField gf, Puddle pd) {
        if (!gf.menuStat()) {
            if (pd.lives() == 3) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("source/3lives.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                somebImg.drawImage(img, 0, 0, null);
            } else {
                if (pd.lives() == 2) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("source/2lives.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    somebImg.drawImage(img, 0, 0, null);
                } else {
                    if (pd.lives() == 1) {
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File("source/1live.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        somebImg.drawImage(img, 0, 0, null);
                    } else {
                        if (pd.lives() == 0) {
                            BufferedImage img = null;
                            try {
                                img = ImageIO.read(new File("source/zerolives.png"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            somebImg.drawImage(img, 0, 0, null);
                        }
                    }
                }
            }
        }
    }
}
