package model;

import contract.IElement;
import contract.IModel;
import contract.IScore;
import model.object.*;
import model.object.Character;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;

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
    	this.score = new Score();
    	this.loadLevel();
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

    @Override
    public ArrayList<IElement> getElements() {
        return this.level.getElements();
    }

    @Override
    public IElement getCharacter() {
        return this.level.getCharacter();
    }

    @Override
    public IScore getScore() {
        return this.score;
    }
}
