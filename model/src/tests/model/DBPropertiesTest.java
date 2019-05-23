package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBPropertiesTest {

    private DBProperties properties;

    @Before
    public void setUp() throws Exception {
        this.properties = new DBProperties();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUrl() {
        String expected = "jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false";
        String returned = this.properties.getUrl();
        assertEquals(expected, returned);
    }

    @Test
    public void getLogin() {
    }

    @Test
    public void getPassword() {
    }
}