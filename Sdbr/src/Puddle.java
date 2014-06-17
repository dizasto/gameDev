

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dizasto on 09.06.2014.
 */
public class Puddle {

    private int alpha;
    private boolean _isMoving;
    private boolean _isPdAlive = true;

    private int lives = 3;

    private double _speed;

    private int x = (596 - 150) / 2;
    private int y = 700;
    private int width = 150;

    Puddle() {
        _speed = 5;
    }

    int aChg = 20;

    public void update(Ball b, Graphics2D somebImg, GameField v) {
        if(!v.menuStat()) {
            if (_isMoving) {
                x += Math.round(Math.cos(Math.toRadians(alpha)) * _speed);
                if (x <= 0) {
                    _isMoving = false;
                    x = 0;
                } else {
                    if ((x + width) >= 596) {
                        _isMoving = false;
                        x = 596 - width;
                    }
                }
            }
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("source/Puddle.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            somebImg.drawImage(img, x, y, null);
            if (x <= b.getX() && (x + width) >= b.getX()) {
                if (b.getY() + b.getRad() >= y && b.getY() + b.getRad() <= y + 4) {
                    if (_isMoving) {
                        if (Math.abs(b.getDirection()) < 270 && Math.abs(b.getDirection()) >= 90) {
                            if (alpha == 180) {
                                b.upSpeed();
                                b.reverseY();
                                b.setDirection(b.getDirection() - aChg);
                                if (b.getDirection() <= 201) {
                                    b.setDirection(b.getDirection() + aChg);
                                }
                            } else {
                                if (alpha == 0) {
                                    b.downSpeed();
                                    b.reverse();
                                    b.setDirection(b.getDirection() + aChg);
                                    if (b.getDirection() >= 339) {
                                        b.setDirection(b.getDirection() - aChg);
                                    }
                                }
                            }
                        } else {
                            if (Math.abs(b.getDirection()) >= 270 || Math.abs(b.getDirection()) < 90) {
                                if (alpha == 180) {
                                    b.downSpeed();
                                    b.reverse();
                                    b.setDirection(b.getDirection() + aChg);
                                    if (b.getDirection() <= 201) {
                                        b.setDirection(b.getDirection() - aChg);
                                    }
                                } else {
                                    if (alpha == 0) {
                                        b.upSpeed();
                                        b.reverseY();
                                        b.setDirection(b.getDirection() - aChg);
                                        if (b.getDirection() <= 339) {
                                            b.setDirection(b.getDirection() + aChg);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        b.reverseY();
                    }
                    System.out.println("Отскочила по y");
                    System.out.println(Math.abs(b.getDirection()));
                }
            }
        }
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


    /*public void rectDraw(Graphics2D somebImg) {
        //if (_isPdAlive) {
            somebImg.setColor(Color.WHITE);
            somebImg.drawRect(x, y, width, height);
        //}
    }

    public void rectMove() {
        if (_isMoving) {
            x += Math.round(Math.cos(Math.toRadians(alpha)) * _speed);
            if (x <= 0) {
                _isMoving = false;
                x = 0;
            } else {
                if ((x + width) >= 596) {
                    _isMoving = false;
                    x = 596 - width;
                }
            }
        }
    }*/
}