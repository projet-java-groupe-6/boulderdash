package model;

import entity.MotionElement;
import entity.MotionlessElement;

import java.util.ArrayList;

public class Model {

    private DAOLevel level;

    private ArrayList<MotionlessElement> walls;

    private ArrayList<MotionlessElement> dirts;

    private ArrayList<MotionElement> rocks;

    private ArrayList<MotionElement> diamonds;

    private ArrayList<>

    public Model() {
        this.level = new DAOLevel(DBConnection.getInstance().getConnection());
    }
}
