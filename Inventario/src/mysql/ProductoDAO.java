package mysql;

import java.sql.*;
import java.util.ArrayList;

import clasepadre.Producto;

public class ProductoDAO {
	ConexionMySQL conexion = new ConexionMySQL();

	private static final String SQL_SELECT =
		    "SELECT p.id_producto, p.codigo_producto, pg.nombre AS nombre, " +
		    "u.nombre AS unidad_medida, pr.nombre AS presentacion, m.nombre AS marca, " +
		    "p.stock, p.stock_min, p.costo_base, p.porcent_margen, p.cantidad_medida, " +
		    "p.fecha_fabricacion, p.fecha_vencimiento, p.created_at, p.updated_at " +
		    "FROM productos p " +
		    "JOIN productos_generales pg ON p.id_prod_gen = pg.id_prod_gen " +
		    "JOIN unidades_medidas u ON p.id_uni_medi = u.id_uni_medi " +
		    "JOIN presentaciones pr ON p.id_present = pr.id_present " +
		    "JOIN marcas m ON p.id_marca = m.id_marca " +
			"WHERE p.estado = TRUE ";

	public Boolean createProd(Producto p) {
		Boolean isCreated = true;
		
		String sqlCreate =
			    "INSERT INTO productos (" +
			        "codigo_producto, " +
			        "id_prod_gen, " +
			        "id_uni_medi, " +
			        "id_present, " +
			        "id_marca, " +
			        "stock, " +
			        "stock_min, " +
			        "costo_base, " +
			        "porcent_margen, " +
			        "cantidad_medida, " +
			        "fecha_fabricacion, " +
			        "fecha_vencimiento" +
			    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlCreate)) {
			ps.setString(1, p.getCodigoProducto());
			ps.setInt(2, Integer.parseInt(p.getProd()));
			ps.setInt(3, Integer.parseInt(p.getUnidadMedida()));
			ps.setInt(4, Integer.parseInt(p.getPresentacion()));
			ps.setInt(5, Integer.parseInt(p.getMarca()));
			ps.setInt(6, p.getStock());
			ps.setInt(7, p.getStockMin());
			ps.setDouble(8, p.getCostoBase());
			ps.setDouble(9, p.getPorcentMargen());
			ps.setDouble(10, p.getCantidadMedida());
			ps.setDate(11, new Date(p.getFechaFabricacion().getTime()));
			ps.setDate(12, new Date(p.getFechaVencimiento().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			isCreated = false;
		}

		return isCreated;
	}

	public ArrayList<Producto> readProds() {
		ArrayList<Producto> productos = new ArrayList<>();

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				productos.add(mapProducto(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	public Producto readProdByCod(String codigo) {
		Producto producto = null;
		String sqlRead = SQL_SELECT + "AND codigo_producto = ?";

		try (Connection con = conexion.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sqlRead)) {

			ps.setString(1, codigo);
			
			try(ResultSet rs = ps.executeQuery()){
				if (rs.next()) {
					producto = mapProducto(rs);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}

	public ArrayList<Producto> readProdsByProd(int idProduct) {
		ArrayList<Producto> productos = new ArrayList<>();

		String sqlFilt = SQL_SELECT + (idProduct> 0? "AND p.id_prod_gen = ?" : "");
		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlFilt)) {
			
			if(idProduct> 0) ps.setInt(1,idProduct);
			
			try(ResultSet rs = ps.executeQuery();){
				while (rs.next()) {
					productos.add(mapProducto(rs));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	public Boolean updateProd(Producto p) {
	    String sqlUpdate = "UPDATE productos SET " +
	            "codigo_producto = ?, " +
	            "id_prod_gen = ?, " +
	            "id_uni_medi = ?, " +
	            "id_present = ?, " +
	            "id_marca = ?, " +
	            "stock = ?, " +
	            "stock_min = ?, " +
	            "costo_base = ?, " +
	            "porcent_margen = ?, " +
	            "cantidad_medida = ?, " +
	            "fecha_fabricacion = ?, " +
	            "fecha_vencimiento = ? " +
	            "WHERE codigo_producto = ?";

	    try (Connection con = conexion.getConnection();
	    		PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
	        ps.setString(1, p.getCodigoProducto());
	        ps.setInt(2, Integer.parseInt(p.getProd()));
	        ps.setInt(3, Integer.parseInt(p.getUnidadMedida()));
	        ps.setInt(4, Integer.parseInt(p.getPresentacion()));
	        ps.setInt(5, Integer.parseInt(p.getMarca()));
	        ps.setInt(6, p.getStock());
	        ps.setInt(7, p.getStockMin());
	        ps.setDouble(8, p.getCostoBase());
	        ps.setDouble(9, p.getPorcentMargen());
	        ps.setDouble(10, p.getCantidadMedida());
	        ps.setDate(11, new Date(p.getFechaFabricacion().getTime()));
	        ps.setDate(12, new Date(p.getFechaVencimiento().getTime()));
	        ps.setString(13, p.getCodigoProducto());
	        ps.executeUpdate();
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public Boolean deleteProd(int idProd) {
		String sqlDelete = "UPDATE productos SET estado = FALSE WHERE id_producto = ?";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlDelete)) {
			ps.setInt(1, idProd);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	private Producto mapProducto(ResultSet rs) throws SQLException {
	    Producto p = new Producto();
	    p.setIdProducto(rs.getInt("id_producto"));
	    p.setCodigoProducto(rs.getString("codigo_producto"));
	    p.setProd(rs.getString("nombre"));
	    p.setUnidadMedida(rs.getString("unidad_medida"));
	    p.setPresentacion(rs.getString("presentacion"));
	    p.setMarca(rs.getString("marca"));
	    p.setStock(rs.getInt("stock"));
	    p.setStockMin(rs.getInt("stock_min"));
	    p.setCostoBase(rs.getDouble("costo_base"));
	    p.setPorcentMargen(rs.getDouble("porcent_margen"));
	    p.setCantidadMedida(rs.getDouble("cantidad_medida"));
	    p.setFechaFabricacion(rs.getDate("fecha_fabricacion"));
	    p.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
	    p.setCreatedAt(String.valueOf(rs.getTimestamp("created_at")));
	    p.setUpdatedAt(String.valueOf(rs.getTimestamp("updated_at")));
	    return p;
	}

}
