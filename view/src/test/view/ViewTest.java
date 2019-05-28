package view;

import contract.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Observer;

import static org.junit.Assert.*;

public class ViewTest {
    IController cont;
    View view;
    IModel model1;

    @Before
    public void setUp() throws Exception {
        this.cont = new IController() {
            @Override
            public void orderPerform(Order order) {

            }

        };
        this.model1 = new IModel() {
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
        };
        this.view = new View(this.model1);
        this.view.setController(this.cont);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getController() {
        IController actual = cont;
        IController expected= view.getController();
        assertEquals("controller test work", expected, actual);
    }

    @Test
    public void getModel() {
        IModel actual = model1;
        IModel excepted = view.getModel();
        assertEquals("model test work", excepted, actual);
    }

    @Test
    public void setController(IController cont) {
       /* IController actual = cont;
        IController excepted = view.setController(view.getController());
        assertEquals(excepted, actual);
       */
    }
}