package contract;

import javax.sound.sampled.Clip;

public interface IAudio {
    Clip getClip();
    void playSound(String sound);
}
