package model.object;

import contract.ElementType;
import contract.IElement;
import contract.Permeability;
import model.MotionElement;

/**
 * @author Ilyes
 */
public class Character extends MotionElement {

	private String left; 
	private String right;
	private String up;
	private String bottom;
	

	/**
	 * The Character constructor
	 */
	public Character() {
		super("character.png");
		this.left="character_left.png";
		this.right="character_right.png";
		this.up="character_top.png";
		this.bottom="character_bottom.png";
		
	}

	/**
	 * Method to set x and change image
	 * @param x
	 * 		int x
	 */
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

	/**
	 * Method to set y and change image
	 * @param y
	 * 		int y
	 */
	@Override
	public void setY(int y){
		if ( y > this.getY()) {
			this.setFilename(this.bottom);
		} else {
			this.setFilename(this.up);
		}
		this.loadImage();
		super.setY(y);
	}


	/**
	 * Method to get Permeability
	 * @return object's Permeability
	 */
	@Override
	public Permeability getPermeability() {
		return Permeability.BLOCKING;
	}

	/**
	 * Method to know if the element can fall
	 * @return boolean true if element can fall
	 */
	@Override
	public boolean canFall() {
		return false;
	}

	/**
	 * Method to know if element can cross semi blocking
	 * @return boolean true if element can cross
	 */
	@Override
	public boolean canCrossSemiBlocking() {
		return true;
	}

	@Override
	public ElementType getType() {
		return ElementType.CHARACTER;
	}
}
