package contract;

/**
 * Clement, Ilyes
 */
public class Order {

	/**
	 * char typed on the keyboard
	 */
	char typed;

	/**
	 * Constructor of the Order
	 * @param typed
	 * 		typed char
	 */
	public Order (char typed) {
		this.typed=typed;
	}

	/**
	 * Method to get the typed char
	 * @return char typed on the keyboard
	 */
	public char getTyped() {
		return typed;
	}

	/**
	 * @param typed
	 * 		set the typed char
	 */
	public void setTyped(char typed) {
		this.typed = typed;
	}

}
