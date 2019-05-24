package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import entity.MotionElement;
import entity.MotionlessElement;
import entity.object.Character;
import entity.object.Diamond;
import entity.object.Rock;

public class Level {
	
	private HashMap<Point, MotionlessElement> walls;
	
	
	private Character character;
	
	private ArrayList<Rock> rocks;
	private ArrayList<Diamond> diamonds;
	
	private Level(LevelBuilder  builder) {
		this.walls = new HashMap<>();
		this.rocks = new ArrayList<>();
		this.diamonds = new ArrayList<>();
		this.parseBuilder(builder);
	}
	
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
							MotionlessElement wall = new MotionlessElement("wall.png");
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
					}
					
				}
				y++;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<Point, MotionlessElement> getWalls() {
		return walls;
	}

	public Character getCharacter() {
		return this.character;
	}

	public ArrayList<Rock> getRocks() {
		return this.rocks;
	}

	public ArrayList<MotionElement> getDiamonds(){
		return this.diamonds;
	}


	public static class LevelBuilder{
		
		private String path;
		
		public LevelBuilder(String path) {
			this.path = path;
		}
		
		public Level build() {
			return new Level(this);
		}
		
		public String getPath() {
			return this.path;
		}
	}
}
