package controller.menu;

import contract.IController;
import contract.IView;
import contract.Order;
import entity.Level;

public class MenuController implements IController {

    private IView view;
    private boolean chosen;

    public MenuController(IView view) {
        this.chosen = false;
        this.view = view;
    }

    @Override
    public void orderPerform(Order order) {
        Level.levelNumber = Integer.valueOf(String.valueOf(order.getTyped()));
        this.chosen = true;
    }

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
