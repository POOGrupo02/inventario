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

	public List<FormaPago> readFormasPagos() {
        List<FormaPago> formasPagos = new ArrayList<>();
        String sql = "SELECT * from formas_pago WHERE estado = TRUE";

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
        String sqlDelete = "UPDATE formas_pago SET estado = FALSE WHERE id_form_pag = ?";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlDelete)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
