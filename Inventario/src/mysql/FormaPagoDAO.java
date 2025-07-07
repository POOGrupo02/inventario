package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import claseshijo.FormaPago;

public class FormaPagoDAO {
	ConexionMySQL conexion = new ConexionMySQL();
	
	public Boolean createFormaPago(FormaPago formaPago) {
        String sqlCreate = "INSERT INTO formas_pago (nombre) VALUES (?)";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlCreate)) {
            ps.setString(1, formaPago.getNombre());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public ArrayList<FormaPago> readFormasPagos() {
		ArrayList<FormaPago> formasPagos = new ArrayList<>();
        String sql = "SELECT * from formas_pago WHERE estado = 1";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                FormaPago fP = new FormaPago();
                fP.setId(rs.getInt("id_form_pag"));
                fP.setNombre(rs.getString("nombre"));
                fP.setCreatedAt(rs.getString("created_at"));
                fP.setUpdatedAt(rs.getString("updated_at"));
                formasPagos.add(fP);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return formasPagos;
    }
	
	public Boolean updateFormaPago(FormaPago formaPago) {
        String sqlUpdate = "UPDATE formas_pago SET nombre = ? WHERE id_form_pag = ?";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
            ps.setString(1, formaPago.getNombre());
            ps.setInt(2, formaPago.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public Boolean deleteFormaPago(int id) {
        String sqlUpdate = "UPDATE formas_pago SET estado = 0 WHERE id_form_pag = ?";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
