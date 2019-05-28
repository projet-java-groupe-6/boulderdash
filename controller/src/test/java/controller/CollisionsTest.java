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
        this.boolcanMove=true;
        this.dir=dir;
        this.elm=elm;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void canMove() {
        boolean excepted = boolcanMove;
        boolean actual = coll.canMove(dir,elm);
        assertEquals(excepted, actual);

    }

    @Test
    public void handleCharacterMove() {
    }
}