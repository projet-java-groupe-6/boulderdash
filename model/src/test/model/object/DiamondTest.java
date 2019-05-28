package model.object;

import contract.Permeability;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiamondTest {
    Diamond diam;
    boolean boolisfalling;
    Permeability per;
    boolean boolcanFall;
    boolean boolcanCross;


    @Before
    public void setUp() throws Exception {
        this.diam = new Diamond();
        this.boolisfalling=false;
        this.per = Permeability.SEMI_BLOCKING;
        this.boolcanFall=true;
        this.boolcanCross=false;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isFalling() {
        boolean actual= boolisfalling;
        boolean excepted = diam.isFalling();
        assertEquals(excepted, actual);
    }

    @Test
    public void setFalling() {
    }

    @Test
    public void getPermeability() {
        Permeability actual = per;
        Permeability excepted = diam.getPermeability();
        assertEquals(excepted, actual);
    }

    @Test
    public void canFall() {
        boolean actual = boolcanFall;
        boolean excepted = diam.canFall();
        assertEquals(excepted, actual);
    }

    @Test
    public void canCrossSemiBlocking() {
        boolean actual = boolcanCross;
        boolean excepted = diam.canCrossSemiBlocking();
        assertEquals(excepted, actual);
    }
}