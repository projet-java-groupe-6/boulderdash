package view;

import contract.IModel;
import entity.MotionlessElement;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ViewPanel extends JPanel implements Observer {

    private IModel model;

    public ViewPanel(IModel model) {
        this.model = model;
    }

    @Override
    public void update(Observable observable, Object o) {
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {

    }
}
