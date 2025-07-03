package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import claseshijo.Marca;

public class MarcaDAO {
	ConexionMySQL conexion = new ConexionMySQL();

	public Boolean createMarca(Marca marca) {
		String sqlCreate = "INSERT INTO marcas (nombre) VALUES (?)";

		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sqlCreate)) {
			ps.setString(1, marca.getName());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Marca> readMarcas() {
		ArrayList<Marca> marcas = new ArrayList<>();
		String sql = "SELECT * from marcas";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Marca m = new Marca();
				m.setId(rs.getInt("id_marca"));
				m.setName(rs.getString("nombre"));
				m.setCreatedAt(rs.getString("created_at"));
                m.setUpdatedAt(rs.getString("updated_at"));
				marcas.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcas;
	}

	public Boolean updateMarca(Marca marca) {
		String sqlUpdate = "UPDATE marcas SET nombre = ? WHERE id_marca = ?";

		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
			ps.setString(1, marca.getName());
			ps.setInt(2, marca.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
