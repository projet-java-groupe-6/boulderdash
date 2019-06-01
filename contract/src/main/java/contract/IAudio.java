package contract;

import javax.sound.sampled.Clip;

public interface IAudio {

    /**
     * Method to play the sound
     * @return the path to the sound
     */
    void playSound(String sound);
}
