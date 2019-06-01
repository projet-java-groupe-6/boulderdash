package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import static org.junit.Assert.*;

public class LevelTest {
    Level level;
    String path;
    Connection cnx;
    @Before
    public void setUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.cnx = DriverManager.getConnection("jdbc:mysql://clemvicart.fr:3307/projet?autoReconnect=true&useSSL=false",
                "projet", "projet");
        Level.levelNumber = 1;
        level = new Level(cnx);
        path = this.level.getPath();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testgetPath() {
        String excepted = "map/map1.txt";
        String actual = level.getPath();
        assertEquals(excepted, actual);
    }
}