package Model;

import View.GameField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Logics {


    private int t = 0;
    private int tc = 0;
    private int temp = 0;

    private int xx = 0;
    private int yy = 0;

    private int count = 0;
    private int n = 6;
    private int aChg = 20;
    private int area = 4;
    private int cap = 400;
    private int k = 1;
    private int cgang = 0;

    String bigs[] = new String[]{"source/BIGDESTR1.png", "source/BIGDESTR2.png", "source/BIGDESTR3.png", "source/BIGDESTR4.png", "source/BIGDESTR5.png"};

    public void moveAll(Puddle pd, Ball b, Objects[] o, Graphics2D somebImg, GameField v, Music m) {
        if (count == 13) {
            temp = 0;
            count = 0;
            v.setVic(true);
        }

        for (int i = 0; i < n; i++) {
            o[i].update(somebImg, v);
        }

        if (!v.isVic()) {
            if (!v.ends()) {
                if (v.isNewGame()) {
                    newGamez(b, pd);
                    reload(o);
                } else {
                    if (!v.menuStat()) {
                        b.setX(b.getX() + (int) Math.round(Math.cos(Math.toRadians(b.getDirection())) * b.getSpeed()));
                        b.setY(b.getY() + (int) Math.round(Math.sin(Math.toRadians(b.getDirection())) * b.getSpeed()));
                        if (b.getX() <= (b.getRad()) || b.getX() >= (596 - b.getRad())) {
                            b.reverseX();
                            m.sound(m.getMus()[2]);
                        } else {
                            if (b.getY() - b.getRad() <= 40 || b.getY() >= (800 - b.getRad())) {
                                b.reverseY();
                                m.sound(m.getMus()[2]);
                            }
                        }
                        if (b.getX() < b.getRad()) b.setX(b.getRad());
                        if (b.getX() > (596 - b.getRad())) b.setX(596 - b.getRad());
                        if (b.getY() - b.getRad() < 40) {
                            b.setY(40 + b.getRad());
                        }
                        if (b.getY() > (800 - b.getRad())) b.setY(800 - b.getRad());

                        if (b.getY() == 800 - b.getRad()) {
                            temp = 0;
                            v.setEnd(true);
                            reload(o);
                            newGamez(b, pd);
                            v.setNewGame(true);
                        }

                        if (pd.isMoving()) {
                            pd.setX(pd.getX() + (int) Math.round(Math.cos(Math.toRadians(pd.getAlpha())) * pd.getSpeed()));
                            if (pd.getX() <= 0) {
                                pd.stopMoving();
                                pd.setX(0);
                            } else {
                                if ((pd.getX() + pd.getWidth()) >= 596) {
                                    pd.stopMoving();
                                    pd.setX(596 - pd.getWidth());
                                }
                            }
                        }

                        if (pd.getX() <= b.getX() && (pd.getX() + pd.getWidth()) >= b.getX()) {
                            if (b.getY() + b.getRad() >= pd.getY() && b.getY() + b.getRad() <= pd.getY() + 4) {
                                if (cgang == 0) {
                                    if (pd.isMoving()) {
                                        if ((Math.abs(b.getDirection()) % 360) < 270 && (Math.abs(b.getDirection()) % 360) >= 90) {
                                            double a = b.getDirection();
                                            if (pd.getAlpha() == 180) {
                                                b.upSpeed();
                                                b.reverseY();
                                                b.setDirection(b.getDirection() - aChg);
                                                if (b.getDirection()%360 <= 201) {
                                                    b.setDirection(b.getDirection() + aChg);
                                                }
                                            } else {
                                                if (pd.getAlpha() == 0) {
                                                    b.downSpeed();
                                                    b.reverse();
                                                    b.setDirection(b.getDirection() + aChg);
                                                    if (b.getDirection()%360 >= 339) {
                                                        b.setDirection(b.getDirection() - aChg);
                                                    }
                                                }
                                            }
                                            if (a == b.getDirection()) {
                                                b.reverseY();
                                            }
                                            cgang++;
                                        } else {
                                            if ((Math.abs(b.getDirection()) % 360) >= 270 || (Math.abs(b.getDirection()) % 360) < 90) {
                                                double a = b.getDirection();
                                                if (pd.getAlpha() == 180) {
                                                    b.upSpeed();
                                                    b.reverse();
                                                    b.setDirection(b.getDirection() + aChg);
                                                    if (b.getDirection()%360 <= 201) {
                                                        b.setDirection(b.getDirection() - aChg);
                                                    }
                                                } else {
                                                    if (pd.getAlpha() == 0) {
                                                        b.setSpeed(b.getSpeed() + 0.2);
                                                        b.downSpeed();
                                                        b.setDirection(b.getDirection() - aChg);
                                                        if (b.getDirection()%360 <= 339) {
                                                            b.setDirection(b.getDirection() + aChg);
                                                        }
                                                    }
                                                }
                                                if (a == b.getDirection()) {
                                                    b.reverseY();
                                                }
                                                cgang++;
                                            }
                                        }
                                    } else {
                                        b.reverseY();
                                        cgang++;
                                    }
                                }
                                m.sound(m.getMus()[3]);
                            }
                        }

                        if (cgang != 0) {
                            pd.setState(1);
                            if (cgang != 25) {
                                cgang++;
                            } else {
                                cgang = 0;
                                pd.setState(0);
                            }
                        }

                        for (int i = 0; i < n; i++) {
                            if (cap != cap * 5) {
                                if (k != cap) {
                                    k++;
                                } else {
                                    o[i].alive();
                                    cap = cap + 400;
                                }
                            }
                            if (o[i].isAlive()) {
                                o[i].setY(o[i].getY() + (int) (Math.sin(Math.toRadians(o[i].getDirection())) * o[i].getSpeed()));
                                if (o[i].getY() >= 790) {
                                    o[i].dead();
                                    o[i].setY(20);
                                }
                                int leftX = Math.max(o[i].getX(), pd.getX());
                                int leftY = Math.max(o[i].getY(), pd.getY());
                                int rightX = Math.min(o[i].getX() + o[i].getWidth(), pd.getX() + pd.getWidth());
                                int rightY = Math.min(o[i].getY() + o[i].getHeight(), pd.getY() + pd.getHeight());
                                if (rightX - leftX > 0 && rightY - leftY > 0) {

                                    xx = o[i].getX();
                                    yy = o[i].getY();
                                    o[i].destr(true);

                                    o[i].dead();
                                    o[i].setY(20);

                                    int r = (int) (Math.random() * 2);
                                    m.sound(m.getMus()[r]);
                                    pd.damagePd();
                                    if (!pd.isAlive()) {
                                        temp = 0;
                                        v.setEnd(true);
                                        pd.setDead();
                                        reload(o);
                                        newGamez(b, pd);
                                        v.setNewGame(true);
                                    }
                                }
                                if (((b.getX() + b.getRad()) == o[i].getX() || b.getX() - b.getRad() == o[i].getX() + o[i].getWidth()) && (b.getY() + b.getRad() == o[i].getY() || b.getY() - b.getRad() == o[i].getY() + o[i].getHeight())) {
                                    b.reverse();

                                    xx = o[i].getX();
                                    yy = o[i].getY();
                                    o[i].destr(true);

                                    o[i].dead();
                                    o[i].setY(20);

                                    count++;
                                    int r = (int) (Math.random() * 2);
                                    m.sound(m.getMus()[r]);
                                } else {
                                    if (b.getX() + b.getRad() > o[i].getX() && b.getX() - b.getRad() < (o[i].getX() + o[i].getWidth())) {
                                        if (b.getY() + b.getRad() > o[i].getY() + area && b.getY() - b.getRad() < (o[i].getY() + o[i].getHeight()) - area) {
                                            b.reverseX();

                                            xx = o[i].getX();
                                            yy = o[i].getY();
                                            o[i].destr(true);

                                            o[i].dead();
                                            o[i].setY(20);

                                            count++;
                                            int r = (int) (Math.random() * 2);
                                            m.sound(m.getMus()[r]);
                                        } else {
                                            if (b.getY() + b.getRad() > o[i].getY() && b.getY() - b.getRad() < (o[i].getY() + o[i].getHeight())) {
                                                b.reverseY();

                                                xx = o[i].getX();
                                                yy = o[i].getY();
                                                o[i].destr(true);


                                                o[i].dead();
                                                o[i].setY(20);
                                                count++;
                                                int r = (int) (Math.random() * 2);
                                                m.sound(m.getMus()[r]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                count = 0;
                if (temp == 0) {
                    m.sound(m.getMus()[4]);
                    temp++;
                }
            }
        } else {
            if (temp == 0) {
                m.sound(m.getMus()[5]);
                temp++;
            }
        }
    }

    private void newGamez(Ball b, Puddle pd) {
        b.setX((596 - 150) / 2 + 75);
        b.setY(700 - 2 * b.getRad());
        b.setDirection((int) Math.round(Math.random() * 80 + 260));
        pd.setX((596 - 150) / 2);
        pd.setY(700);
        pd.newGame();
        b.setSpeed(5);
    }

    private void reload(Objects[] o) {
        for (int i = 0; i < n; i++) {
            o[i].dead();
            o[i].setY(70);
            k = 1;
            cap = 400;
        }
    }

    public int reCount() {
        return count;
    }

    public void ani(Objects[] o, Graphics2D somebImg) {
        for (int i = 0; i < n; i++) {
            if (o[i].isDestroyed()) {
                tc++;
                System.out.println(tc);
                if (tc >= 0 && tc <= 4) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File(bigs[t]));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    somebImg.drawImage(img, xx, yy, null);
                    t++;
                    tc = 0;
                    if (t == 4) {
                        t = 0;
                        o[i].destr(false);
                    }
                }
            }
        }
    }
}
