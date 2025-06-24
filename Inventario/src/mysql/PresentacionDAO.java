package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import claseshijo.Presentacion;

public class PresentacionDAO {
	
	ConexionMySQL conexion = new ConexionMySQL();
	
	public List<Presentacion> readPresentaciones() {
        List<Presentacion> presentacion = new ArrayList<>();
        String sql = "SELECT * from presentaciones";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	Presentacion pr = new Presentacion();
            	pr.setId(rs.getInt("id_present"));
            	pr.setName(rs.getString("nombre"));
            	presentacion.add(pr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return presentacion;
    }

}
