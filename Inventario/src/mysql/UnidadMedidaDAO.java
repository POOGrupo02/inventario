package mysql;

import java.sql.*;
import java.util.ArrayList;

import claseshijo.UnidadMedida;

public class UnidadMedidaDAO {
    
    ConexionMySQL conexion = new ConexionMySQL();
    
    public Boolean createUnidadMedida(UnidadMedida unidadMedida) {
        String sqlCreate = "INSERT INTO unidades_medidas (nombre) VALUES (?)";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlCreate)) {
            ps.setString(1, unidadMedida.getName());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<UnidadMedida> readUnidadesMedidas() {
    	ArrayList<UnidadMedida> unidadesMedidas = new ArrayList<>();
        String sql = "SELECT * from unidades_medidas";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UnidadMedida um = new UnidadMedida();
                um.setId(rs.getInt("id_uni_medi"));
                um.setName(rs.getString("nombre"));
                um.setCreatedAt(rs.getString("created_at"));
                um.setUpdatedAt(rs.getString("updated_at"));
                unidadesMedidas.add(um);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unidadesMedidas;
    }

    public Boolean updateUnidadMedida(UnidadMedida unidadMedida) {
        String sqlUpdate = "UPDATE unidades_medidas SET nombre = ? WHERE id_uni_medi = ?";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
            ps.setString(1, unidadMedida.getName());
            ps.setInt(2, unidadMedida.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean deleteUniMedi(int id) {
		String sqlDelete = "DELETE FROM unidades_medidas WHERE id_uni_medi = ?";
		
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
		String sqlQuestion = "SELECT COUNT(*) FROM productos WHERE estado = 1 AND id_uni_medi = ?";

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
