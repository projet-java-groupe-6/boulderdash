package contract;

import java.util.Observer;

/**
 * @author Theo
 */
public interface IView {

	/**
	 * @return Controller interface
	 */
	IController getController();

	/**
	 * @return Model interface
	 */
	IModel getModel();

	/**
	 * @return Observer object
	 */
	Observer getObserver();

}
