package model;

import contract.IElement;
import contract.IModel;
import contract.IScore;
import entity.Level;
import model.object.*;
import model.object.Character;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;

/**
 * The class Model
 *
 * @author clement
 */
public class Model implements IModel {


    private Score score;

    private Level level;

    private ArrayList<IElement> elements;
    private IElement character;

    /**
     * Constructor of Model
     */
    public Model() {
        this.elements = new ArrayList<>();
    	this.score = new Score();
    	this.level = new Level(DBConnection.getInstance().getConnection());
    	this.parse(this.level.getPath());
    }

    /**
     * Method to parse the LevelBuilder
     * @param path
     * 		LevelBuilder from DP Builder
     */
    private void parse(String path) {
        BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(path)));
        String line;
        int y = 0;
        try {
            while((line = in.readLine()) != null) {
                int length = line.length();
                for(int x = 0; x < length; x++) {
                    char c = line.charAt(x);
                    switch(c) {
                        case 'w':
                            Wall wall = new Wall(x, y);
                            wall.loadImage();
                            elements.add(wall);
                            break;
                        case 'c':
                            Character character = new Character();
                            character.loadImage();
                            character.setX(x);
                            character.setY(y);
                            this.character = character;
                            break;
                        case 'r':
                            Rock rock = new Rock();
                            rock.loadImage();
                            rock.setX(x);
                            rock.setY(y);
                            elements.add(rock);
                            break;
                        case 'd':
                            Diamond diamond = new Diamond();
                            diamond.loadImage();
                            diamond.setX(x);
                            diamond.setY(y);
                            elements.add(diamond);
                            break;
                        case 't':
                            Dirt dirt = new Dirt(x, y);
                            dirt.loadImage();
                            elements.add(dirt);
                            break;
                        case 'e':
                            Exit e = new Exit(x, y);
                            e.loadImage();
                            elements.add(e);
                            break;

                    }

                }
                y++;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<IElement> getElements() {
        return this.elements;
    }

    @Override
    public IElement getCharacter() {
        return this.character;
    }

    @Override
    public IScore getScore() {
        return this.score;
    }
}
