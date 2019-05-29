/**
 * @version 1.0
 */
package main;

import controller.Controller;
import controller.menu.MenuController;
import model.Model;
import model.menu.MenuModel;
import view.View;
import view.menu.MenuView;
import view.menu.MenuViewFrame;

import javax.swing.*;

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

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        MenuModel menuModel = new MenuModel();
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView, menuModel);
        menuView.setController(menuController);

        menuController.waitFor();

        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.play();

    }
}
