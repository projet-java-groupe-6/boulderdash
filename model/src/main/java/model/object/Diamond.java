package model.object;

import contract.IElement;
import contract.Permeability;
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

		super("diamond.png");
		this.Falling = false;
	}

	public boolean isFalling() {
		return Falling;
	}

	public void setFalling(boolean falling) {
		Falling = falling;
	}

	@Override
	public Permeability getPermeability() {
		return Permeability.SEMI_BOCKING;
	}

	@Override
	public boolean canFall() {
		return true;
	}

	@Override
	public boolean canCrossSemiBlocking() {
		return false;
	}
}
