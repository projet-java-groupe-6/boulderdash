package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import static org.junit.Assert.*;

public class AudioTest {
    Clip clip1;
    Audio audio;
    String sound;

    @Before
    public void setUp() throws Exception {
        audio = new Audio(sound);
        this.clip1= AudioSystem.getClip();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void play() {
    }

    @Test
    public void stop() {
    }

    @Test
    public void playSound() {
    }

    @Test
    public void testgetClip() {
        Clip excepted = clip1;
        Clip actual = audio.getClip();
        assertEquals(excepted, actual);

    }
}