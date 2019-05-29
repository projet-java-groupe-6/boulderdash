package controller.menu;

import contract.IController;
import contract.IView;
import contract.Order;
import entity.Level;

public class MenuController implements IController {

    private IView view;
    private boolean chosen;

    /**
     * Constructor of MenuController
     * @param view
     *      view interfaces
     */
    public MenuController(IView view) {
        this.chosen = false;
        this.view = view;
    }

    /**
     * Perform Order
     * @param order
     *      order instance
     */
    @Override
    public void orderPerform(Order order) {
        Level.levelNumber = Integer.valueOf(String.valueOf(order.getTyped()));
        this.chosen = true;
    }

    /**
     * Method to wait
     */
    public void waitFor() {
        while(!chosen) {
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
