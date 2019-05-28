package view;

import contract.IController;
import contract.IModel;
import contract.IView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Observer;

import static org.junit.Assert.*;

public class ViewFrameTest {
    ViewPanel viewPanel;
    IView view;

    @Before
    public void setUp() throws Exception {
        view = new IView() {
            @Override
            public IController getController() {
                return null;
            }

            @Override
            public IModel getModel() {
                return null;
            }

            @Override
            public Observer getObserver() {
                return null;
            }
        };
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getObserver() {
    }

    @Test
    public void keyPressed() {
    }

    @Test
    public void keyReleased() {
    }

    @Test
    public void keyTyped() {
    }
}