package model.object;

import contract.IElement;
import contract.Permeability;
import model.MotionElement;

/**
 * @author Ilyes
 */
public class Diamond extends MotionElement {


	/**
	 * The constructor of Diamond
	 */
	public Diamond() {

		super("diamond.png");
	}


	/**
	 * Method to get Permeability
	 * @return object's Permeability
	 */
	@Override
	public Permeability getPermeability() {
		return Permeability.SEMI_BLOCKING;
	}

	/**
	 * Method to know if the element can fall
	 * @return boolean true if element can fall
	 */
	@Override
	public boolean canFall() {
		return true;
	}

	/**
	 * Method to know if element can cross semi blocking
	 * @return boolean true if element can cross
	 */
	@Override
	public boolean canCrossSemiBlocking() {
		return false;
	}
}
