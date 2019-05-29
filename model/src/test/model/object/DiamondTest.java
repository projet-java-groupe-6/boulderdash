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
        boolean excepted= boolisfalling;
        assertEquals(excepted, diam.isFalling());
    }

    @Test
    public void setFalling() {
    }

    @Test
    public void getPermeability() {
        Permeability excepted = per;
        assertEquals(excepted, diam.getPermeability());
    }

    @Test
    public void canFall() {
        boolean excepted = boolcanFall;
        assertEquals(excepted, diam.canFall());
    }

    @Test
    public void canCrossSemiBlocking() {
        boolean excepted = boolcanCross;
        assertEquals(excepted, diam.canCrossSemiBlocking());
    }
}