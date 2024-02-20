package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    static Connection conn;
    public static Connection createConn() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Student", "postgres", "Cgg@2023");
        return conn;
    }
}