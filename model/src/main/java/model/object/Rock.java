package model.object;

import contract.IElement;
import contract.Permeability;
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
		super("rock.png");
		this.falling = false;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	@Override
	public Permeability getPermeability() {
		return Permeability.BLOCKING;
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
