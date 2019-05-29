package model.object;

import contract.Permeability;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExitTest {
    Exit exit;
    int x, y;
    Permeability per;
    boolean boolcanFall;
    boolean boolcanCross;

    @Before
    public void setUp() throws Exception {
        exit = new Exit(x, y);
        this.exit.setX(1);
        this.exit.setY(1);
        this.per= Permeability.NON_BLOCKING;
        this.boolcanFall=false;
        this.boolcanCross=false;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getX() {
        int excepted = 1;
        assertEquals(excepted, exit.getX());
    }

    @Test
    public void getY() {
        int excepted = 1;
        assertEquals(excepted,  exit.getY());
    }

    @Test
    public void getPermeability() {
        Permeability excepted = per;
        assertEquals(excepted, exit.getPermeability());
    }

    @Test
    public void canFall() {
        boolean excepted = boolcanFall;
        assertEquals(excepted, exit.canFall());
    }

    @Test
    public void canCrossSemiBlocking() {
        boolean excepted = boolcanCross;
        assertEquals(excepted, exit.canCrossSemiBlocking());
    }
}