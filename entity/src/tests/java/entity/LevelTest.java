package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class LevelTest {
    Level level;
    String path;
    Connection cnx;
    @Before
    public void setUp() throws Exception {
        level = new Level(cnx);
        path = this.level.getPath();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testgetPath() {
        String excepted = path;
        String actual = level.getPath();
        assertEquals(excepted, actual); 
    }
}