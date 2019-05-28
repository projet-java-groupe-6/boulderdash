package controller;

import contract.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

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

	private ArrayList<IElement> fallingElements;

	private Random random;

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
    	this.fallingElements = new ArrayList<>();
    	this.random = new Random();
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
    		if(collisions.canMove(Direction.RIGHT, this.model.getCharacter()) && isAlive) {
				this.model.getCharacter().setX(this.model.getCharacter().getX()+1);
			}
    	break;
    	case 'q':
    		if(collisions.canMove(Direction.LEFT, this.model.getCharacter()) && isAlive) {
				this.model.getCharacter().setX(this.model.getCharacter().getX()-1);
			}
    		break;
    	case 'z':
    		if(collisions.canMove(Direction.UP, this.model.getCharacter()) && isAlive) {
				this.model.getCharacter().setY(this.model.getCharacter().getY()-1);
			}
    		break;
    	case 's':
    		if(collisions.canMove(Direction.DOWN, this.model.getCharacter()) && isAlive) {
				this.model.getCharacter().setY(this.model.getCharacter().getY()+1);
			}
    		break;
    	}
    	this.collisions.handleCharacterMove();
    }

	/**
	 * Method to run the game loop
	 */
    public void play() {
        for(IElement element: this.model.getElements()){
        	element.setObserver(this.view.getObserver());
		}
        this.model.getCharacter().setObserver(this.view.getObserver());
        while(this.isAlive) {
        	for(IElement element: getCopyOfElements()) {
        		if(element.canFall()) {
        			if(collisions.canMove(Direction.DOWN, element)) {
        				this.fallingElements.add(element);
        				element.setY(element.getY()+1);
					}
					else {
						this.fallingElements.remove(element);
					}
					if(element.getX() == this.model.getCharacter().getX() && element.getY()+1 == this.model.getCharacter().getY() &&
						this.fallingElements.contains(element)) {
						isAlive = false;
					}
				}
        		if(element.getType() == ElementType.ENNEMY) {
        			moveRandomly(element);
				}
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Exit", "Game OVER", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private void moveRandomly(IElement element) {
    	int xy = random.nextInt(2);
    	if(xy == 1) {
    		int direction = random.nextInt(2);
    		if(collisions.canMove(direction == 1 ? Direction.RIGHT: Direction.LEFT, element)) {
				element.setX(direction == 1 ? element.getX()+1 : element.getX()-1);
			}
		}
    	else {
    		int direction = random.nextInt(2);
    		if(collisions.canMove(direction == 1 ? Direction.UP : Direction.DOWN, element)) {
				element.setY(direction == 1 ? element.getY()-1 : element.getY()+1);
			}
		}
    	collisions.handleEnnemyMove(element);
	}

    private synchronized ArrayList<IElement> getCopyOfElements() {
		ArrayList<IElement> copy = new ArrayList<>();
		copy.addAll(this.model.getElements());
		return copy;
	}
}
