package model.object;

import model.MotionElement;

/**
 * @author Theo
 */
public class Rock extends MotionElement {

	private boolean falling;

	/**
	 * The constructor of Rock
	 */
	public Rock() {
		super("images/rock.png");
		this.falling = false;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}
}
