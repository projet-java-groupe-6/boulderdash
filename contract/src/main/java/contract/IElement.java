package contract;

import java.awt.*;
import java.util.Observer;

public interface IElement {

    /**
     * Method to get x
     * @return int x
     */
    int getX();

    /**
     * Method to get y
     * @return int y
     */
    int getY();

    /**
     * Method to set x
     * @param x
     *      int x
     */
    void setX(int x);

    /**
     * Method to set y
     * @param y
     *      int y
     */
    void setY(int y);

    /**
     * Method to get element's Permeability
     * @return Permeability of the element
     */
    Permeability getPermeability();

    /**
     * Method to know if element can fall
     * @return boolean true if element can fall
     */
    boolean canFall();

    /**
     * Method to know if element can cross semi blocking element
     * @return boolean true if element can cross
     */
    boolean canCrossSemiBlocking();

    /**
     * Method to get element's image
     * @return Image of the element
     */
    Image getImage();

    /**
     * Method to set observer
     * @param observer
     *      observer instance
     */
    void setObserver (Observer observer);
}
