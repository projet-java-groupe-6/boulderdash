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
    public void getPermeability() {
        Permeability excepted = per;
        assertEquals(excepted, rock.getPermeability());
    }

    @Test
    public void canFall() {
        boolean excepted = boolcanFall;
        assertEquals(excepted, rock.canFall());
    }

    @Test
    public void canCrossSemiBlocking() {
        boolean excepted = boolcanCross;
        assertEquals(excepted, rock.canCrossSemiBlocking());
    }
}