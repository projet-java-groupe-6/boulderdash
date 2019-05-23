package view;

import java.util.Observer;

import contract.IController;
import contract.IModel;
import contract.IView;

public class View implements IView {
	
	private IModel model;
	private IController controller;
	
	public View (IModel model) {
		
		this.model=model;
	
	}

	@Override
	public IController getController() {
		// TODO Auto-generated method stub
		return this.controller;
	}

	@Override
	public IModel getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}

	@Override
	public Observer getObserver() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setController(IController controller) {
		this.controller=controller;
	}
}
