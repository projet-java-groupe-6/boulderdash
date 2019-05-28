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

    @Override
    public IController getController() {
        return this.controller;
    }

    @Override
    public IModel getModel() {
        return null;
    }

    @Override
    public Observer getObserver() {
        return null;
    }

    public void hideMenu() {
        this.menuViewFrame.setVisible(false);
    }
}
