package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ClasesHijo.ProductoGeneral;

public class ProductoGeneralDAO {
	
	ConexionMySQL conexion = new ConexionMySQL();
	
	public List<ProductoGeneral> listarProductosGenerales() {
        List<ProductoGeneral> productosGen = new ArrayList<>();
        String sql = "SELECT * from productos_generales";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	ProductoGeneral p = new ProductoGeneral();
            	p.setId(rs.getInt("id_prod_gen"));
            	p.setName(rs.getString("nombre"));
            	productosGen.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productosGen;
    }
}
