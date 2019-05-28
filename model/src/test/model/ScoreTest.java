package model;

import static org.junit.Assert.*;

public class ScoreTest {
    int nbrDiamonds;
    Score score;

    @org.junit.Before
    public void setUp() throws Exception {
        score = new Score();
        this.nbrDiamonds=0;
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testgetNbrDiamonds() {
    }

    @org.junit.Test
    public void testsetScore() {
    }

    @org.junit.Test
    public void testgetScore() {
        int actual = nbrDiamonds;
        int excepted = score.getScore();
        assertEquals(excepted, actual);

    }
}