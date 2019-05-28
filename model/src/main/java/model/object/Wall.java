package model.object;

import contract.IElement;
import contract.Permeability;
import model.MotionlessElement;

/**
 * @author Theo
 */
public class Wall extends MotionlessElement {

	private int x;
	private int y;

	/**
	 * The constructor of Wall
	 */
	public Wall(int x, int y) {
		super("wall.png");
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
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
		return false;
	}
}
