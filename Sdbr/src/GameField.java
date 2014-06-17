import javax.swing.*;
import java.awt.*;

public class GameField extends JFrame {

    private int pauseState = 1;
    private int menuState = 1;
    private boolean inMenu = true;
    private boolean paused = false;
    private boolean newGame = false;
    private JPanel panel;

    public GameField() {

        JFrame frame = new JFrame();

        frame.setSize(new Dimension(600, 800));
        frame.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(596, 800));
        panel.setBackground(Color.BLACK);
        panel.setFocusable(true);

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public boolean menuStat() {
        return paused;
    }

    public void setState(boolean b) {
        paused = b;
    }

    public int getState() {
        return pauseState;
    }

    public void setPsState(int n) {
        pauseState = n;
    }

    public int menuInt() {
        return menuState;
    }

    public void setMenuInt(int n) {
        menuState = n;
    }

    public JPanel curPanel() {
        return panel;
    }

    public boolean isNewGame() {
        return newGame;
    }

    public void setNewGame(boolean b) {
        newGame = b;
    }

    public boolean isInMenu() {
        return inMenu;
    }

    public void setInMenu(boolean b) {
        inMenu = b;
    }
}
