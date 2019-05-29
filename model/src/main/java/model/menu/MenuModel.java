package model.menu;

import contract.IAudio;
import contract.IElement;
import contract.IModel;
import contract.IScore;
import model.Audio;

import java.awt.*;
import java.util.ArrayList;

public class MenuModel implements IModel {

    IAudio clip;

    public MenuModel(){
        this.clip = new Audio("audio/game.wav");
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

    @Override
    public IAudio getAudio() {
        return this.clip;
    }
}
