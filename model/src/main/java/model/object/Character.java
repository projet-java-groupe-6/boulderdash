package model.object;

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


	@Override
	public Permeability getPermeability() {
		return Permeability.BLOCKING;
	}

	@Override
	public boolean canFall() {
		return false;
	}

	@Override
	public boolean canCrossSemiBlocking() {
		return true;
	}
}
