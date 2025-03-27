package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_TYPE = "MSSQL"; // Możesz zmienić na "MYSQL"
    
    private static final String MSSQL_URL = "jdbc:sqlserver://localhost;databaseName=Uczelnia";
    private static final String MSSQL_USER = "sa";
    private static final String MSSQL_PASSWORD = "student";

    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/uczelnia";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (DB_TYPE.equals("MSSQL")) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(MSSQL_URL, MSSQL_USER, MSSQL_PASSWORD);
        } else if (DB_TYPE.equals("MYSQL")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
        } else {
            throw new SQLException("Niepoprawny typ bazy danych.");
        }
    }
}