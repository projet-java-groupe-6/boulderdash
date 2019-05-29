package view.menu;

import contract.IController;
import contract.IModel;
import contract.IView;

import java.util.Observer;

public class MenuView implements IView {

    private IController controller;
    private MenuViewFrame menuViewFrame;

    public MenuView() {
        this.menuViewFrame = new MenuViewFrame(this);
    }

    public void setController(IController controller) {
        this.controller = controller;
    }


    /**
     * Method to get the Controller
     * @return controller
     */
    @Override
    public IController getController() {
        return this.controller;
    }

    /**
     * Method to get the model
     * @return null
     */
    @Override
    public IModel getModel() {
        return null;
    }

    /**
     * Method to get observer
     * @return null
     */
    @Override
    public Observer getObserver() {
        return null;
    }

    /**
     * Method to hide level menu
     */
    public void hideMenu() {
        this.menuViewFrame.setVisible(false);
    }
}
