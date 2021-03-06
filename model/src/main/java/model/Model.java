package model;

import contract.IAudio;
import contract.IElement;
import contract.IModel;
import contract.IScore;
import entity.Level;
import model.object.*;
import model.object.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * The class Model
 *
 * @author clement
 */
public class Model implements IModel {

    /**
     * Score
     */
    private Score score;

    /**
     * Level
     */
    private Level level;

    /**
     * ArrayList of elements
     */
    private ArrayList<IElement> elements; //List for different elements

    /**
     * Character
     */
    private IElement character;


    /**
     * Constructor of Model
     */
    public Model() {
        this.elements = new ArrayList<>();
    	this.score = new Score();
    	this.level = new Level(DBConnection.getInstance().getConnection()); // access to the data base
    	this.parse(this.level.getPath()); // getting the path the level chosen
    }

    /**
     * Method to parse the LevelBuilder
     * @param path
     * 		LevelBuilder from DP Builder
     */
    private void parse(String path) {
        // reading the text file located in path
        BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(path)));
        String line; // to read each line of the text file
        int y = 0; // browse all the lines
        //recovery of elements from the text file according to the letters
        try {
            while((line = in.readLine()) != null) {
                int length = line.length(); // length of every line in the file txt
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
                        case 'x':
                            Enemy enemy = new Enemy();
                            enemy.loadImage();
                            enemy.setX(x);
                            enemy.setY(y);
                            elements.add(enemy);
                            break;

                    }

                }
                y++; // next line
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method to get the elements
     * @return elements
     */
    @Override
    public ArrayList<IElement> getElements() {
        return this.elements;
    }

    /**
     * Method to get the character
     * @return character
     */
    @Override
    public IElement getCharacter() {
        return this.character;
    }

    /**
     * Method to get the score
     * @return score
     */
    @Override
    public IScore getScore() {
        return this.score;
    }

    /**
     * Method to get the audio
     * @return instance of audio
     */
    @Override
    public IAudio getAudio() {
        return Audio.getInstance();
    }



}
