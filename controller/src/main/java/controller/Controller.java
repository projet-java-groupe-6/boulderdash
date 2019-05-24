package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Order;

public class Controller implements IController {
	
	private IView view;
	private IModel model;

    public Controller(IView view, IModel model) {
    	this.view=view;
    	this.model=model;

    }

    @Override
    public void orderPerform(Order order) {
    	switch (order.getTyped()) {
    	case 'd':
    		this.model.getCharacter().setX(this.model.getCharacter().getX()+1);
    	break;
    	case 'q':
    		this.model.getCharacter().setX(this.model.getCharacter().getX()-1);
    	case 'z':
    		this.model.getCharacter().setY(this.model.getCharacter().getY()+1);
    	case 's':
    		this.model.getCharacter().setY(this.model.getCharacter().getY()-1);
    	}
    	
    	
    }

    @Override
    public void play() {

    }

}
