package model.object;

import contract.Permeability;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirtTest {
    Dirt dirt;
    int x1;
    int y1;
    Permeability per;
    boolean boolcanFall;
    boolean boolcanCross;
    int x,y;

    /**
     * Initializing the dirt test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        dirt = new Dirt(x,y);
        this.dirt.setX(1);
        this.dirt.setY(1);
        this.per= Permeability.SEMI_BLOCKING;
        this.boolcanFall=false;
        this.boolcanCross=false;
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test to get the x of the element
     */
    @Test
    public void testgetX() {
        int excepted = 1;
        assertEquals(excepted, dirt.getX());
    }

    /**
     * Test to get the y of the element
     */
    @Test
    public void testgetY() {
        int excepted = 1;
        assertEquals(excepted, dirt.getY());
    }

    /**
     * Test to get the Permeability of the element
     */
    @Test
    public void testgetPermeability() {
        Permeability excepted = per;
        assertEquals(excepted, dirt.getPermeability());
    }

    /**
     * Test to know if element can fall
     */
    @Test
    public void testcanFall() {
        boolean excepted = boolcanFall;
        assertEquals(excepted, dirt.canFall());
    }

    /**
     * Test to know if element can cross semi blocking element
     */
    @Test
    public void testcanCrossSemiBlocking() {
        boolean excepted = boolcanCross;
        assertEquals(excepted, dirt.canCrossSemiBlocking());
    }
}