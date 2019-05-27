package controller;


import contract.IModel;
import entity.MotionElement;
import entity.object.Rock;
import entity.object.Wall;

import java.awt.*;
import java.util.Map;

public class Collisions {

	private IModel model;

	public Collisions(IModel model) {
		this.model = model;
	}
	
	public boolean canMove(Direction direction, MotionElement element) {
		int x = element.getX();
		int y = element.getY();
		Point elementPoint = new Point(x, y);
		Wall w = null;
		Rock r = null;
		switch (direction) {
			case LEFT:
				elementPoint.x -= 1;
				w = this.model.getWalls().get(elementPoint);
				break;
			case UP:
				elementPoint.y -= 1;
				w = this.model.getWalls().get(elementPoint);
				break;
			case RIGHT:
				elementPoint.x += 1;
				w = this.model.getWalls().get(elementPoint);
				break;
			case DOWN:
				elementPoint.y += 1;
				w = this.model.getWalls().get(elementPoint);
				break;
		}
		for(Rock rock: this.model.getRocks()) {
			if(rock.getX() == elementPoint.x && rock.getY() == elementPoint.y) {
				r = rock;
			}
		}
		return w == null && r == null;
	}
}
