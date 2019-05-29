package contract;


import java.util.ArrayList;

/**
 * @author Ilyes
 */
public interface IModel {

	ArrayList<IElement> getElements();
	IElement getCharacter();
	IScore getScore();
	IAudio getCLip();
	IAudio playSound(String sound);
}
