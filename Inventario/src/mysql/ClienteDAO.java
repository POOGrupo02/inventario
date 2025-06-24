package mysql;

import java.sql.*;
import java.util.ArrayList;
import claseshijo.Cliente;

public class ClienteDAO {
    ConexionMySQL conexion = new ConexionMySQL();

    private static final String SQL_SELECT =
        "SELECT id_cliente, dni, nombre, apellido, sexo, celular, created_at, updated_at FROM clientes";

    public boolean createCliente(Cliente c) {
        String sql = "INSERT INTO clientes (dni, nombre, apellido, sexo, celular) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getSexo());
            ps.setString(5, c.getCelular());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Cliente> readClientes() {
    	ArrayList<Cliente> clientes = new ArrayList<>();
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_SELECT);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                clientes.add(mapCliente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente readClienteByDni(String dni) {
        Cliente c = null;
        String sql = SQL_SELECT + " WHERE dni = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = mapCliente(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }


    public boolean updateCliente(Cliente c) {
        String sql = "UPDATE clientes SET dni = ?, nombre = ?, apellido = ?, sexo = ?, celular = ? WHERE id_cliente = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getSexo());
            ps.setString(5, c.getCelular());
            ps.setInt(6, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Cliente mapCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
        c.setId(rs.getInt("id_cliente"));
        c.setDni(rs.getString("dni"));
        c.setNombre(rs.getString("nombre"));
        c.setApellido(rs.getString("apellido"));
        c.setSexo(rs.getString("sexo"));
        c.setCelular(rs.getString("celular"));
        c.setCreatedAt(String.valueOf(rs.getTimestamp("created_at")));
        c.setUpdatedAt(String.valueOf(rs.getTimestamp("updated_at")));
        return c;
    }
}
