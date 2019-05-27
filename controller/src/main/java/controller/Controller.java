package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Order;

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
    	
    	
    }

    @Override
    public void play() {
        this.model.getCharacter().addObserver(this.view.getObserver());
    }
}
