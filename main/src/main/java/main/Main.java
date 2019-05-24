/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import controller.Controller;
import model.DAOModel;
import view.View;
import view.ViewFrame;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final DAOModel model = new DAOModel();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.play();
    }
}
