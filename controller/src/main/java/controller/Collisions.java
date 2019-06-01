package controller;


import contract.*;

import javax.swing.*;
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
		int x = element.getX(); // getting the position x of the element
		int y = element.getY(); // getting the position x of the element
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
		if(nextElement != null) {
			// Permeability manage
			switch (nextElement.getPermeability()) {
				case BLOCKING:
					if(nextElement.getType() == ElementType.CHARACTER && element.getType() == ElementType.ENNEMY) {
						return true;
					}
					else if(nextElement.getType() == ElementType.ENNEMY && element.getType() == ElementType.CHARACTER) {
						return true;
					}
					return false;
				case NON_BLOCKING:
					return true;
				case SEMI_BLOCKING:
					if(element.canCrossSemiBlocking()) {
						return true;
					}
					return false;
			}
		}
		return true;
	}
	/**
	 * Method to handle a move (e.g: take diamonds...)
	 */
	public void handleCharacterMove() {
		IElement character = this.model.getCharacter();
		int x = character.getX(); // getting the position x of the character
		int y = character.getY(); // getting the positiony of the character
		for(IElement element: this.getCopyOfElements()) {
			if(element.getX() == x && element.getY() == y) {
				if(element.getPermeability() == Permeability.SEMI_BLOCKING) {
					this.model.getElements().remove(element);
					//recovery of a diamond
					if(element.getType() == ElementType.DIAMOND) {
						this.model.getScore().setScore(this.model.getScore().getScore() + 1);
						//running the clip take diamonds
						this.model.getAudio().playSound("audio/takediamonds.wav");
					}
				}
				//when the character arrives at the exit with the 30 diamonds : won part
				else if(element.getType() == ElementType.EXIT && this.model.getScore().getScore() == 30) {
					//running the clip win
					this.model.getAudio().playSound("audio/win.wav");
					//window display titled you win with Exit as a message
					JOptionPane.showMessageDialog(null, "Exit", "You win !", JOptionPane.INFORMATION_MESSAGE);
					//closing windows
					System.exit(0);
				}
				// When the character touch an enemy
				else if(element.getType() == ElementType.ENNEMY) {
					//running the clip lose
					this.model.getAudio().playSound("audio/lose.wav");
					//window display titled Game Over with Exit as a message
					JOptionPane.showMessageDialog(null, "Exit", "Game OVER", JOptionPane.INFORMATION_MESSAGE);
					//closing windows
					System.exit(0);
				}
			}
		}
	}

	public void handleEnnemyMove(IElement ennemy) {
		int x = ennemy.getX(); //getting the position x of the enemy
		int y = ennemy.getY(); //getting the position x of the enemy
		// check if the position of the character is equal to that of the enemy
		if(x == this.model.getCharacter().getX() && y == this.model.getCharacter().getY()) {
			//running the clip lose
			this.model.getAudio().playSound("audio/lose.wav");
			//window display titled Game Over with Exit as a message
			JOptionPane.showMessageDialog(null, "Exit", "Game OVER", JOptionPane.INFORMATION_MESSAGE);
			//closing windows
			System.exit(0);
		}
	}


	/**
	 * Method to get a copy of ArrayList of diamonds
	 * @return ArrayList of diamonds
	 */
	private synchronized ArrayList<IElement> getCopyOfElements() {
		ArrayList<IElement> copy = new ArrayList<>();
		copy.addAll(this.model.getElements());
		return copy;
	}
}
	
