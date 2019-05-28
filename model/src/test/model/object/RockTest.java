package model.object;

import contract.Permeability;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RockTest {
    Rock rock;
    Permeability per;
    boolean boolisFalling;
    boolean boolcanFall;
    boolean boolcanCross;

    @Before
    public void setUp() throws Exception {
        rock = new Rock();
        this.per= Permeability.BLOCKING;
        this.boolisFalling=false;
        this.boolcanFall=true;
        this.boolcanCross=false;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isFalling() {
        boolean actual = boolisFalling;
        boolean excepted = rock.isFalling();
        assertEquals(excepted, actual);
    }

    @Test
    public void getPermeability() {
        Permeability actual = per;
        Permeability excepted = rock.getPermeability();
        assertEquals(excepted, actual);
    }

    @Test
    public void canFall() {
        boolean actual = boolcanFall;
        boolean excepted = rock.canFall();
        assertEquals(excepted, actual);
    }

    @Test
    public void canCrossSemiBlocking() {
        boolean actual = boolcanCross;
        boolean excepted = rock.canCrossSemiBlocking();
        assertEquals(excepted, actual);
    }
}