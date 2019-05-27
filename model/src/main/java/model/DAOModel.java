package model;

import contract.IModel;
import entity.MotionElement;
import entity.MotionlessElement;
import entity.object.Character;
import entity.object.Diamond;
import entity.object.Dirt;
import entity.object.Rock;
import entity.object.Wall;
import model.Level.LevelBuilder;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class DAOModel
 *
 * @author clement
 */
public class DAOModel implements IModel {

    /**  */
    private static final int LEVEL = 1;
    
    private Level level;

    public DAOModel() {
    	this.loadLevel();
    }

    public void loadLevel() {
        Statement statement = null;
        try {
            statement = DBConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("CALL map(" + LEVEL + ");");
            resultSet.first();
            String path = resultSet.getString("path");
            this.level = new Level.LevelBuilder(path).build();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public HashMap<Point, Wall> getWalls() {
		return this.level.getWalls();
	}

	@Override
	public Character getCharacter() {
		return this.level.getCharacter();
	}

	@Override
    public ArrayList<Rock> getRocks() {
        return this.level.getRocks();
    }
	
	@Override
	public ArrayList<Diamond> getDiamonds(){
		return this.level.getDiamonds();
	}
	
	@Override
	public HashMap<Point, Dirt> getDirts(){
		return this.level.getDirts();
	}


}
