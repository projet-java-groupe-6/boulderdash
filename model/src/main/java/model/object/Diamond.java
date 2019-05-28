package model.object;

import model.MotionElement;

/**
 * @author Ilyes
 */
public class Diamond extends MotionElement {

	private boolean Falling;

	/**
	 * The constructor of Diamond
	 */
	public Diamond() {

		super("images/diamond.png");
		this.Falling = false;
	}

	public boolean isFalling() {
		return Falling;
	}

	public void setFalling(boolean falling) {
		Falling = falling;
	}
}
