package view;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import entity.object.*;
import entity.object.Character;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IController;
import contract.IModel;
import contract.Order;
import entity.MotionElement;
import entity.MotionlessElement;

public class ViewTest {
	
	private IModel model;
	private View view;
	private IController controller;

	@Before
	public void setUp() throws Exception {
		
		model = new IModel() {
			@Override
			public HashMap<Point, Wall> getWalls() {
				return null;
			}

			@Override
			public ArrayList<Rock> getRocks() {
				return null;
			}

			@Override
			public ArrayList<Diamond> getDiamonds() {
				return null;
			}

			@Override
			public Character getCharacter() {
				return null;
			}

			@Override
			public HashMap<Point, Dirt> getDirts() {
				return null;
			}
		};
		view = new View(model);
		this.controller = new IController() {
			@Override
			public void orderPerform(Order order) {
				
			}

			@Override
			public void play() {
				
			}
		};
		this.view.setController(controller);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetModel() {
		assertEquals(model, this.view.getModel());
	}
	public void testGetController() {
		assertEquals(controller, this.view.getController());
	}


}
