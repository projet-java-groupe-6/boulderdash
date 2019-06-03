package model.object;

import contract.Permeability;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WallTest {
    Wall wall;
    int x;
    int y;
    Permeability per;
    boolean boolcanFall;
    boolean boolcanCross;

    /**
     * Initializing wall test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        wall = new Wall(x, y);
        this.wall.setX(1);
        this.wall.setY(1);
        this.per= Permeability.BLOCKING;
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
    public void getX() {
        int excepted = 1;
        assertEquals(excepted, wall.getX());
    }

    /**
     * Test to get the y of the element
     */
    @Test
    public void getY() {
        int excepted = 1;
        assertEquals(excepted, wall.getY());
    }

    /**
     * Test to get the Permeability of the element
     */
    @Test
    public void getPermeability() {
        Permeability excepted = per;
        assertEquals(excepted, wall.getPermeability());
    }

    /**
     * Test to know if element can fall
     */
    @Test
    public void canFall() {
        boolean excepted = boolcanFall;
        assertEquals(excepted, wall.canFall());
    }

    /**
     * Test to know if element can cross semi blocking element
     */
    @Test
    public void canCrossSemiBlocking() {
        boolean excepted = boolcanCross;
        assertEquals(excepted, wall.canCrossSemiBlocking());
    }
}