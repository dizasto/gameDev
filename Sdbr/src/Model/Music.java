package Model;

import sun.audio.*;

import java.io.FileInputStream;
import java.io.IOException;


public class Music {

    String mus[] = new String[]{"source/bdish.wav", "source/boom.wav", "source/bang.wav", "source/puddle.wav", "source/vilgelm.wav", "source/victory.wav", "source/click.wav", "source/enter.wav"};

    public void sound(String f) {
        AudioPlayer pl = AudioPlayer.player;
        AudioStream as;
        AudioData ad;
        AudioDataStream loop = null;

        try {
            as = new AudioStream(new FileInputStream(f));
            ad = as.getData();
            loop = new AudioDataStream(ad);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pl.start(loop);
    }

    public String[] getMus() {
            return mus;
    }
}
