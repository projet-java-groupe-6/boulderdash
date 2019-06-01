package contract;

import javax.sound.sampled.Clip;

public interface IAudio {

    /**
     * Method to play sound
     * @param sound
     *      path of sound file
     */
    void playSound(String sound);
}
