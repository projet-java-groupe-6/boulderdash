package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public abstract class Sprite {

    private String filename;
    private Image image;

    public Sprite(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public Image getImage() {
        return this.image;
    }

    public void loadImage() {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(this.getFilename()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
