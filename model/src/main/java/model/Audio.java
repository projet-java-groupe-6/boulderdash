package model;

import contract.IAudio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio implements IAudio {
    public Clip clip;



    public Audio(String sound){

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(sound));
            clip = AudioSystem.getClip();
            clip.open(audio);

        } catch (Exception e) {}
    }

    public void play(){
        clip.start();
    }

    public void stop(){
        clip.stop();
    }

    public void playSound(String sound){
        Audio s = new Audio(sound);
        s.play();
    }

    @Override
    public Clip getClip() {
        return clip;
    }

}
