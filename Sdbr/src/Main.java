


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static int k = 0;
    private static int j = 0;
    private static boolean init = false;


    public static void main(String args[]) {

        final GameField gf = new GameField();
        final Menu m = new Menu();

        final Ball bl = new Ball();
        final Puddle pd = new Puddle();
        final int n = 1000;
        final Objects[] astrs = new Objects[n];
        for (int i = 0; i < n; i++) {
            astrs[i] = new Objects();
        }

        final Controller ctrl = new Controller(pd, gf);
        final Pause ps = new Pause();
        final HUD h = new HUD();

        final Timer timer = new Timer();

        TimerTask ballTask = new TimerTask() {

            @Override
            public void run() {
                BufferedImage tmpImg = new BufferedImage(600, 800, BufferedImage.TYPE_INT_RGB);
                Graphics2D tmp = (Graphics2D) tmpImg.getGraphics();
                if (!gf.isInMenu()) {
                    if (!gf.menuStat()) {
                        SetK();
                        for (int i = getJ(); i < (k / 150); i++) {
                            astrs[i].update(pd, bl, tmp, gf);
                        }
                    }
                    h.update(tmp, gf, pd);
                    ps.menu(tmp, gf);
                    bl.update(pd, tmp, gf);
                    pd.update(bl, tmp, gf);
                    gf.curPanel().getGraphics().drawImage(tmpImg, 0, 0, null);
                    if (gf.isNewGame()) {
                        setJ();
                        gf.setNewGame(false);
                    }
                } else {
                    m.menu(tmp, gf);
                    gf.curPanel().getGraphics().drawImage(tmpImg, 0, 0, null);
                }
            }
        };

        timer.schedule(ballTask, 0, 10);

    }

    private static void setJ() {
        j = k/150;
    }

    private static int getJ() {
        return j;
    }

    private static void SetK() {
        k = k + 1;
    }
}
