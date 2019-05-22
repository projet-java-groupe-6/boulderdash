package entity;

public class MotionElement extends Sprite {

    private int x;
    private int y;

    public MotionElement(String filename) {
        super(filename);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
