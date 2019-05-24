package contract;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import entity.MotionElement;
import entity.MotionlessElement;
import entity.object.Character;
import entity.object.Rock;

public interface IModel {
	
	HashMap<Point, MotionlessElement> getWalls();
	ArrayList<Rock> getRocks();
	ArrayList<MotionElement>getDiamonds();
	Character getCharacter();
}
