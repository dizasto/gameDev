package View;

import Model.Logics;
import Model.Puddle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HUD {

    BufferedImage textre;

    String blocks[] = new String[]{"source/0block.png", "source/1block.png", "source/2block.png", "source/3block.png", "source/4block.png",
            "source/5block.png", "source/6block.png", "source/7block.png", "source/8block.png", "source/9block.png", "source/10block.png",
            "source/11block.png", "source/12block.png", "source/13block.png"};

    public HUD() {
        try {
            textre = ImageIO.read(new File("source/texture.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Graphics2D somebImg, Puddle pd) {


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
                }
            }
        }
    }

    public void blocks(GameField gf, Graphics2D somebImg, Logics l) {
        if (!gf.ends()) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(blocks[l.reCount()]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            somebImg.drawImage(img, 500, 0, null);
        }
    }

    public void texture(GameField gf, Graphics2D somebImg) {
        if (!gf.isInMenu()) {
            somebImg.drawImage(textre, 0, 0, null);
        }
    }
}
