package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean registrarUsuario(String usuario, String contrasena) {
        String sql = "INSERT INTO usuarios (nombre_usuario, contrasena) VALUES (?, ?)";

        try (Connection con = new ConexionMySQL().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, contrasena);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeUsuario(String usuario) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE nombre_usuario = ?";

        try (Connection con = new ConexionMySQL().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

  
    public boolean validarUsuario(String usuario, String contrasena) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";

        try (Connection con = new ConexionMySQL().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



}

    
   



