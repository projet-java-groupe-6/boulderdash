package view;

import contract.IModel;
import entity.MotionElement;
import entity.MotionlessElement;
import entity.object.Diamond;
import entity.object.Rock;
import entity.object.Wall;
import entity.object.Character;

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
        g.scale(4, 4);
        for(Map.Entry<Point, Wall> walls: this.model.getWalls().entrySet()) {
            int x = walls.getKey().x;
            int y = walls.getKey().y;
            g.drawImage(walls.getValue().getImage(), x*IMAGE_SIZE, y*IMAGE_SIZE, null);
        }
        for(Rock rock: this.model.getRocks()) {
            g.drawImage(rock.getImage(), rock.getX()*IMAGE_SIZE, rock.getY()*IMAGE_SIZE, null);
        }
        for(Diamond diamond: this.model.getDiamonds()) {
            g.drawImage(diamond.getImage(), diamond.getX()*IMAGE_SIZE, diamond.getY()*IMAGE_SIZE, null);
        }
        Character character = this.model.getCharacter();
        g.drawImage(character.getImage(), character.getX()*IMAGE_SIZE, character.getY()*IMAGE_SIZE, null);
    }
}
