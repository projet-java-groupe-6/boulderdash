package controller.menu;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Order;
import entity.Level;

public class MenuController implements IController {

    private IView view;
    private boolean chosen;
    private IModel model;

    public MenuController(IView view, IModel model) {
        this.chosen = false;
        this.view = view;
        this.model = model;
        this.model.getAudio().playSound("audio/game.wav");
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
