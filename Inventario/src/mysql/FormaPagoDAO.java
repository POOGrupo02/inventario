package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import claseshijo.FormaPago;

public class FormaPagoDAO {
	ConexionMySQL conexion = new ConexionMySQL();

	public List<FormaPago> readFormasPagos() {
		List<FormaPago> formasPagos = new ArrayList<>();
		String sql = "SELECT * from formas_pago";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				FormaPago fP = new FormaPago();
				fP.setId(rs.getInt("id_form_pag"));
				fP.setNombre(rs.getString("nombre"));
				formasPagos.add(fP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formasPagos;
	}
}
