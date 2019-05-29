package contract;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ilyes
 */
public interface IModel {

	/**
	 * Method to get all elements
	 * @return ArrayList of elements
	 */
	ArrayList<IElement> getElements();

	/**
	 * Method to get the character
	 * @return interface of element
	 */
	IElement getCharacter();

	/**
	 * Method to get the score
	 * @return interface of score
	 */
	IScore getScore();
}
