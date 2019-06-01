package model.object;

import contract.ElementType;
import contract.Permeability;
import model.MotionElement;

public class Ennemy extends MotionElement {

    public Ennemy() {
        super("ennemy.png");
    }

    /**
     * Method to get Permeability
     * @return enemies Permeability
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
        return false;
    }

    @Override
    public ElementType getType() {
        return ElementType.ENNEMY;
    }
}
