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
        ArrayList<IElement> excepted = list;
        ArrayList<IElement> actual = model.getElements();
        assertEquals(excepted, actual);
    }

    @Test
    public void testgetCharacter() {
        IElement excepted = elm;
        IElement actual = model.getCharacter();
        assertEquals(excepted, actual);
    }

    @Test
    public void testgetScore() {
        IScore excepted = scr;
        IScore actual = model.getScore();
        assertEquals(excepted, actual);
    }
}