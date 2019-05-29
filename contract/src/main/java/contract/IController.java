package contract;

/**
 * @author Ilyes
 */
public interface IController {

	/**
	 * Method to send an order
	 * @param order
	 * 		Order object
	 */
	void orderPerform(Order order);

}
