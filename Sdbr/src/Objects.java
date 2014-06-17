import javax.swing.*;
import java.awt.*;

public class Objects {

    private boolean _isAlive;
    private int angle;

    private int x = (int) Math.round(Math.random() * 536 + 20);
    private int y = (int) Math.round(Math.random() * 20 + 40);

    private int width = (int) Math.round(Math.random() * 20 + 30);
    private int height = (int) Math.round(Math.random() * 20 + 30);

    private double _speed;

    public Objects() {
        _isAlive = true;
        setDirection(90);
        _speed = (int) Math.round(Math.random() * 2 + 1);
    }

    public void update(Puddle pd, Ball b, Graphics2D somebImg, GameField v) {
        if (v.isNewGame()) {
            b.setX((596 - 150) / 2 + 75);
            b.setY(700 - 2 * b.getRad());
            b.setDirection((int) Math.round(Math.random() * 80 + 260));
            pd.setX((596 - 150) / 2);
            pd.setY(700);
            pd.newGame();
        } else {
            if (!v.menuStat()) {
                y += (Math.sin(Math.toRadians(angle)) * _speed);
                if (_isAlive) {
                    somebImg.setColor(Color.WHITE);
                    somebImg.drawRect(x, y, width, height);
                    int leftX = Math.max(x, pd.getX());
                    int leftY = Math.max(y, pd.getY());
                    int rightX = Math.min(x + width, pd.getX() + pd.getWidth());
                    int rightY = Math.min(y + height, pd.getY() + pd.getHeight());
                    if (rightX - leftX > 0 && rightY - leftY > 0) {
                        System.out.println("broke");
                        _isAlive = false;
                        pd.damagePd();
                        if (!pd.isAlive()) {
                            pd.setDead();
                            JOptionPane.showMessageDialog(v.curPanel(), "Puddle broken!");
                            b.setX((596 - 150) / 2 + 75);
                            b.setY(700 - 2 * b.getRad());
                            b.setDirection((int) Math.round(Math.random() * 80 + 260));
                            pd.setX((596 - 150) / 2);
                            pd.setY(700);
                            pd.newGame();
                            v.setNewGame(true);
                        }
                    }
                    if (((b.getX() + b.getRad()) == x || b.getX() - b.getRad() == x + width) && (b.getY() + b.getRad() == y || b.getY() - b.getRad() == y + height)) {
                        b.reverse();
                        System.out.println("Destroyed! corner");
                        _isAlive = false;
                    } else {
                        if (b.getX() + b.getRad() > x && b.getX() - b.getRad() < (x + width)) {
                            if (b.getY() + b.getRad() > y + 7 && b.getY() - b.getRad() < (y + height) - 7) {
                                b.reverseX();
                                System.out.println("Destroyed! o_y");
                                _isAlive = false;

                            } else {
                                if (b.getY() + b.getRad() > y && b.getY() - b.getRad() < (y + height)) {
                                    b.reverseY();
                                    System.out.println("Destroyed! o_x");
                                    _isAlive = false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public void setDirection(int d) {
        angle = d;
    }
}
