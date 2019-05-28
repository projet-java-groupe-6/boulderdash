package model;

import contract.IElement;
import contract.IScore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ModelTest {
    Model model;
    IElement elm;
    IScore scr;
    ArrayList<IElement> list;


    @Before
    public void setUp() throws Exception {
        model = new Model();
        this.elm=model.getCharacter();
        this.scr=model.getScore();
        this.list=model.getElements();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getElements() {
        ArrayList<IElement> actual = list;
        ArrayList<IElement> excepted = model.getElements();
        assertEquals(excepted, actual);
    }

    @Test
    public void getCharacter() {
        IElement actual = elm;
        IElement excepted = model.getCharacter();
        assertEquals(excepted, actual);
    }

    @Test
    public void getScore() {
        IScore actual = scr;
        IScore excepted = model.getScore();
        assertEquals(excepted, actual);
    }
}