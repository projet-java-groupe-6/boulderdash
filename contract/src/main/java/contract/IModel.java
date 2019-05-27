package contract;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import entity.MotionElement;
import entity.MotionlessElement;
import entity.object.Character;
import entity.object.Diamond;
import entity.object.Dirt;
import entity.object.Rock;
import entity.object.Wall;

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
}
