package contract;

import java.util.Observer;

/**
 * @author Theo
 */
public interface IView {

	/**
	 * Method to get controller
	 * @return Controller interface
	 */
	IController getController();

	/**
	 * Method to get model
	 * @return Model interface
	 */
	IModel getModel();

	/**
	 * Method to get observer
	 * @return Observer object
	 */
	Observer getObserver();

}
