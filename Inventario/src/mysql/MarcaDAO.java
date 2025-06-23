package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import claseshijo.Marca;

public class MarcaDAO {
	ConexionMySQL conexion = new ConexionMySQL();

	public List<Marca> listarMarcas() {
		List<Marca> marca = new ArrayList<>();
		String sql = "SELECT * from marcas";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Marca m = new Marca();
				m.setId(rs.getInt("id_marca"));
				m.setName(rs.getString("nombre"));
				marca.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marca;
	}

}
