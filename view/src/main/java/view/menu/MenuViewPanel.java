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

    private JComboBox<String> comboBox;
    private JButton start;
    private BoxLayout boxLayout;

    private String[] levels;

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
