package model;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import model.object.Character;

import entity.MotionElement;
import entity.MotionlessElement;

public class DAOModelTest {
	
	private DAOModel model;
	private Character character;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.model = new DAOModel();
		this.character = new Character();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWalls() {
		HashMap<Point, MotionlessElement> expected = new HashMap<>();
		assertEquals(expected, this.model.getWalls());
	}
	public void testgetCharacter() {
		assertEquals(character, this.model.getCharacter());
	}

}
