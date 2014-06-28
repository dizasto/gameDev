package Model;

import View.GameField;
import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball extends Circle {

    private int alpha;
    private int j = 0;


    private double _speed;
    private int _speedC = -5;
    private int diam = 16;
    private int rad = diam / 2;

    private int x = (596 - 150) / 2 + 75;
    private int y = 700 - 2 * rad;

    public Ball() {
        setDirection((int) Math.round(Math.random() * 80 + 260));
        _speed = 0;
    }

    public void update(Graphics2D somebImg, GameField v) {
        if (!v.menuStat() || !v.ends()) {
            j++;
            if (j == 50) {
                j = 0;
            }
            if (j >= 0 && j <=25) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("source/ball.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                somebImg.drawImage(img, x - rad, y - rad, null);
            } else {
                if (j > 25 && j <= 50) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("source/ball1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    somebImg.drawImage(img, x - rad, y - rad, null);
                }
            }
        }
    }

    public void setSpeed(double d) {
        _speed = d;
    }

    public double getSpeed() {
        return _speed;
    }

    public void setDirection(int d) {
        alpha = d;
    }

    public int getDirection() {
        return alpha;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRad() {
        return rad;
    }

    public void setY(int pos) {
        y = pos;
    }

    public void setX(int pos) {
        x = pos;
    }

    public void reverse() {
        alpha = alpha - 180;
    }

    public void upSpeed() {
        if (_speedC != 10) {
            _speed += 0.2;
            _speedC++;
            System.out.println(_speed);
            System.out.println(_speedC);
        }
    }

    public void downSpeed() {
        if (_speedC != -10) {
            _speed -= 0.1;
            _speedC--;
            System.out.println(_speed);
            System.out.println(_speedC);
        }
    }

    public void reverseX() {
        alpha = 180 - alpha;
        alpha = alpha % 360;
    }

    public void reverseY() {
        alpha = 360 - alpha;
        alpha = alpha % 360;
    }
}

