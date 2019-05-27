package controller;

import java.util.concurrent.ExecutionException;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Order;
import entity.object.Diamond;
import entity.object.Rock;

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

	/**
	 * The constructor of Controller
	 * @param view
	 * 		View interface
	 * @param model
	 * 		Model interface
	 */
    public Controller(IView view, IModel model) {
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
        this.model.getCharacter().addObserver(this.view.getObserver());
        for(Rock r: this.model.getRocks()) {
        	r.addObserver(this.view.getObserver());
        }
        for(Diamond d: this.model.getDiamonds()) {
        	d.addObserver(this.view.getObserver());
        }
        while(this.model.getCharacter().isAlive()) {
			for (Rock rock : this.model.getRocks()) {
				if(rock.getY()+1 == this.model.getCharacter().getY() && rock.getX() == this.model.getCharacter().getX() && rock.isFalling()){
					this.model.getCharacter().setAlive(false);
				}
				if (this.collisions.canMove(Direction.DOWN, rock)) {
					rock.setFalling(true);
					rock.setY(rock.getY() + 1);

				}
				else {
					rock.setFalling(false);
				}
			}
			for (Diamond diamond : this.model.getDiamonds()) {
				if(diamond.getY()+1 == this.model.getCharacter().getY() && diamond.getX() == this.model.getCharacter().getX() && diamond.isFalling()){
					this.model.getCharacter().setAlive(false);
				}
				if (this.collisions.canMove(Direction.DOWN, diamond)) {
					diamond.setFalling(true);
					diamond.setY(diamond.getY() + 1);
				}
				else {
					diamond.setFalling(false);
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
}
