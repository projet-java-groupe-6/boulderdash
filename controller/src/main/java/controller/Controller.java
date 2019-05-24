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
    		this.model.getCharacter().setX(this.model.getCharacter().getX()+1);
    	break;
    	case 'q':
    		this.model.getCharacter().setX(this.model.getCharacter().getX()-1);
    		break;
    	case 'z':
    		this.model.getCharacter().setY(this.model.getCharacter().getY()-1);
    		break;
    	case 's':
    		this.model.getCharacter().setY(this.model.getCharacter().getY()+1);
    		break;
    	}
    	
    	
    }

    @Override
    public void play() {
        this.model.getCharacter().addObserver(this.view.getObserver());
    }

}
