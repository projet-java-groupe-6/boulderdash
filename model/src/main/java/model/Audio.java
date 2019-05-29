package model;

import contract.IAudio;

import javax.sound.sampled.*;
import java.io.IOException;

public class Audio implements IAudio {

    public Clip clip;
    public static Audio instance;

    private Audio(){


    }

    public void stop(){
        clip.stop();
    }

    public void playSound(String sound) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(sound));
            System.out.println("play");
            AudioFormat format = audio.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip)AudioSystem.getLine(info);
            clip.open(audio);
            clip.start();

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

    @Override
    public Clip getClip() {
        return clip;
    }

}
