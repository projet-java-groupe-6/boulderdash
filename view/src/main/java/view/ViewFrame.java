package view;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Order;
import entity.MotionElement;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class ViewFrame extends JFrame implements KeyListener {

    private ViewPanel panel;
    private IView view;
    private IController controller;
    private Observable observable;

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
        observable.addObserver(panel);
    }

    public Observer getObserver() {
        return this.panel;
    }

	@Override
	public void keyPressed(final KeyEvent e) {
		int key = e.getKeyCode();

		switch(e.getKeyCode())
		{
			case KeyEvent.VK_Z: 
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP:
			this.controller.orderPerform(Order.CHARACTER_UP);
			break;
			
			
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
			this.controller.orderPerform(Order.CHARACTER_DOWN);
			break;
			
			
			case KeyEvent.VK_Q:
			case KeyEvent.VK_LEFT:
			this.controller.orderPerform(Order.CHARACTER_LEFT);
			break;
			
			
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
			this.controller.orderPerform(Order.CHARACTER_RIGHT);
			break;
			
			case KeyEvent.VK_SPACE:
			this.controller.orderPerform(Order.CHARACTER_SPELL);
			break;

			case KeyEvent.VK_R:
				this.controller.orderPerform(Order.RETRY);
				break;
				
		}
	}

	@Override
	public void keyReleased(final KeyEvent e) {
    int key = e.getKeyCode();
		
		if( key == KeyEvent.VK_RIGHT) {
			
		}
		if( key == KeyEvent.VK_LEFT) {
			
		}
		
	}

	@Override
	public void keyTyped(final KeyEvent e) {
	    System.out.println("keyTyped");
		
	}
}
