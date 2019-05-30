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
	Connection cnx;
	DBConnection dbcnx;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dbcnx= new DBConnection();
		this.cnx=dbcnx.getConnection();
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testgetConnection() {
        Connection excepted = cnx;
		Connection actual = this.dbcnx.getConnection();
		assertEquals(excepted, actual);
	}
}
