package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.object.Character;

public class MotionElementTest {
	
	private Character character;

	@Before
	public void setUp() {
		this.character = new Character();
		this.character.setX(1);
		this.character.setY(1
				);
	}
	
	@Test
	public void testGetX() {
		int expected = 1;
		assertEquals(expected, this.character.getX());
	}
	@Test
	public void testGetY() {
		int expected = 1;
		assertEquals(expected, this.character.getY());
	}
}
