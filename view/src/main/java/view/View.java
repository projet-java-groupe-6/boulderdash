package view;

import java.util.Observer;

import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * @author Clement, Theo, Ilyes
 */
public class View implements IView {

	/**
	 * IModel interface
	 */
	private IModel model;

	/**
	 * IController interface
	 */
	private IController controller;

	/**
	 * ViewFrame object
	 */
	private ViewFrame frame;

	/**
	 * The constructor of View
	 * @param model
	 * 		IModel interface
	 */
	public View (IModel model) {
		this.model = model;
		this.frame = new ViewFrame(this);

	}

	/**
	 * Method to get the controller
	 * @return Controller interface
	 */
	@Override
	public IController getController() {
		return this.controller;
	}

	/**
	 * Method to get the model
	 * @return Model interface
	 */
	@Override
	public IModel getModel() {
		return this.model;
	}

	/**
	 * Method to get the observer
	 * @return Observer object
	 */
	@Override
	public Observer getObserver() {
		return this.frame.getObserver();
	}

	/**
	 * Method to set the controller
	 * @param controller
	 * 		Controller interface
	 */
	public void setController(IController controller) {
		this.controller = controller;
	}
}
