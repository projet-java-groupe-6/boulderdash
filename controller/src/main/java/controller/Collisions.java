package controller;


import contract.IModel;
import entity.MotionElement;
import entity.object.Diamond;
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
		switch (direction) {
			case LEFT:
				elementPoint.x -= 1;
				break;
			case UP:
				elementPoint.y -= 1;
				break;
			case RIGHT:
				elementPoint.x += 1;
				break;
			case DOWN:
				elementPoint.y += 1;
				break;
		}
		Wall wall = this.model.getWalls().get(elementPoint);
		Rock r = null;
		Diamond d = null;
		
		for(Rock rock: this.model.getRocks()) {
			if(rock.getX() == elementPoint.x && rock.getY() == elementPoint.y) {
				r = rock;
			}
		}
		for(Diamond diam: this.model.getDiamonds()) {
			if(diam.getX() == elementPoint.x && diam.getY() == elementPoint.y) {
				d = diam;
				this.model.getDiamonds().remove(diam);
			}
		}
		return wall == null && r == null;
	}
}
