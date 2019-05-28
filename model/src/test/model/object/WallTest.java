package model.object;

import contract.Permeability;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WallTest {
    Wall wall;
    int x1;
    int y1;
    Permeability per;
    boolean boolcanFall;
    boolean boolcanCross;

    @Before
    public void setUp() throws Exception {
        wall = new Wall(x1, y1);
        this.x1=x1;
        this.y1=y1;
        this.per= Permeability.BLOCKING;
        this.boolcanFall=false;
        this.boolcanCross=false;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getX() {
        int actual = x1;
        int excepted = wall.getX();
        assertEquals(excepted, actual);
    }

    @Test
    public void getY() {
        int actual = y1;
        int excepted = wall.getY();
        assertEquals(excepted, actual);
    }

    @Test
    public void getPermeability() {
        Permeability actual = per;
        Permeability excepted = wall.getPermeability();
        assertEquals(excepted, actual);
    }

    @Test
    public void canFall() {
        boolean actual = boolcanFall;
        boolean excepted = wall.canFall();
        assertEquals(excepted, actual);
    }

    @Test
    public void canCrossSemiBlocking() {
        boolean actual = boolcanCross;
        boolean excepted = wall.canCrossSemiBlocking();
        assertEquals(excepted, actual);
    }
}