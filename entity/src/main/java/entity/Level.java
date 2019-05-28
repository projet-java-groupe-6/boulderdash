package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Level {

    private Connection connection;

    public static int levelNumber = 2;

    public Level(Connection connection) {
        this.connection = connection;
    }

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
