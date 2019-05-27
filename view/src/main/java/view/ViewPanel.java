package view;

import contract.IModel;
import entity.MotionElement;
import entity.MotionlessElement;
import entity.object.Diamond;
import entity.object.Dirt;
import entity.object.Rock;
import entity.object.Wall;
import entity.object.Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * @author clement
 */
public class ViewPanel extends JPanel implements Observer {

    /**
     * Model interface
     */
    private IModel model;

    /**
     * Static variable pointing to size of images
     */
    private static final int IMAGE_SIZE = 16;
    

    private Font police;     

    /**
     * The constructor of ViewPanel
     * @param model
     *      Model interface
     */
    public ViewPanel(IModel model) {
        this.model = model;
        police = new Font("Arial", Font.PLAIN, 12);
        this.setBackground(Color.black);
    }

    /**
     * The method to update (DP Observer)
     * @param observable
     *      Observable object
     * @param o
     */
    @Override
    public void update(Observable observable, Object o) {
        this.repaint();
    }

    /**
     * Method to paint the panel
     * @param graphics
     *      Graphics object to paint
     */
    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D)graphics;
        g.clearRect(0, 0, 768, 800);

        g.scale(4, 4);
        g.translate(-this.model.getCharacter().getX()*IMAGE_SIZE+5*IMAGE_SIZE, -this.model.getCharacter().getY()*IMAGE_SIZE+5*IMAGE_SIZE);

        Image dirtImage = null;
        try {
            dirtImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("dirt_dug.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for(int x = 0; x < 50; x++) {
            for(int y = 0; y < 22; y++) {
                g.drawImage(dirtImage, x*IMAGE_SIZE, y*IMAGE_SIZE, null);
            }
        }

        for(Map.Entry<Point, Dirt> dirt: this.model.getDirts().entrySet()) {
            int x = dirt.getKey().x;
            int y = dirt.getKey().y;
            g.drawImage(dirt.getValue().getImage(), x*IMAGE_SIZE, y*IMAGE_SIZE, null);
        }

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
        
        g.setFont(police);
        g.setColor(Color.black);
        g.drawString(this.model.getScore().getScore() + " / 20", character.getX()*IMAGE_SIZE-5*IMAGE_SIZE, character.getY()*IMAGE_SIZE-4*IMAGE_SIZE);
    }
}
