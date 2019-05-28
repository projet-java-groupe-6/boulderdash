package model.object;

import model.MotionElement;

/**
 * @author Ilyes
 */
public class Character extends MotionElement {

	/**
	 * boolean of character if alive
	 */
	private boolean alive;
	private String left; 
	private String right;
	private String up;
	private String bottom;
	private String normal;
	

	/**
	 * The Character constructor
	 */
	public Character() {
		super("character.png");
		this.alive = true;
		this.left="character_left.png";
		this.right="character_right.png";
		this.up="character_top.png";
		this.bottom="character_bottom.png";
		this.normal="character.png";
		
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

	@Override
	public void setX(int x) {
		if(x > this.getX()) {
			this.setFilename(this.right);
		}
		else {
			this.setFilename(this.left);
		}
		this.loadImage();
		super.setX(x);
	}
	public void setY(int y){
		if ( y > this.getY()) {
			this.setFilename(this.bottom);
		} else {
			this.setFilename(this.up);
		}
		this.loadImage();
		super.setY(y);
	}
	

}
