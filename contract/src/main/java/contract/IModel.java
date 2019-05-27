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

public interface IModel {
	
	HashMap<Point, Wall> getWalls();
	ArrayList<Rock> getRocks();
	ArrayList<Diamond>getDiamonds();
	Character getCharacter();
	HashMap<Point, Dirt> getDirts();
}
