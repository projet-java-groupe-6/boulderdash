package model.object;

import contract.ElementType;
import contract.Permeability;
import model.MotionElement;

public class Enemy extends MotionElement {

    public Enemy() {
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

    /**
     * Method to get the type of the element
     * @return ElementType of the element
     */
    @Override
    public ElementType getType() {
        return ElementType.ENNEMY;
    }
}
