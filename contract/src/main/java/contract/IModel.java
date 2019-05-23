package contract;

import java.awt.Point;
import java.util.HashMap;

import entity.MotionElement;
import entity.MotionlessElement;

public interface IModel {
	
	HashMap<Point, MotionlessElement> getWalls();
	MotionElement getCharacter();
}
