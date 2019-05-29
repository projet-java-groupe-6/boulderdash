package model;

import contract.IElement;

import java.util.Observer;

/**
 * @author Clement, Theo
 */
public abstract class MotionElement extends Sprite implements IElement {

    /**
     * x of element
     */
    private int x;

    /**
     * y of element
     */
    private int y;

    /**
     * The constructor of MotionElement
     * @param filename
     *      The filename of the image
     */
    public MotionElement(String filename) {
        super(filename);
    }

    /**
     * The method to get the x of element
     * @return int of the x
     */
    public int getX() {
        return this.x;
    }

    /**
     * The method to get the y of element
     * @return int of the y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Method to set the x of element
     * @param x
     *      int of the x
     */
    public void setX(int x) {
        this.x = x;
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Method to set the y of element
     * @param y
     *      int of the y
     */
    public void setY(int y) {
        this.y = y;
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Method to set the Observer
     * @param observer
     *      observer instance
     */
    @Override
    public void setObserver(Observer observer) {
        this.addObserver(observer);
    }
}
