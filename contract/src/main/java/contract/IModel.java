package contract;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ilyes
 */
public interface IModel {

	ArrayList<IElement> getElements();
	IElement getCharacter();
	IScore getScore();
}
