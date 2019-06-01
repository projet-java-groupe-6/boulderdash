package controller;

import contract.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observer;

import static org.junit.Assert.*;

public class CollisionsTest {
    Direction dir;
    IElement elm;
    IModel mdl;
    Collisions coll;
    boolean boolcanMove;


    @Before
    public void setUp() throws Exception {
        this.mdl = new IModel() {
            @Override
            public ArrayList<IElement> getElements() {
                return new ArrayList<>();
            }

            @Override
            public IElement getCharacter() {
                return elm;
            }

            @Override
            public IScore getScore() {
                return null;
            }

            @Override
            public IAudio getAudio() {
                return null;
            }
        };
        coll = new Collisions(mdl);
        boolcanMove=true;
        dir= dir.RIGHT;
        this.elm = new IElement() {
            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public void setX(int x) {

            }

            @Override
            public void setY(int y) {

            }

            @Override
            public Permeability getPermeability() {
                return null;
            }

            @Override
            public boolean canFall() {
                return false;
            }

            @Override
            public boolean canCrossSemiBlocking() {
                return false;
            }

            @Override
            public Image getImage() {
                return null;
            }

            @Override
            public void setObserver(Observer observer) {

            }

            @Override
            public ElementType getType() {
                return null;
            }
        };
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