package mvc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private final String driver;
    private final String dbName;
    private final String connectionURL;
    private final String ssl;
    private final String username;
    private final String password;

    public DatabaseConnection() {
        driver = "org.postgresql.Driver";
        connectionURL = "jdbc:postgresql://localhost:5432/";
        dbName = "NUTRILAND";
        ssl = "?autoReconnect=true&useSSL=false";
        username = "postgres";
        password = "";
    }

    public Connection getConnection() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(connectionURL + dbName + ssl, username, password);
    }

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        try {
            Connection conn = db.getConnection();
            if (conn != null)
                System.out.println("Database successfully connected!");
            else
                System.out.println("Connection failed!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
