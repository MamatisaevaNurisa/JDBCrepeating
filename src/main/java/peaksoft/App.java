package peaksoft;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws SQLException {

//        Db.connection().close();
        createTable();
    }

    public static void createTable() {
        String SQL = "CREATE TABLE studentsSchool(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50) NOT NULL," +
                "age INTEGER);";
        try (Connection connection = Db.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getCount() {
        String SQL = "SELECT count (*) FROM studentsSchool";
        int count = 0;
        try (Connection con = Db.connection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;


    }
}



}
