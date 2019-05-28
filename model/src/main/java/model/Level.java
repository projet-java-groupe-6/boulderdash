package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;

import contract.IElement;
import model.object.*;
import model.object.Character;

/**
 * @author clement
 */
public class Level {

	private ArrayList<IElement> elements;
	private IElement character;

	/**
	 * The constructor of Level
	 * @param builder
	 *		LevelBuilder object from DP Builder
	 */
	private Level(LevelBuilder  builder) {
		this.elements = new ArrayList<>();
		
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

	public ArrayList<IElement> getElements() {
		return this.elements;
	}

	public IElement getCharacter() {
		return this.character;
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
