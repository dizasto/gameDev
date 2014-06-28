package Controller;

import Model.Music;
import Model.Puddle;
import View.GameField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    public Controller(final Puddle pd, final GameField v, final Music m) {
        v.curPanel().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!v.isInMenu()) {
                    if (!v.menuStat()) {
                        if (v.ends()) {
                            if (v.getEndState() == 1) {
                                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                    m.sound(m.getMus()[7]);
                                    v.setEnd(false);
                                } else {
                                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                        v.setEndState(2);
                                        m.sound(m.getMus()[6]);
                                    }
                                }
                            } else {
                                if (v.getEndState() == 2) {
                                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                        m.sound(m.getMus()[7]);
                                        v.setEnd(false);
                                        v.setInMenu(true);
                                    } else {
                                        if (e.getKeyCode() == KeyEvent.VK_UP) {
                                            v.setEndState(1);
                                            m.sound(m.getMus()[6]);
                                        }
                                    }
                                }
                            }
                        } else {
                            if (v.isVic()) {
                                if (v.getVicState() == 1) {
                                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                        m.sound(m.getMus()[7]);
                                        v.setVic(false);
                                        v.setNewGame(true);
                                    } else {
                                        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                            v.setVicState(2);
                                            m.sound(m.getMus()[6]);
                                        }
                                    }
                                } else {
                                    if (v.getVicState() == 2) {
                                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                            m.sound(m.getMus()[7]);
                                            v.setVic(false);
                                            v.setInMenu(true);
                                        } else {
                                            if (e.getKeyCode() == KeyEvent.VK_UP) {
                                                v.setVicState(1);
                                                m.sound(m.getMus()[6]);
                                            }
                                        }
                                    }
                                }
                            } else {
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
                            }
                        }
                    } else {
                        if (v.getState() == 2) {
                            if (e.getKeyCode() == KeyEvent.VK_UP) {
                                v.setPsState(1);
                                m.sound(m.getMus()[6]);
                            } else {
                                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                    v.setPsState(3);
                                    m.sound(m.getMus()[6]);
                                } else {
                                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                        m.sound(m.getMus()[7]);
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
                                m.sound(m.getMus()[6]);
                            } else {
                                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                    m.sound(m.getMus()[7]);
                                    v.setState(false);
                                }
                                v.setPsState(1);
                            }
                        }
                        if (v.getState() == 3) {
                            if (e.getKeyCode() == KeyEvent.VK_UP) {
                                v.setPsState(2);
                                m.sound(m.getMus()[6]);
                            } else {
                                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                    v.setInMenu(true);
                                    m.sound(m.getMus()[7]);
                                }
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
                            m.sound(m.getMus()[6]);
                        } else {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                m.sound(m.getMus()[7]);
                                v.setNewGame(true);
                                v.setInMenu(false);
                                v.setState(false);
                            }
                        }
                    } else {
                        if (v.menuInt() == 2) {
                            if (e.getKeyCode() == KeyEvent.VK_UP) {
                                v.setMenuInt(1);
                                m.sound(m.getMus()[6]);
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

