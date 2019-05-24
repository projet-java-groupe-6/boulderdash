package controller;

import contract.IController;
import contract.Order;

public class Controller implements IController {

    public Controller() {

    }

    @Override
    public void orderPerform(Order order) {
		/*
    	switch (order){
		case CHARACTER_DOWN:
			hm.move(Direction.DOWN);
			break;
		case CHARACTER_UP:
			hm.move(Direction.UP);
			break;
		case CHARACTER_LEFT:
			hm.move(Direction.LEFT);
			break;
		case CHARACTER_RIGHT:
			hm.move(Direction.RIGHT);
			break;
		case CHARACTER_SPELL:
			hm.sendSpell();
			break;
		case RETRY:
			IHero h = model.getLevel().getHero();
			h.setScore(h.getScore() - RETRY_COST);
			this.model.loadLevel(this.model.getLevel().getId());
			break;
		default:
			System.out.println("Not supported order : "+order.toString());
			break;
	}

    */
    }

    @Override
    public void play() {

    }

}
