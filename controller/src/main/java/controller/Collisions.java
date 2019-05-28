package controller;


import contract.IElement;
import contract.IModel;
import contract.Permeability;
import entity.MotionElement;
import model.object.*;
import model.object.Character;

import javax.swing.text.Element;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author clement
 */
public class Collisions {

	/**
	 * Model interface
	 */
	private IModel model;

	/**
	 * The constructor of Collisions
	 * @param model
	 * 		Model interface
	 */
	public Collisions(IModel model) {
		this.model = model;
	}

	/**
	 * The method to know if an element can move in a certain direction
	 * @param direction
	 * 		Direction of the move
	 * @param element
	 * 		The element who moves
	 * @return Boolean if the element can move in the specified direction
	 */
	public boolean canMove(Direction direction, IElement element) {
		int x = element.getX();
		int y = element.getY();
		Point elementPoint = new Point(x, y);
		switch (direction) {
			case LEFT:
				elementPoint.x -= 1;
				break;
			case UP:
				elementPoint.y -= 1;
				break;
			case RIGHT:
				elementPoint.x += 1;
				break;
			case DOWN:
				elementPoint.y += 1;
				break;
		}
		IElement nextElement = null;
		for (IElement elements : getCopyOfElements()) {
			if (elementPoint.x == elements.getX() && elementPoint.y == elements.getY()) {
				nextElement = elements;
				break;
			}
		}
		if (elementPoint.x == this.model.getCharacter().getX() && elementPoint.y == this.model.getCharacter().getY()) {
			nextElement = this.model.getCharacter();
		}
		if (nextElement != null) {
			if (nextElement.getPermeability() == Permeability.BLOCKING) {
				return false;
			} else if (nextElement.getPermeability() == Permeability.NON_BLOCKING) {
				return true;
			} else {
				if (element.canCrossSemiBlocking) {
					return true;
				}
				return false;
			} else{
				return true;
			}
		]
		}
	}
	/**
	 * Method to handle a move (e.g: take diamonds...)
	 */
	public synchronized void handleCharacterMove() {
		IElement character = this.model.getCharacter();
		int x = character.getX();
		int y = character.getY();
		for(IElement element: this.getCopyOfElements()) {
			if(element.getX() == x && element.getY() == y && element.getPermeability()==Permeability.SEMI_BOCKING) {
				this.model.getElements().remove(element);
				this.model.getScore().setScore(this.model.getScore().getScore()+1);
			}
		}
		}


	/**
	 * Method to get a copy of ArrayList of diamonds
	 * @return ArrayList of diamonds
	 */
	private synchronized ArrayList<Element> getCopyOfDiamonds() {
		ArrayList<Element> copy = new ArrayList<>();
		copy.addAll(this.model.getElements());
		return copy;
	}
}
	
