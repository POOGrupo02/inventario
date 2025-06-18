package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
	private static String usuario = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql://localhost:3306/inventario";
	
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
