package controller;


import contract.IModel;
import entity.DirtState;
import entity.MotionElement;
import entity.object.*;
import entity.object.Character;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
		boolean canCrossDirt = true;
		for(Rock rock: this.model.getRocks()) {
			if(rock.getX() == elementPoint.x && rock.getY() == elementPoint.y) {
				r = rock;
			}
		}
		if(!(element instanceof Character)) {
			Dirt dirt = this.model.getDirts().get(elementPoint);
			if(dirt != null && dirt.getDirtState() == DirtState.UNDUG) {
				canCrossDirt = false;
			}
		}
		return wall == null && r == null && canCrossDirt;
	}

	public synchronized void handleCharacterMove() {
		Character character = this.model.getCharacter();
		int x = character.getX();
		int y = character.getY();
		for(Diamond diamond: getCopyOfDiamonds()) {
			if(diamond.getX() == x && diamond.getY() == y) {
				this.model.getDiamonds().remove(diamond);
			}
		}
	}

	private synchronized ArrayList<Diamond> getCopyOfDiamonds() {
		ArrayList<Diamond> copy = new ArrayList<>();
		copy.addAll(this.model.getDiamonds());
		return copy;
	}
}
