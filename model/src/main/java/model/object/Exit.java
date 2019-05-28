package model.object;

import contract.IElement;
import contract.Permeability;
import model.MotionlessElement;

public class Exit extends MotionlessElement {

    private int x;
    private int y;

    public Exit(int x, int y){
        super("exit.png");
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
        return Permeability.NON_BLOCKING;
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
