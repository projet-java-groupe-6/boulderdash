package entity.object;

import entity.MotionElement;

/**
 * @author Ilyes
 */
public class Character extends MotionElement {

	/**
	 * boolean of character if alive
	 */
	private boolean alive;

	/**
	 * The Character constructor
	 */
	public Character() {
		super("character.png");
		this.alive = true;
	}

	/**
	 * Method to know if character is alive or not
	 * @return Boolean of character state
	 */
	public boolean isAlive() {
		return this.alive;
	}

	/**
	 * Method to set character state
	 * @param alive
	 * 		Boolean of character state
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
