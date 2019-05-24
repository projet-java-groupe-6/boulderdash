package contract;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import entity.MotionElement;
import entity.MotionlessElement;

public interface IModel {
	
	HashMap<Point, MotionlessElement> getWalls();
	ArrayList<MotionElement> getRocks();
	MotionElement getCharacter();
}
