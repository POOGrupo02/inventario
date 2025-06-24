package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import claseshijo.Presentacion;

public class PresentacionDAO {

	ConexionMySQL conexion = new ConexionMySQL();

	public Boolean createPresentacion(Presentacion presentacion) {
		String sqlCreate = "INSERT INTO presentaciones (nombre) VALUES (?)";

		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sqlCreate)) {
			ps.setString(1, presentacion.getName());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Presentacion> readPresentaciones() {
		ArrayList<Presentacion> presentaciones = new ArrayList<>();
		String sql = "SELECT * from presentaciones";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Presentacion pr = new Presentacion();
				pr.setId(rs.getInt("id_present"));
				pr.setName(rs.getString("nombre"));
				presentaciones.add(pr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return presentaciones;
	}

	public Boolean updatePresentacion(Presentacion presentacion) {
		String sqlUpdate = "UPDATE presentaciones SET nombre = ? WHERE id_present = ?";

		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
			ps.setString(1, presentacion.getName());
			ps.setInt(2, presentacion.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
