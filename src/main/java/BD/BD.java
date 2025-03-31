package BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
    private Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/kutxabank";
            String user = "root"; String password = "usbw";
            connection = DriverManager.getConnection(url, user, password);

        }catch (Exception e) {
            System.out.println("ERROR GENERAL: "  +e.getMessage());
        }
        return connection;
    }
}
