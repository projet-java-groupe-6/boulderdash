package model.object;

import contract.Permeability;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
    Character car;
    Permeability per;
    boolean bool;
    boolean bool1;


    @Before
    public void setUp() throws Exception {
        car = new Character();
        bool=false;
        bool1=true;
        per = Permeability.BLOCKING;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setX() {
    }

    @Test
    public void setY() {
    }

    @Test
    public void testgetPermeability() {
        Permeability excepted = per;
       assertEquals(excepted, car.getPermeability());
    }

    @Test
    public void testcanFall() {
        boolean excepted = bool;
        assertEquals(excepted, car.canFall());

    }

    @Test
    public void testcanCrossSemiBlocking() {
        boolean excepted = bool1;
        assertEquals(excepted, car.canCrossSemiBlocking());
    }
}