package model;

import contract.IAudio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio implements IAudio {

    public static Audio instance;

    private Audio(){


    }

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

    public static Audio getInstance() {
        if(instance == null) {
            instance = new Audio();
        }
        return instance;
    }

}
