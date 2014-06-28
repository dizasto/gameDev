package Model;

import View.GameField;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Objects {

    private boolean _isAlive;
    private int angle;
    private int state = 3;

    private boolean destroyed = false;

    private int x = (int) Math.round(Math.random() * 536 + 20);
    private int y = 70;

    private int width = 0;
    private int height = 0;

    private double _speed;

    public Objects() {
        _isAlive = false;
        setDirection(90);
        _speed = (int) Math.round(Math.random() * 2 + 1);
    }

    public void update(Graphics2D somebImg, GameField v) {
        if (!v.menuStat() || !v.ends()) {
            if (_isAlive) {
                width = 50;
                height = 50;
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("source/BIG.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                somebImg.drawImage(img, x, y, null);
            }
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destr(boolean b) {
        destroyed = b;
    }

    public void setDirection(int d) {
        angle = d;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int yy) {
        y = yy;
    }

    public double getSpeed() {
        return _speed;
    }

    public double getDirection() {
        return angle;
    }

    public boolean isAlive() {
        return _isAlive;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void dead() {
        _isAlive = false;
        state = (int) (Math.random() * 3 + 1);
    }

    public void alive() {
        _isAlive = true;
    }


}
