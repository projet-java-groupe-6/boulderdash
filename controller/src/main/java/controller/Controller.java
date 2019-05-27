package controller;

import java.util.concurrent.ExecutionException;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Order;
import entity.object.Diamond;
import entity.object.Rock;

public class Controller implements IController {
	
	private IView view;
	private IModel model;
	private Collisions collisions;

    public Controller(IView view, IModel model) {
    	this.view=view;
    	this.model=model;
    	this.collisions = new Collisions(model);
    }

    @Override
    public void orderPerform(Order order) {
    	switch (order.getTyped()) {
    	case 'd':
    		if(collisions.canMove(Direction.RIGHT, this.model.getCharacter())) {
				this.model.getCharacter().setX(this.model.getCharacter().getX()+1);
			}
    	break;
    	case 'q':
    		if(collisions.canMove(Direction.LEFT, this.model.getCharacter())) {
				this.model.getCharacter().setX(this.model.getCharacter().getX()-1);
			}
    		break;
    	case 'z':
    		if(collisions.canMove(Direction.UP, this.model.getCharacter())) {
				this.model.getCharacter().setY(this.model.getCharacter().getY()-1);
			}
    		break;
    	case 's':
    		if(collisions.canMove(Direction.DOWN, this.model.getCharacter())) {
				this.model.getCharacter().setY(this.model.getCharacter().getY()+1);
			}
    		break;
    	}
    	this.collisions.handleCharacterMove();
    }

    @Override
    public void play() {
        this.model.getCharacter().addObserver(this.view.getObserver());
        for(Rock r: this.model.getRocks()) {
        	r.addObserver(this.view.getObserver());
        }
        for(Diamond d: this.model.getDiamonds()) {
        	d.addObserver(this.view.getObserver());
        }
        while(this.model.getCharacter().isAlive()) {
        	for(Rock rock: this.model.getRocks()) {
        		if (this.collisions.canMove(Direction.DOWN, rock)) {
        			rock.setY(rock.getY()+1);
        		}
        	}
        	for (Diamond diamond: this.model.getDiamonds()) {
        		if(this.collisions.canMove(Direction.DOWN, diamond)) {
        			diamond.setY(diamond.getY()+1);
        		}
        	}
        	try {
        		Thread.sleep(300);
        	}
        	catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}
