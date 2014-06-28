package Model;

import View.GameField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Puddle {

    private int alpha;
    private boolean _isMoving;
    private boolean _isPdAlive = true;

    private int lives = 3;

    private double _speed;

    private int x = (596 - 150) / 2;
    private int y = 700;
    private int width = 150;

    private int state = 0;

    public Puddle() {
        _speed = 5;
    }


    public void update(Graphics2D somebImg, GameField v) {
        if (!v.menuStat() || !v.ends()) {
            if (state == 0) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("source/Puddle.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                somebImg.drawImage(img, x, y, null);
            } else {
                if (state == 1) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("source/BrokenPuddle.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    somebImg.drawImage(img, x, y, null);
                }
            }
        }
    }

    public double getSpeed() {
        return _speed;
    }

    public void damagePd() {
        lives -= 1;
        if (lives == 0) {
            _isPdAlive = false;
        }
    }

    public void newGame() {
        lives = 3;
        _isPdAlive = true;
    }

    public int lives() {
        return lives;
    }

    public void setState(int a) {
        state = a;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alph) {
        alpha = alph;
    }

    public boolean isMoving() {
        return _isMoving;
    }

    public boolean isAlive() {
        return _isPdAlive;
    }

    public void setDead() {
        _isPdAlive = false;
    }

    public void startMoving() {
        _isMoving = true;
    }

    public void stopMoving() {
        _isMoving = false;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return 2;
    }

    public void setX(int xx) {
        x = xx;
    }

    public void setY(int yy) {
        y = yy;
    }
}