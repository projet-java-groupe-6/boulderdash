package view;

import contract.IModel;
import contract.IView;

import javax.swing.*;
import java.util.Observer;

public class ViewFrame extends JFrame {

    private ViewPanel panel;
    private IView view;

    public ViewFrame(IView v) {
        super("BoulderDash");
        this.view = v;
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(768, 800);
        this.setLocationRelativeTo(null);
        this.panel = new ViewPanel(this.view.getModel());
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public Observer getObserver() {
        return this.panel;
    }
}
