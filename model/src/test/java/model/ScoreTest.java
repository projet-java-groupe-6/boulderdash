package model;

import static org.junit.Assert.*;

public class ScoreTest {

    /**
     * Int number of diamonds
     */
    int nbrDiamonds;

    /**
     * Score object
     */
    Score score;

    /**
     * Initializing score test
     * @throws Exception
     */
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

    /**
     * Test to get the number of diamond of the score
     */
    @org.junit.Test
    public void testgetScore() {
        int excepted = nbrDiamonds;
        int actual = score.getScore();
        assertEquals(excepted, actual);

    }
}