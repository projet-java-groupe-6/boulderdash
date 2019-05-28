package contract;

import java.util.Observer;

public interface IElement {
    int getX();
    int getY();
    void setX(int x);
    Permeability getPermeability();
    void setY(int y);
    boolean canFall();
    boolean canCrossSemiBlocking();
    Image getImage();
    void setObserver (Observer observer);
}
