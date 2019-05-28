package model;

import model.DBProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBPropertiesTest {

    private DBProperties properties;
    String passwd;
    String login;
    String url;

    @Before
    public void setUp() throws Exception {
        this.properties = new DBProperties();
        this.passwd="projet";
        this.login="projet";
        this.url="jdbc:mysql://clemvicart.fr:3307/projet?autoReconnect=true&useSSL=false";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testgetUrl() {
        String actual = url;
        String expected = this.properties.getUrl();
        assertEquals(expected, actual);
    }

    @Test
    public void testgetLogin() {
        String actual = login;
        String excepted = this.properties.getLogin();
        assertEquals(excepted, actual);
    }

    @Test
    public void testgetPassword() {
        String actual =passwd;
        String excepted = this.properties.getPassword();
        assertEquals(excepted, actual);
    }
}