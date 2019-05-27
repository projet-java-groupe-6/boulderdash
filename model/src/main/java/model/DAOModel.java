package model;

import contract.IModel;
import contract.IScore;
import entity.MotionElement;
import entity.MotionlessElement;
import entity.object.*;
import entity.object.Character;
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

    /** Variable to choose level */
    public static int levelNumber = 1;

    /**
     * Level object
     */
    private Level level;
    private Score score;

    /**
     * Constructor of DAOModel
     */
    public DAOModel() {
    	this.loadLevel();
    	this.score = new Score();
    }

    /**
     * Method to get path of level text file
     */
    public void loadLevel() {
        Statement statement = null;
        try {
            statement = DBConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("CALL map(" + levelNumber + ");");
            resultSet.first();
            String path = resultSet.getString("path");
            this.level = new Level.LevelBuilder(path).build();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get walls
     * @return HashMap of walls associated with points
     */
	@Override
	public HashMap<Point, Wall> getWalls() {
		return this.level.getWalls();
	}

    /**
     * Method to get the character
     * @return object Character
     */
	@Override
	public Character getCharacter() {
		return this.level.getCharacter();
	}

    /**
     * Method to get the list of rocks
     * @return ArrayList of rocks
     */
	@Override
    public ArrayList<Rock> getRocks() {
        return this.level.getRocks();
    }

    /**
     * Method to get the list of diamonds
     * @return ArrayList of diamonds
     */
	@Override
	public ArrayList<Diamond> getDiamonds(){
		return this.level.getDiamonds();
	}

    /**
     * Method to get dirts
     * @return HashMap of dirts associated with points
     */
	@Override
	public HashMap<Point, Dirt> getDirts(){
		return this.level.getDirts();
	}

	@Override
	public IScore getScore() {
		return this.score;
	}

	@Override
    public HashMap<Point, Exit> getExit() {
	    return this.level.getExit();
    }
}
