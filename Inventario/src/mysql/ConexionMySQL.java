package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
	private static String usuario = "grupodos";
	private static String password = "Instituto#3*.";
	private static String url = "jdbc:mysql://database-grupo-2.cdsgig0uuwqs.us-east-2.rds.amazonaws.com/Inventario";
	
	public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
