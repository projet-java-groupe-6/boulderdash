package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The class DAOLevel
 *
 * @author clement
 */
public class DAOLevel {

    /**  */
    private static final int LEVEL = 1;

    private Connection connection;



    public DAOLevel(Connection connection) {
        this.connection = connection;
    }

    private void loadLevel() {
        Statement statement = null;
        try {
            statement = connection.createStatement();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
