package view;

import contract.IModel;
import entity.MotionElement;
import entity.MotionlessElement;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ViewPanel extends JPanel implements Observer {

    private IModel model;

    private static final int IMAGE_SIZE = 16;

    public ViewPanel(IModel model) {
        this.model = model;
    }

    @Override
    public void update(Observable observable, Object o) {
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D)graphics;
        g.clearRect(0, 0, 768, 800);
        for(Map.Entry<Point, MotionlessElement> walls: this.model.getWalls().entrySet()) {
            int x = walls.getKey().x;
            int y = walls.getKey().y;
            g.drawImage(walls.getValue().getImage(), x*IMAGE_SIZE, y*IMAGE_SIZE, null);
        }
        for(MotionElement rock: this.model.getRocks()) {
            g.drawImage(rock.getImage(), rock.getX()*IMAGE_SIZE, rock.getY()*IMAGE_SIZE, null);
        }
        MotionElement character = this.model.getCharacter();
        g.drawImage(character.getImage(), character.getX()*IMAGE_SIZE, character.getY()*IMAGE_SIZE, null);
    }
}
