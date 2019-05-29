package model.object;

import contract.IElement;
import contract.Permeability;
import model.MotionlessElement;

public class Exit extends MotionlessElement {

    /**
     * x position
     */
    private int x;

    /**
     * y position
     */
    private int y;


    /**
     * The constructor of exit
     * @param x
     *      int x
     * @param y
     *      int y
     */
    public Exit(int x, int y){
        super("exit.png");
        this.x = x;
        this.y = y;
    }


    /**
     * Method to get x
     * @return x
     */
    @Override
    public int getX() {
        return this.x;
    }


    /**
     * Method to get y
     * @return y
     */
    @Override
    public int getY() {
        return this.y;
    }


    /**
     * Method to set x
     * @param x
     *      int x
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Method to set y
     * @param y
     *      int y
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Method to get Permeability
     * @return object's Permeability
     */
    @Override
    public Permeability getPermeability() {
        return Permeability.NON_BLOCKING;
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
}
