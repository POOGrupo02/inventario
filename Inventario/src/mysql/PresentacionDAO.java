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
				pr.setCreatedAt(rs.getString("created_at"));
                pr.setUpdatedAt(rs.getString("updated_at"));
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
	
	public Boolean deletePresentacion(int id) {
		String sqlDelete = "DELETE FROM presentaciones WHERE id_present = ?";
		
		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sqlDelete)) {
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean isUsed(int id) {
		String sqlQuestion = "SELECT COUNT(*) FROM productos WHERE estado = 1 AND id_present = ?";

		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sqlQuestion)) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
