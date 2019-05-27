package contract;

/**
 * @author Ilyes
 */
public interface IController {

	/**
	 * method to send an order
	 * @param order
	 * 		Order object
	 */
	void orderPerform(Order order);

	/**
	 * The method to run game loop
	 */
	void play();

}
