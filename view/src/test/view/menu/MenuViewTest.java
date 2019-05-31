package view.menu;

import contract.IController;
import contract.IModel;
import contract.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuViewTest {
    MenuView menuView;
    IController controller;
    Order order;
    IModel model;

    /**
     * Initializing of MenuView test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        menuView = new MenuView();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getController() {
    }

    @Test
    public void getModel() {
    }

    @Test
    public void getObserver() {
    }

    @Test
    public void hideMenu() {
    }
}