package model;

import com.sun.media.sound.WaveFileReader;
import contract.IAudio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio implements IAudio {

    /**
     * Audio instance
     */
    public static Audio instance;

    /**
     * Constructor of audio (private)
     */
    private Audio(){


    }

    /**
     * Method to play sound
     * @param sound
     *      path of sound file
     */
    public void playSound(String sound) {
        try {
            AudioInputStream al = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(sound));
            Clip c = AudioSystem.getClip();
            c.open(al);
            c.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get instance of audio
     * @return instance
     */
    public static Audio getInstance() {
        if(instance == null) {
            instance = new Audio();
        }
        return instance;
    }

}
