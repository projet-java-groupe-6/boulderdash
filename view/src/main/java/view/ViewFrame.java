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
        super("BoulderDash");
        this.view = v;
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(768, 800);
        this.setLocationRelativeTo(null);
        this.panel = new ViewPanel(this.view.getModel());
        this.setContentPane(panel);
        this.setVisible(true);
        this.addKeyListener(this);
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

