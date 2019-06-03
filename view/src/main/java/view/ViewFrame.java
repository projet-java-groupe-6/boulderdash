package view;

import contract.IView;
import contract.Order;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observer;

/**
 * @author clement
 */
public class ViewFrame extends JFrame implements KeyListener {

    /**
     * ViewPanel object
     */
    private ViewPanel panel;

    /**
     * View interface
     */
    private IView view;

    /**
     * The ViewFrame constructor
     * @param v
     *      View interface
     */
    public ViewFrame(IView v) {
        // set a title for our window
        super("BoulderDash");
        this.view = v;
        // interdict to resize it
        this.setResizable(false);
        //finish the process when clicking on the red cross
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //set size: 768 pixels wide and 736 pixels high
        this.setSize(768, 736);
        //ask the window to position itself in the center
        this.setLocationRelativeTo(null);
        this.panel = new ViewPanel(this.view.getModel());
        this.setContentPane(panel);
        // make the window visible
        this.setVisible(true);
        // add a key listener to the view
        this.addKeyListener(this);
        // set color of the back ground to : black
        this.setBackground(Color.black);
    }

    /**
     * Method to get the observer
     * @return Observer object
     */
    public Observer getObserver() {
        return this.panel;
    }

    /**
     * Keyboard event
     * @param e
     *      KeyEvent object
     */
	@Override
	public void keyPressed(final KeyEvent e) {
		char key = e.getKeyChar();
		Order order= new Order(key);
		this.view.getController().orderPerform(order);
	}

    /**
     * Keyboard event
     * @param e
     *      KeyEvent object
     */
	@Override
	public void keyReleased(final KeyEvent e) {

	}

    /**
     * Keyboard event
     * @param e
     *      KeyEvent object
     */
	@Override
	public void keyTyped(final KeyEvent e) {
		
	}
	
}

