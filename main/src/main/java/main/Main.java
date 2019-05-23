/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

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
        final Model model = new Model();
        final BoardFrame boardFrame = new BoardFrame("BoulderDash");
        final Controller controller = new Controller(boardFrame, model);
        boardFrame.setController(controller);

        controller.play();
    }
}
