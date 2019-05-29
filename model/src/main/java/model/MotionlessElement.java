package model;

import contract.IElement;

import java.util.Observer;

/**
 * @author Theo
 */
public abstract class MotionlessElement extends Sprite implements IElement {

    /**
     * The constructor of MotionlessElement
     * @param filename
     *      The file name of the image
     */
    public MotionlessElement(String filename) {
        super(filename);
    }

    /**
     * Method to set the observer
     * @param observer
     *      observer instance
     */
    @Override
    public void setObserver(Observer observer) {
        this.addObserver(observer);
    }
}
