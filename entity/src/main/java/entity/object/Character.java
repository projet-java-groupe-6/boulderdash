package entity.object;

import entity.MotionElement;

public class Character extends MotionElement {
	
	private boolean alive;
	
	public Character() {
		super("character.png");
		this.alive = true;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
