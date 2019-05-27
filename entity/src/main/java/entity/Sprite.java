package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;

/**
 * @author clement
 */
public abstract class Sprite extends Observable {

    /**
     * the file name of image
     */
    private String filename;

    /**
     * The image object
     */
    private Image image;

    /**
     * The constructor of Sprite
     * @param filename
     *      The file name of the image
     */
    public Sprite(String filename) {
        this.filename = filename;
    }

    /**
     * Method to get the file name
     * @return String of the file name
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Method to get the image object
     * @return Image of the sprite
     */
    public Image getImage() {
        return this.image;
    }
    public Image getImageCharacter(){

        return this.image;
    }

    /**
     * Method to initialize the image from the file name
     */
    public void loadImage() {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(this.getFilename()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to set the file name
     * @param filename
     *      String of the file name
     */
	public void setFilename(String filename) {
		this.filename = filename;
	}
    
}
