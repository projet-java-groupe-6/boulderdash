package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import entity.MotionElement;
import entity.MotionlessElement;
import entity.object.*;
import entity.object.Character;

/**
 * @author clement
 */
public class Level {

	/**
	 * HashMap of walls
	 */
	private HashMap<Point, Wall> walls;

	/**
	 * Object of Character
	 */
	private Character character;

	/**
	 * ArrayList of rocks
	 */
	private ArrayList<Rock> rocks;

	/**
	 * ArrayList of diamonds
	 */
	private ArrayList<Diamond> diamonds;

	/**
	 * HashMap of dirts
	 */
	private HashMap<Point, Dirt> dirts;

	private HashMap<Point, Exit> exit;

	/**
	 * The constructor of Level
	 * @param builder
	 *		LevelBuilder object from DP Builder
	 */
	private Level(LevelBuilder  builder) {
		this.walls = new HashMap<>();
		this.rocks = new ArrayList<>();
		this.diamonds = new ArrayList<>();
		this.dirts=new HashMap<>();
		this.exit = new HashMap<>();
		
		this.parseBuilder(builder);
	}

	/**
	 * Method to parse the LevelBuilder
	 * @param builder
	 * 		LevelBuilder from DP Builder
	 */
	private void parseBuilder(LevelBuilder builder) {
		String path = builder.getPath();
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
							Wall wall = new Wall();
							wall.loadImage();
							Point p = new Point(x, y);
							walls.put(p, wall);
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
							this.rocks.add(rock);
							break;
						case 'd':
							Diamond diamond = new Diamond();
							diamond.loadImage();
							diamond.setX(x);
							diamond.setY(y);
							this.diamonds.add(diamond);
							break;		
						case 't': 
							Dirt dirt = new Dirt();
							dirt.loadImage();
							Point pd = new Point(x,y);
							dirts.put(pd, dirt);
							break;
						case 'e':
							Exit e = new Exit();
							e.loadImage();
							Point exitPoint = new Point(x, y);
							this.exit.put(exitPoint, e);
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

	/**
	 * Method to get walls associated with points
	 * @return HashMap of walls
	 */
	public HashMap<Point, Wall> getWalls() {
		return walls;
	}

	/**
	 * Method to get the Character
	 * @return Character object
	 */
	public Character getCharacter() {
		return this.character;
	}

	/**
	 * Method to get the rocks
	 * @return ArrayList of rocks
	 */
	public ArrayList<Rock> getRocks() {
		return this.rocks;
	}

	/**
	 * Method to get diamonds
	 * @return ArrayList of diamonds
	 */
	public ArrayList<Diamond> getDiamonds(){
		return this.diamonds;
	}

	/**
	 * Method to get dirts
	 * @return HashMap of dirts
	 */
	public HashMap<Point, Dirt> getDirts(){
		return dirts;
	}

	public HashMap<Point, Exit> getExit() {
		return this.exit;
	}

	/**
	 * Static class LevelBuilder to create a DP Builder
	 */
	public static class LevelBuilder{

		/**
		 * the path of file
		 */
		private String path;

		/**
		 * The constructor of LevelBuilder
		 * @param path
		 * 		The path of level file
		 */
		public LevelBuilder(String path) {
			this.path = path;
		}

		/**
		 * Method to build a Level object
		 * @return Level object
		 */
		public Level build() {
			return new Level(this);
		}

		/**
		 * Method to get the path of file
		 * @return String of the path
		 */
		public String getPath() {
			return this.path;
		}
	}
}
