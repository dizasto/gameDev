import Controller.Controller;
import Model.*;
import View.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Main {




    public static void main(String args[]) {

        final GameField gf = new GameField();
        final View.Menu m = new View.Menu();

        final Ball bl = new Ball();
        final Puddle pd = new Puddle();
        final int n = 6;
        final Objects[] astrs = new Objects[n];
        for (int i = 0; i < n; i++) {
            astrs[i] = new Objects();
        }


        final Logics obs = new Logics();
        final Pause ps = new Pause();
        final HUD h = new HUD();
        final Ending en = new Ending();
        final Music mu = new Music();
        mu.looped(mu.getMus()[8]);

        final Controller ctrl = new Controller(pd, gf, mu);

        final Timer timer = new Timer();

        TimerTask ballTask = new TimerTask() {

            @Override
            public void run() {
                BufferedImage tmpImg = new BufferedImage(600, 800, BufferedImage.TYPE_INT_RGB);
                Graphics2D tmp = (Graphics2D) tmpImg.getGraphics();
                if (!gf.isInMenu()) {
                    h.texture(gf, tmp);
                    h.update(tmp, pd);
                    obs.moveAll(pd, bl, astrs, tmp, gf, mu);
                    obs.ani(astrs, tmp);
                    bl.update(tmp, gf);
                    pd.update(tmp, gf);
                    ps.menu(tmp, gf);
                    en.end(tmp, gf);
                    h.blocks(gf, tmp, obs);
                    gf.curPanel().getGraphics().drawImage(tmpImg, 0, 0, null);
                    if (gf.isNewGame()) {
                        obs.moveAll(pd, bl, astrs, tmp, gf, mu);
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

}
