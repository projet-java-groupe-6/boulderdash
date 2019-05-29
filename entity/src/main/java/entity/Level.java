package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Level {

    /**
     * Connection instance
     */
    private Connection connection;

    /**
     * level map number 
     */
    public static int levelNumber = 2;

    /**
     * The Constructor of Level
     * @param connection
     *      dataBased Connection
     */
    public Level(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method to get the path of the map
     * @return the path of the map
     */
    public String getPath() {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("CALL map(" + levelNumber + ");");
            resultSet.first();

            String path = resultSet.getString("path");
            return path;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
