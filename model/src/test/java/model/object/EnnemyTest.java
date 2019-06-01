package model.object;

import contract.ElementType;
import contract.IElement;
import contract.Permeability;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnnemyTest {
    Ennemy ennemy;
    boolean boolcanFall;
    boolean boolcanCross;
    ElementType elmtp;
    Permeability prm;

    @Before
    public void setUp() throws Exception {
        ennemy = new Ennemy();
        this.boolcanFall=false;
        this.boolcanCross=false;
        this.prm = Permeability.BLOCKING;
        this.elmtp = ElementType.ENNEMY;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPermeability() {
        Permeability excepted = prm;
        assertEquals(excepted, ennemy.getPermeability());
    }

    @Test
    public void canFall() {
        boolean excepted = boolcanFall;
        assertEquals(excepted, ennemy.canFall());
    }

    @Test
    public void canCrossSemiBlocking() {
        boolean excepted = boolcanCross;
        assertEquals(excepted, ennemy.canCrossSemiBlocking());
    }

    @Test
    public void getType() {
        ElementType excepted = elmtp;
        assertEquals(excepted, ennemy.getType());
    }
}