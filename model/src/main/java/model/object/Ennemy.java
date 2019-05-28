package model.object;

import contract.ElementType;
import contract.Permeability;
import model.MotionElement;

public class Ennemy extends MotionElement {

    public Ennemy() {
        super("ennemy.png");
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

    @Override
    public ElementType getType() {
        return ElementType.ENNEMY;
    }
}
