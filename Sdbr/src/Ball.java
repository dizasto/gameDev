import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball extends Circle {

    private int alpha;


    private double _speed;
    private int _speedC = -5;
    private int diam = 16;
    private int rad = diam / 2;

    //private double gameStarts = 0;

    private int x = (596 - 150) / 2 + 75;
    private int y = 700 - 2 * rad;

    public Ball() {
        setDirection((int) Math.round(Math.random() * 80 + 260));
        _speed = 0;
    }

    public void update(Puddle pd, Graphics2D somebImg, GameField v) {
        if (v.isNewGame()) {
            x = (596 - 150) / 2 + 75;
            y = 700 - 2 * rad;
            setDirection((int) Math.round(Math.random() * 80 + 260));
            pd.setX((596 - 150) / 2);
            pd.setY(700);
            pd.newGame();
            _speed = 0;
            //newGame();
        } else {
            if (!v.menuStat()) {
                //if (gameStarts == 0) {
                //    if (pd.isMoving()) {
                        _speed = 5;
                //        gameStarts = 1;
                //    }
                //}
                if (x <= (rad) || x >= (596 - rad)) {
                    reverseX();
                } else {
                    if (y <= 40 || y >= (800 - rad)) {
                        reverseY();
                    }
                }
                x += Math.round(Math.cos(Math.toRadians(alpha)) * _speed);
                y += Math.round(Math.sin(Math.toRadians(alpha)) * _speed);
                if (x < rad) x = rad;
                if (x > (596 - rad)) x = 596 - rad;
                if (y + rad < 40) {
                    y = 40 + rad;
                }
                if (y > (800 - rad)) y = 800 - rad;

                if (y == 800 - rad) {
                    JOptionPane.showMessageDialog(v.curPanel(), "You lose!");
                    x = (596 - 150) / 2 + 75;
                    y = 700 - 2 * rad;
                    setDirection((int) Math.round(Math.random() * 80 + 260));
                    pd.setX((596 - 150) / 2);
                    pd.setY(700);
                    pd.newGame();
                    _speed = 0;
                    //newGame();
                    v.setNewGame(true);
                }
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("source/ball.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                somebImg.drawImage(img, x - rad, y - rad, null);
            }
        }
    }

    public void setSpeed(double d) {
        _speed = d;
    }

    //public void newGame() {
    //    gameStarts = 1;
    //}

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

