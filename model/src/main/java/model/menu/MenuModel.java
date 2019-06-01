package model.menu;

import contract.IAudio;
import contract.IElement;
import contract.IModel;
import contract.IScore;
import model.Audio;

import java.awt.*;
import java.util.ArrayList;

public class MenuModel implements IModel {

    /**
     * Constructor of the menu model
     */
    public MenuModel(){
    }

    @Override
    public ArrayList<IElement> getElements() {
        return null;
    }

    @Override
    public IElement getCharacter() {
        return null;
    }

    @Override
    public IScore getScore() {
        return null;
    }

    /**
     * Method to get audio interface
     * @return Audio interface
     */
    @Override
    public IAudio getAudio() {
        return Audio.getInstance();
    }
}
