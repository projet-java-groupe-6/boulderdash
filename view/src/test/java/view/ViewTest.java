package view;

import contract.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Observer;

import static org.junit.Assert.*;

public class ViewTest {

    /**
     * Controller interface
     */
    IController cont;

    /**
     * View object
     */
    View view;

    /**
     * Model interface
     */
    IModel model1;

    /**
     * Initializing View test
     * @throws Exception
     */
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

            @Override
            public IAudio getAudio() {
                return null;
            }




        };
        this.view = new View(this.model1);
        this.view.setController(this.cont);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test to get the controller
     */
    @Test
    public void testgetController() {
        IController excepted = cont;
        IController actual= view.getController();
        assertEquals("controller test work", excepted, actual);
    }

    /**
     * Test to get the model
     */
    @Test
    public void testgetModel() {
        IModel excepted = model1;
        IModel actual = view.getModel();
        assertEquals("model test work", excepted, actual);
    }

    @Test
    public void testsetController() {

    }
}