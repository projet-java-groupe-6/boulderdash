package model;

import static org.junit.Assert.*;

import model.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;

public class DBConnectionTest {

	/**
	 * Connection object
	 */
	Connection cnx;

	/**
	 * DBConnection instance
	 */
	DBConnection dbcnx;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Initializing DBConnection test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dbcnx= new DBConnection();
		this.cnx=dbcnx.getConnection();
	}

	@After
	public void tearDown() throws Exception {
	}


	/**
	 * Test of the connection
	 */
	@Test
	public void testgetConnection() {
        Connection excepted = cnx;
		Connection actual = this.dbcnx.getConnection();
		assertEquals(excepted, actual);
	}
}
