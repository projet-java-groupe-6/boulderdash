package controller;


import contract.IModel;
import entity.MotionElement;
import entity.object.*;
import entity.object.Character;

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
	public boolean canMove(Direction direction, MotionElement element) {
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
		Wall wall = this.model.getWalls().get(elementPoint);
		Rock r = null;
		Diamond d = null;
		Dirt dirt = null;
		boolean canFall = true;
		for(Rock rock: this.model.getRocks()) {
			if(rock.getX() == elementPoint.x && rock.getY() == elementPoint.y) {
				r = rock;
			}
		}
		if(!(element instanceof Character)) {
			for(Diamond diamond: this.model.getDiamonds()) {
				if(diamond.getX() == elementPoint.x && diamond.getY() == elementPoint.y) {
					d = diamond;
				}
			}
			dirt = this.model.getDirts().get(elementPoint);
			if(this.model.getCharacter().getY() == elementPoint.y && this.model.getCharacter().getX() == elementPoint.x) {
				canFall = false;
			}
		}
		return wall == null && r == null && d == null && dirt == null && canFall;
	}

	/**
	 * Method to handle a move (e.g: take diamonds...)
	 */
	public synchronized void handleCharacterMove() {
		Character character = this.model.getCharacter();
		int x = character.getX();
		int y = character.getY();
		for(Diamond diamond: getCopyOfDiamonds()) {
			if(diamond.getX() == x && diamond.getY() == y) {
				this.model.getDiamonds().remove(diamond); 
				this.model.getScore().setScore(this.model.getScore().getScore()+1);
			}
		}
		Point p = new Point(x, y);
		Dirt dirt = this.model.getDirts().get(p);
		if(dirt != null) {
			this.model.getDirts().remove(p);
		}
	}

	/**
	 * Method to get a copy of ArrayList of diamonds
	 * @return ArrayList of diamonds
	 */
	private synchronized ArrayList<Diamond> getCopyOfDiamonds() {
		ArrayList<Diamond> copy = new ArrayList<>();
		copy.addAll(this.model.getDiamonds());
		return copy;
	}
}
