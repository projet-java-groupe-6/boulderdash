package view.menu;

import contract.IController;
import contract.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MenuViewPanel extends JPanel {

    /**
     * menu to show levels
     */
    private JComboBox<String> comboBox;

    /**
     * Button to start game
     */
    private JButton start;

    /**
     * Window layout
     */
    private BoxLayout boxLayout;

    /**
     * The list of levels
     */
    private String[] levels;

    /**
     * The MenuViewPanel constructor
     * @param view
     *      view instance
     */
    public MenuViewPanel(MenuView view) {
        this.boxLayout = new BoxLayout(this, BoxLayout.LINE_AXIS);
        this.setLayout(this.boxLayout);
        this.levels = new String[] {"level 1", "level 2", "level 3", "level 4", "level 5", "level 6"};
        this.comboBox = new JComboBox<>(this.levels);
        this.start = new JButton("Start");
        this.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Order order = null;
                order = new Order(levels[comboBox.getSelectedIndex()].replace("level ", "").charAt(0));
                view.getController().orderPerform(order);
                view.hideMenu();
            }
        });
        this.add(this.comboBox);
        this.add(this.start);
    }
}
