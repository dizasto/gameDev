

import javax.swing.*;
import java.awt.*;

/**
 * Created by dizasto on 08.06.2014.
 */
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
            /*int leftXb = Math.max(x, b.getCntrX() - b.getRad());
            int leftYb = Math.max(y, b.getCntrY() - b.getRad());
            int rightXb = Math.min(x + width, b.getCntrX() + b.getRad());
            int rightYb = Math.min(y + height, b.getCntrY() + b.getRad());
            if (rightXb - leftXb > 0 && rightYb - leftYb > 0) {
                System.out.println("Destroyed!");
                _isAlive = false;
        }*/

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
                                    //if (b.getX() + b.getRad() > x && b.getX() - b.getRad() < (x + width)) {
                                    b.reverseY();
                                    System.out.println("Destroyed! o_x");
                                    _isAlive = false;
                                    //}
                                }
                            }
                        }
                    }

            /*if (b.getY() - b.getRad() > y && b.getY() + b.getRad() < y + height) {
                if (b.getX() - b.getRad() > (x + width) - b.getRad() && b.getX() - b.getRad() < (x + width)) {
                    b.setX((x + width));
                } else {
                    if (b.getX() + b.getRad() > x && b.getX() + b.getRad() < x + b.getRad()) {
                        b.setX(x + b.getRad() * 2);
                    }
                }
            } else {

                if (b.getX() + b.getRad() > x && b.getY() - b.getRad() < x + width) {
                    if (b.getY() + b.getRad() < y + b.getRad() && b.getY() + b.getRad() > y) {
                        b.setY(y + b.getRad() * 2);
                    } else {
                        if (b.getY() - b.getRad() > (y + height) - b.getRad() && b.getY() - b.getRad() < y + height) {
                            b.setY(y + height);
                        }
                    }
                }
            }*/
                }
            }
        }
    }


    public void setDirection(int d) {
        angle = d;
    }










    /*public void astrPuddleCollision(Puddle pd) {
        if (_isAlive) {
            int leftX = Math.max(x, pd.x);
            int leftY = Math.max(y, pd.y);
            int rightX = Math.min(x + width, pd.x + pd.width);
            int rightY = Math.min(y + height, pd.y + pd.height);
            if (rightX - leftX > 0 && rightY - leftY > 0) {
                System.out.println("broke");
                _isAlive = false;
                Puddle.damagePd();
                if (!Puddle.isAlive()) {
                    Puddle.setDead();
                    JOptionPane.showMessageDialog(GameField.panel, "Puddle broken!");
                }
            }
        }
    }

    public void astrBallCollision(Ball b) {
        if (_isAlive) {
            int leftX = Math.max(x, b.getCntrX() - b.getRad());
            int leftY = Math.max(y, b.getCntrY() - b.getRad());
            int rightX = Math.min(x + width, b.getCntrX() + b.getRad());
            int rightY = Math.min(y + height, b.getCntrY() + b.getRad());
            if (rightX - leftX > 0 && rightY - leftY > 0) {
                System.out.println("Destroyed!");
                _isAlive = false;
                if (b.getCntrX() - b.getRad() >= (x + width) - 5 && b.getCntrX() - b.getRad() <= (x + width) || b.getCntrX() + b.getRad() >= x && b.getCntrX() + b.getRad() <= x + 5) {
                    if(b.getCntrY() >= y + 5 && b.getCntrY() <= (y + height) - 5) {
                        b.reverseX();
                    } else {
                        if (b.getCntrY() <= y + 5 && b.getCntrY() >= y || b.getCntrY() <= (y + height) && b.getCntrY() >= (y + height) - 5) {
                            b.reverse();
                        }
                    }
                } else {
                    if (b.getCntrY() + b.getRad() >= y && b.getCntrY() + b.getRad() <= y + 5 || b.getCntrY() - b.getRad() <= (y + height) && b.getCntrY() - b.getRad() >= (y + height) - 5) {
                        if(b.getCntrX() >= x + 5 && b.getCntrX() <= (x + width) - 5) {
                            b.reverseY();
                        } else {
                            if (b.getCntrX() <= x + 5 && b.getCntrX() >= x || b.getCntrX() <= (x + width) && b.getCntrX() >= (y + width) - 5) {
                                b.reverse();
                            }
                        }
                    }
                }

            }
        }
    }

    public void astrsDraw(Graphics2D somebImg) {
        if (_isAlive) {
            somebImg.setColor(Color.WHITE);
            somebImg.drawRect(x, y, width, height);
        }
    }

    public void astrMove() {
        y += Math.round(Math.sin(Math.toRadians(angle)) *  _speed);
    }*/
}
