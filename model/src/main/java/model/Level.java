package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import entity.MotionElement;
import entity.MotionlessElement;

public class Level {
	
	private HashMap<Point, MotionlessElement> walls;
	
	private MotionElement character;
	
	private Level(LevelBuilder  builder) {
		this.walls = new HashMap<>();
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
							MotionElement character = new MotionElement("character.png");
							character.loadImage();
							character.setX(x);
							character.setY(y);
							this.character = character;
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

	public MotionElement getCharacter() {
		return this.character;
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