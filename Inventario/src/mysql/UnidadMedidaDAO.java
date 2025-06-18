package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClasesHijo.UnidadMedida;

public class UnidadMedidaDAO {
	
	ConexionMySQL conexion = new ConexionMySQL();
	
	public List<UnidadMedida> listarUnidadesMedidas() {
        List<UnidadMedida> unidadMedida = new ArrayList<>();
        String sql = "SELECT * from unidades_medidas";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	UnidadMedida pr = new UnidadMedida();
            	pr.setId(rs.getInt("id_uni_medi"));
            	pr.setName(rs.getString("nombre"));
            	unidadMedida.add(pr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unidadMedida;
    }

}
