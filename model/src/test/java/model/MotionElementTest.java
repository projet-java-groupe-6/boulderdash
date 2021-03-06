package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.object.Character;

public class MotionElementTest {

    /**
     * Character object
     */
    private Character character;

    /**
     * Initializing MotionElement test
     */
    @Before
    public void setUp() {
        this.character = new Character();
        this.character.setX(1);
        this.character.setY(1);
    }

    /**
     * Test to get the x of motion element
     */
    @Test
    public void testGetX() {
        int expected = 1;
        assertEquals(expected, this.character.getX());
    }

    /**
     * Test to get the y of motion element
     */
    @Test
    public void testGetY() {
        int expected = 1;
        assertEquals(expected, this.character.getY());
    }
}