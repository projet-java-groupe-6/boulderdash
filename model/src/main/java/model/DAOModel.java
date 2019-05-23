package model;

import contract.IModel;
import entity.MotionElement;
import entity.MotionlessElement;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * The class DAOModel
 *
 * @author clement
 */
public class DAOModel implements IModel {

    /**  */
    private static final int LEVEL = 1;
    private HashMap<Point, MotionlessElement> walls;
    private MotionElement character;

    public DAOModel() {
    }

    public void loadLevel() {
        Statement statement = null;
        try {
            statement = DBConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("");
            while(resultSet.next()) {
                int x = resultSet.getInt("x");
                int y = resultSet.getInt("y");
                char c = resultSet.getString("element").charAt(0);
                
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public HashMap<Point, MotionlessElement> getWalls() {
		// TODO Auto-generated method stub
		return this.walls;
	}

	@Override
	public MotionElement getCharacter() {
		// TODO Auto-generated method stub
		return this.character;
	}


}
