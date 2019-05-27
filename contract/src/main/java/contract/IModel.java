package contract;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import entity.MotionElement;
import entity.MotionlessElement;
import entity.object.*;
import entity.object.Character;

/**
 * @author Ilyes
 */
public interface IModel {

	/**
	 * @return HashMap of walls
	 */
	HashMap<Point, Wall> getWalls();

	/**
	 * @return ArrayList of rocks
	 */
	ArrayList<Rock> getRocks();

	/**
	 * @return ArrayList of diamonds
	 */
	ArrayList<Diamond> getDiamonds();

	/**
	 * @return Character object
	 */
	Character getCharacter();

	/**
	 * @return HashMap of dirts
	 */
	HashMap<Point, Dirt> getDirts();
	IScore getScore();

	HashMap<Point, Exit> getExit();
}
