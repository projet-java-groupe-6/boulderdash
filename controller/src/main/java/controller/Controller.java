package controller;

import contract.*;

import java.util.ArrayList;

/**
 * @author clement, Ilyes, Theo
 */
public class Controller implements IController {

	/**
	 * View interface
	 */
	private IView view;

	/**
	 * Model interface
	 */
	private IModel model;

	/**
	 * Collisions object
	 */
	private Collisions collisions;

	private boolean isAlive;

	/**
	 * The constructor of Controller
	 * @param view
	 * 		View interface
	 * @param model
	 * 		Model interface
	 */
    public Controller(IView view, IModel model) {
    	this.isAlive = true;
    	this.view=view;
    	this.model=model;
    	this.collisions = new Collisions(model);
    }


	/**
	 * The method to handle an user action
	 * @param order
	 * 		Order object
	 */
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

	/**
	 * Method to run the game loop
	 */
	@Override
    public void play() {
        for(IElement element: this.model.getElements()){
        	element.setObserver(this.view.getObserver());
		}
        this.model.getCharacter().setObserver(this.view.getObserver());
        while(this.isAlive) {
        	for(IElement element: getCopyOfElements()) {
        		if(element.canFall()) {
        			if(collisions.canMove(Direction.DOWN, element)) {
        				element.setY(element.getY()+1);
					}
				}
			}
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        System.exit(0);
    }

    private synchronized ArrayList<IElement> getCopyOfElements() {
		ArrayList<IElement> copy = new ArrayList<>();
		copy.addAll(this.model.getElements());
		return copy;
	}
}
