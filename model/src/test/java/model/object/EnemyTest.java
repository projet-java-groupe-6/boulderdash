package model.object;

import contract.ElementType;
import contract.Permeability;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnemyTest {
    Enemy enemy;
    boolean boolcanFall;
    boolean boolcanCross;
    ElementType elmtp;
    Permeability prm;

    /**
     * Initializing enemy test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        enemy = new Enemy();
        this.boolcanFall=false;
        this.boolcanCross=false;
        this.prm = Permeability.BLOCKING;
        this.elmtp = ElementType.ENNEMY;
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test to get the Permeability of the element
     */
    @Test
    public void getPermeability() {
        Permeability excepted = prm;
        assertEquals(excepted, enemy.getPermeability());
    }

    /**
     * Test to know if element can fall
     */
    @Test
    public void canFall() {
        boolean excepted = boolcanFall;
        assertEquals(excepted, enemy.canFall());
    }

    /**
     * Test to know if element can cross semi blocking element
     */
    @Test
    public void canCrossSemiBlocking() {
        boolean excepted = boolcanCross;
        assertEquals(excepted, enemy.canCrossSemiBlocking());
    }

    /**
     * Test to get the type of the element
     */
    @Test
    public void getType() {
        ElementType excepted = elmtp;
        assertEquals(excepted, enemy.getType());
    }
}