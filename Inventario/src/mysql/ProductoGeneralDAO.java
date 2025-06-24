package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<ProductoGeneral> readProductosGenerales() {
        List<ProductoGeneral> productosGen = new ArrayList<>();
        String sql = "SELECT * from productos_generales WHERE estado = TRUE";

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

    public Boolean deleteProductoGeneral(int id) {
        String sqlDelete = "UPDATE productos_generales SET estado = FALSE WHERE id_prod_gen = ?";

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
