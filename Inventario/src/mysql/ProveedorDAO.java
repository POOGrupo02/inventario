package mysql;

import java.sql.*;
import java.util.ArrayList;

import claseshijo.Proveedor;

public class ProveedorDAO {
    ConexionMySQL conexion = new ConexionMySQL();

    private static final String SQL_SELECT = 
        "SELECT id_proveedor, ruc, nombre_empresa, nombre_contacto, apellido_contacto, " +
        "telefono, email, via, nombre_via, numero_via, referencia, estado, created_at, updated_at " +
        "FROM proveedores WHERE estado = TRUE ";

    public boolean createProveedor(Proveedor p) {
        String sql = "INSERT INTO proveedores (ruc, nombre_empresa, nombre_contacto, apellido_contacto, telefono, email, " +
                     "via, nombre_via, numero_via, referencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getRuc());
            ps.setString(2, p.getNombreEmpresa());
            ps.setString(3, p.getNombreContacto());
            ps.setString(4, p.getApellidoContacto());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getEmail());
            ps.setString(7, p.getVia());
            ps.setString(8, p.getNombreVia());
            ps.setString(9, p.getNumeroVia());
            ps.setString(10, p.getReferencia());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Proveedor> readProveedores() {
    	ArrayList<Proveedor> proveedores = new ArrayList<>();
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_SELECT);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	proveedores.add(mapProveedor(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    public Proveedor readProveedorByRuc(String ruc) {
        Proveedor p = null;
        String sql = SQL_SELECT + "AND ruc = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ruc);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = mapProveedor(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean updateProveedor(Proveedor p) {
        String sql = "UPDATE proveedores SET ruc = ?, nombre_empresa = ?, nombre_contacto = ?, apellido_contacto = ?, " +
                     "telefono = ?, email = ?, via = ?, nombre_via = ?, numero_via = ?, referencia = ? " +
                     "WHERE id_proveedor = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getRuc());
            ps.setString(2, p.getNombreEmpresa());
            ps.setString(3, p.getNombreContacto());
            ps.setString(4, p.getApellidoContacto());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getEmail());
            ps.setString(7, p.getVia());
            ps.setString(8, p.getNombreVia());
            ps.setString(9, p.getNumeroVia());
            ps.setString(10, p.getReferencia());
            ps.setInt(11, p.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProveedor(int id) {
    	String sql = "UPDATE proveedores SET estado = FALSE WHERE id_proveedor = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean exitsOnBd(String ruc) {
		String sqlQuestion = "SELECT * FROM proveedores where ruc = ?";
		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlQuestion)) {
			
			ps.setString(1,ruc);
			
			try(ResultSet rs = ps.executeQuery();){
				if (rs.next()) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

    private Proveedor mapProveedor(ResultSet rs) throws SQLException {
        Proveedor p = new Proveedor();
        p.setId(rs.getInt("id_proveedor"));
        p.setRuc(rs.getString("ruc"));
        p.setNombreEmpresa(rs.getString("nombre_empresa"));
        p.setNombreContacto(rs.getString("nombre_contacto"));
        p.setApellidoContacto(rs.getString("apellido_contacto"));
        p.setTelefono(rs.getString("telefono"));
        p.setEmail(rs.getString("email"));
        p.setVia(rs.getString("via"));
        p.setNombreVia(rs.getString("nombre_via"));
        p.setNumeroVia(rs.getString("numero_via"));
        p.setReferencia(rs.getString("referencia"));
        p.setCreatedAt(String.valueOf(rs.getTimestamp("created_at")));
        p.setUpdatedAt(String.valueOf(rs.getTimestamp("updated_at")));
        return p;
    }
}
