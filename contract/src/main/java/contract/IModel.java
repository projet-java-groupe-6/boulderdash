package contract;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import entity.MotionElement;
import entity.MotionlessElement;
import model.object.*;
import model.object.Character;

/**
 * @author Ilyes
 */
public interface IModel {

	ArrayList<IElement> getElements();
}
