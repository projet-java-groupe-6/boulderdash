package view;

import java.util.Observer;

import contract.IController;
import contract.IModel;
import contract.IView;

public class View implements IView {
	
	private IModel model;
	private IController controller;
	private ViewFrame frame;
	
	public View (IModel model) {
		this.model = model;
		this.frame = new ViewFrame(this);

	}

	@Override
	public IController getController() {
		return this.controller;
	}

	@Override
	public IModel getModel() {
		return this.model;
	}

	@Override
	public Observer getObserver() {
		return this.frame.getObserver();
	}
	public void setController(IController controller) {
		this.controller = controller;
	}
}
