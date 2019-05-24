package view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IController;
import contract.IModel;

public class ViewFrameTest {
	private ViewFrame fr;
	private IModel model;
	private View view;
	private IController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fr = new ViewFrame(view);
	}

	@After
	public void tearDown() throws Exception {
	}

    @Test
    public void testKeyPressed() throws Exception {
    	char key1 = 0 ;
        KeyEvent event = null; 
        fr.keyPressed(event); 
        assertEquals(event.getKeyChar(), key1 );
    }
	

}
