package entity.object;

import entity.DirtState;
import entity.MotionlessElement;

public class Dirt extends MotionlessElement {   
	
	private DirtState dirtState;
	
	public Dirt() {
		super ("dirt_undug.png");
		
	}

	public void setDirtState(DirtState dirtState) {
		this.dirtState = dirtState;
		switch (dirtState) {
		case UNDUG :
			this.setFilename("dirt_undug.png");
			break;
		case DUG:
			this.setFilename("dirt_dug.png");
			break;
		}
		this.loadImage();
		this.setChanged();
		this.notifyObservers();
	}
}
