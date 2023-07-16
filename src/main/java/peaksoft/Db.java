package peaksoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private static final String URL = "jdbc:postgresql://localhost:5432/school";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "postgres";

public static Connection connection(){

    Connection connection = null;
    try{
        connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        System.out.println("Connected to the postgresql");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
return connection;



}
}
