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
		char key = e.getKeyChar();
		Order order= new Order(key);
		this.controller.orderPerform(order);
		
	}

	@Override
	public void keyReleased(final KeyEvent e) {

		
	}

	@Override
	public void keyTyped(final KeyEvent e) {
	    System.out.println("keyTyped");
		
	}
	
}

