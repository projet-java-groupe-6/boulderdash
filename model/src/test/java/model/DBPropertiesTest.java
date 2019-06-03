package model;

import model.DBProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBPropertiesTest {

    /**
     * DBProperties object
     */
    private DBProperties properties;

    /**
     * Password
     */
    String passwd;

    /**
     * Login
     */
    String login;

    /**
     * DB URL
     */
    String url;

    /**
     * Initializing DBProperties test
     * @throws Exception
     */
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

    /**
     * Test to get the url
     */
    @Test
    public void testgetUrl() {
        String excepted = url;
        String actual = this.properties.getUrl();
        assertEquals(excepted, actual);
    }

    /**
     * Test to get the login
     */
    @Test
    public void testgetLogin() {
        String excepted = login;
        String actual = this.properties.getLogin();
        assertEquals(excepted, actual);
    }

    /**
     * Test to get the password
     */
    @Test
    public void testgetPassword() {
        String excepted =passwd;
        String actual = this.properties.getPassword();
        assertEquals(excepted, actual);
    }
}