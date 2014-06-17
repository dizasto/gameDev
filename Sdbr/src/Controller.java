

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by dizasto on 08.06.2014.
 */
public class Controller extends KeyAdapter {


    public Controller(final Puddle pd, final GameField v) {
        v.curPanel().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!v.isInMenu()) {
                    if (!v.menuStat()) {
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                            pd.setAlpha(180);
                            pd.startMoving();
                        } else {
                            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                                pd.setAlpha(0);
                                pd.startMoving();
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            v.setState(true);
                        }
                    } else {
                        if (v.getState() == 2) {
                            if (e.getKeyCode() == KeyEvent.VK_UP) {
                                v.setPsState(1);
                            } else {
                                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                    v.setPsState(3);
                                } else {
                                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                        v.setNewGame(true);
                                        v.setState(false);
                                        v.setPsState(1);
                                    }
                                }
                            }
                        }
                        if (v.getState() == 1) {
                            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                v.setPsState(2);
                            } else {
                                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                                    v.setState(false);
                                v.setPsState(1);
                            }
                        }
                        if (v.getState() == 3) {
                            if (e.getKeyCode() == KeyEvent.VK_UP) {
                                v.setPsState(2);
                            } else {
                                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                                    v.setInMenu(true);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            v.setState(false);
                            v.setPsState(1);
                        }
                    }
                } else {
                    if (v.menuInt() == 1) {
                        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                            v.setMenuInt(2);
                        } else {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                v.setNewGame(true);
                                v.setInMenu(false);
                                v.setState(false);
                            }
                        }
                    } else {
                        if (v.menuInt() == 2) {
                            if (e.getKeyCode() == KeyEvent.VK_UP) {
                                v.setMenuInt(1);
                            } else {
                                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                    System.exit(0);
                                }
                            }

                        }
                    }

                }
            }

                @Override
                public void keyReleased (KeyEvent e){
                    pd.stopMoving();
                }
            }

            );
        }


    }

