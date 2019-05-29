package controller;

import contract.IElement;
import contract.IModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollisionsTest {
    Direction dir;
    IElement elm;
    IModel mdl;
    Collisions coll;
    boolean boolcanMove;


    @Before
    public void setUp() throws Exception {
        coll = new Collisions(mdl);
        boolcanMove=true;
        dir= dir.LEFT;
        //elm= mdl.getCharacter();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testcanMove() {
        boolean excepted = boolcanMove;
        boolean actual = coll.canMove(dir,elm);
        assertEquals(excepted, actual);

    }

    @Test
    public void testhandleCharacterMove() {
    }
}