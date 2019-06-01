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

	private boolean isAlive; // true if the character is alive

	private ArrayList<IElement> fallingElements; //A list which saves the falling elements : rock, diamond

	private Random random; //a random for the moving of the enemies

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
		// the moving of the character
		switch (order.getTyped()) {
			// RIGHT
    	case 'd':
    		if(collisions.canMove(Direction.RIGHT, this.model.getCharacter()) && isAlive) {
				this.model.getCharacter().setX(this.model.getCharacter().getX()+1);
			}
    	break;
    		//LEFT
    	case 'q':
    		if(collisions.canMove(Direction.LEFT, this.model.getCharacter()) && isAlive) {
				this.model.getCharacter().setX(this.model.getCharacter().getX()-1);
			}
    		break;
    		//UP
    	case 'z':
    		if(collisions.canMove(Direction.UP, this.model.getCharacter()) && isAlive) {
				this.model.getCharacter().setY(this.model.getCharacter().getY()-1);
			}
    		break;
    		//DOWN
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
    	//recovery of the elements
        for(IElement element: this.model.getElements()){
        	element.setObserver(this.view.getObserver());
		}
        this.model.getCharacter().setObserver(this.view.getObserver());
        while(this.isAlive) {
        	for(IElement element: getCopyOfElements()) {
        		//gravity manage
        		if(element.canFall()) {
        			if(collisions.canMove(Direction.DOWN, element)) {
        				this.fallingElements.add(element);
        				element.setY(element.getY()+1);
					}
					else {
						this.fallingElements.remove(element);
					}
					// when a falling element (rock/diamond) fall on the character
					if(element.getX() == this.model.getCharacter().getX() && element.getY()+1 == this.model.getCharacter().getY() &&
						this.fallingElements.contains(element)) {
						isAlive = false;
					}
				}
        		if(element.getType() == ElementType.ENNEMY) {
        			// activating of the random moving for the enemies
        			moveRandomly(element);
				}
			}
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        //when the character is dead : isAlive = false
		this.model.getAudio().playSound("audio/lose.wav");
		JOptionPane.showMessageDialog(null, "Exit", "Game OVER", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    //moving of the enemies
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
