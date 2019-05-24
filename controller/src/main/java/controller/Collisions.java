package controller;


import contract.IModel;
import entity.MotionElement;
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
		switch (direction) {
			case LEFT:
				for(Map.Entry<Point, Wall> walls: this.model.getWalls().entrySet()) {
					if(walls.getKey().x-48 == x && walls.getKey().y == y) {
						return false;
					}
				}
				break;
			case UP:
				for(Map.Entry<Point, Wall> walls: this.model.getWalls().entrySet()) {
					if(walls.getKey().y-1 == y && walls.getKey().x == x) {
						return false;
					}
				}
				break;
			case DOWN:
				for(Map.Entry<Point, Wall> walls: this.model.getWalls().entrySet()) {
					if(walls.getKey().y+1 == y && walls.getKey().x == x) {
						return false;
					}
				}
				break;
			case RIGHT:
				for(Map.Entry<Point, Wall> walls: this.model.getWalls().entrySet()) {
					if(walls.getKey().x+48 == x && walls.getKey().y == y) {
						return false;
					}
				}
				break;
			default:
				return true;
		}
		return true;
	}
}
