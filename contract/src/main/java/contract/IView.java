package contract;

import java.util.Observer;

public interface IView {
	IController getController();
	IModel getModel();
	Observer getObserver();

}
