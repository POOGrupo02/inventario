package mysql;

import java.sql.*;
import java.util.ArrayList;

import claseshijo.ProductoGeneral;

public class ProductoGeneralDAO {
    
    ConexionMySQL conexion = new ConexionMySQL();
    
    public Boolean createProductoGeneral(ProductoGeneral productoGeneral) {
        String sqlCreate = "INSERT INTO productos_generales (nombre) VALUES (?)";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlCreate)) {
            ps.setString(1, productoGeneral.getName());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ProductoGeneral> readProductosGenerales() {
    	ArrayList<ProductoGeneral> productosGen = new ArrayList<>();
        String sql = "SELECT * from productos_generales";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ProductoGeneral p = new ProductoGeneral();
                p.setId(rs.getInt("id_prod_gen"));
                p.setName(rs.getString("nombre"));
                p.setCreatedAt(rs.getString("created_at"));
                p.setUpdatedAt(rs.getString("updated_at"));
                productosGen.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productosGen;
    }

    public Boolean updateProductoGeneral(ProductoGeneral productoGeneral) {
        String sqlUpdate = "UPDATE productos_generales SET nombre = ? WHERE id_prod_gen = ?";

        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
            ps.setString(1, productoGeneral.getName());
            ps.setInt(2, productoGeneral.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean deleteProductGen(int id) {
		String sqlDelete = "DELETE FROM productos_generales WHERE id_prod_gen = ?";
		
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
		String sqlQuestion = "SELECT COUNT(*) FROM productos WHERE estado = 1 AND id_prod_gen = ?";

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
