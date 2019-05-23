package model;

import contract.IModel;
import entity.MotionElement;
import entity.MotionlessElement;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The class DAOModel
 *
 * @author clement
 */
public class DAOModel implements IModel {

    /**  */
    private static final int LEVEL = 1;

    public DAOModel() {
    }

    public void loadLevel() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("");
            while(resultSet.next()) {
                int x = resultSet.getInt("x");
                int y = resultSet.getInt("y");
                char c = resultSet.getString("element").charAt(0);
                switch (c) {
                    case 'd':
                        MotionlessElement element = new MotionlessElement("dirt.png");
                        element.loadImage();
                        model.getDirts().put(new Point(x, y), element);
                        break;
                    case 'r':
                        MotionElement rock = new MotionElement("rock.png");
                        rock.loadImage();
                        model.getRocks().add(rock);
                        break;
                    case 'c':
                        MotionElement character = new MotionElement("character.png");
                        character.loadImage();
                        model.setCharacter(character);
                        break;
                    case 'w':
                        MotionlessElement walls = new MotionlessElement("wall.png");
                        walls.loadImage();
                        model.getWalls().put(new Point(x, y), walls);
                        break;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
