package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

public class MotionElementTest {
	
	private MotionElement character;

	String filename;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Before
	public void setUp() {
		this.character = new MotionElement("character.png");
		this.character.setX(1);
		this.character.setY(1);
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
