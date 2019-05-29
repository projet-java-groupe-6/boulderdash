package controller.menu;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Order;
import entity.Level;

public class MenuController implements IController {

    /**
     * menu view interface
     */
    private IView view;

    /**
     * boolean to wait for user to choose level
     */
    private boolean chosen;


    private IModel model;

    /**
     * Constructor of MenuController
     * @param view
     *      view interfaces
     */
    public MenuController(IView view, IModel model) {
        this.chosen = false;
        this.view = view;
        this.model = model;
        this.model.getAudio().playSound("audio/game.wav");
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
