package view.menu;

import contract.IController;
import contract.IModel;
import contract.IView;

import javax.swing.*;
import java.util.Observer;

public class MenuViewFrame extends JFrame {

    private MenuViewPanel menuViewPanel;
    private MenuView view;

    public MenuViewFrame(MenuView view) {
        super("Choose a level");
        this.view = view;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setResizable(false);
        this.menuViewPanel = new MenuViewPanel(view);
        this.setContentPane(menuViewPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
