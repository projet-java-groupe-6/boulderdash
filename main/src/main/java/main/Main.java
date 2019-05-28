/**
 * @version 1.0
 */
package main;

import controller.Controller;
import controller.menu.MenuController;
import model.Model;
import view.View;
import view.menu.MenuView;
import view.menu.MenuViewFrame;

/**
 * The Class Main.
 *
 * @author clement, Ilyes and Theo
 */
public abstract class Main {
	
	
    /**(
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {

        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);
        menuView.setController(menuController);

        menuController.waitFor();

        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.play();

    }
}
