package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ClasePadre.Producto;

public class ProductoDAO {
	ConexionMySQL conexion = new ConexionMySQL();

	String sqlCreate = "INSERT INTO productos (codigo_producto, id_prod_gen, id_uni_medi, id_present, id_marca, stock, "
			+ "stock_min, costo_base, porcent_margen, cantidad_medida, fecha_fabricacion, fecha_vencimiento) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	String sqlSelect = "SELECT\r\n" + "p.id_producto,\r\n" + "p.codigo_producto,\r\n" + "pg.nombre AS nombre,\r\n"
			+ "u.nombre AS unidad_medida,\r\n" + "pr.nombre AS presentacion,\r\n" + "m.nombre AS marca,\r\n"
			+ "p.stock,\r\n" + "p.stock_min,\r\n" + "p.costo_base,\r\n" + "p.porcent_margen,\r\n"
			+ "p.cantidad_medida,\r\n" + "p.fecha_fabricacion,\r\n" + "p.fecha_vencimiento,\r\n" + "p.created_at,\r\n"
			+ "p.updated_at\r\n" + "FROM productos p\r\n"
			+ "JOIN productos_generales pg ON p.id_prod_gen = pg.id_prod_gen\r\n"
			+ "JOIN unidades_medidas u ON p.id_uni_medi = u.id_uni_medi\r\n"
			+ "JOIN presentaciones pr ON p.id_present = pr.id_present\r\n"
			+ "JOIN marcas m ON p.id_marca = m.id_marca\r\n";

	public Boolean createProd(Producto p) {
		Boolean isCreated = true;

		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sqlCreate)) {
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
			ps.setDate(11, new java.sql.Date(p.getFechaFabricacion().getTime()));
			ps.setDate(12, new java.sql.Date(p.getFechaVencimiento().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			isCreated = false;
		}

		return isCreated;
	}

	public List<Producto> readProds() {
		List<Producto> productos = new ArrayList<>();

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlSelect);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
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
				productos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	public Producto readProdByCod(String codigo) {
		Producto producto = null;
		String sqlRead = sqlSelect + "WHERE codigo_producto = ?";

		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sqlRead)) {

			ps.setString(1, codigo);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				producto = new Producto();
				producto.setIdProducto(rs.getInt("id_producto"));
				producto.setCodigoProducto(rs.getString("codigo_producto"));
				producto.setProd(rs.getString("nombre"));
				producto.setUnidadMedida(rs.getString("unidad_medida"));
				producto.setPresentacion(rs.getString("presentacion"));
				producto.setMarca(rs.getString("marca"));
				producto.setStock(rs.getInt("stock"));
				producto.setStockMin(rs.getInt("stock_min"));
				producto.setCostoBase(rs.getDouble("costo_base"));
				producto.setPorcentMargen(rs.getDouble("porcent_margen"));
				producto.setCantidadMedida(rs.getDouble("cantidad_medida"));
				producto.setFechaFabricacion(rs.getDate("fecha_fabricacion"));
				producto.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
				producto.setCreatedAt(String.valueOf(rs.getTimestamp("created_at")));
				producto.setUpdatedAt(String.valueOf(rs.getTimestamp("updated_at")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}

	public List<Producto> readProdsByProd(String prod) {
		List<Producto> productos = new ArrayList<>();

		String sqlFilt = sqlSelect + (prod.equals("-1")? "" : "WHERE p.id_prod_gen = ?");
		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sqlFilt)) {
			
			if(!prod.equals("-1")) ps.setString(1, prod);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
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
				productos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	public void actualizarProducto(Producto p) {
		/*
		 * String sql =
		 * "UPDATE productos SET id_prod_gen=?, id_uni_medi=?, id_present=?, id_marca=?, stock=?, stock_min=?, "
		 * +
		 * "costo_base=?, porcent_margen=?, cantidad_medida=?, fecha_fabricacion=?, fecha_vencimiento=?"
		 * + "WHERE codigo_producto=?";
		 * 
		 * try (Connection con = conexion.getConnection(); PreparedStatement ps =
		 * con.prepareStatement(sql)) { ps.setInt(1, p.getIdProdGen()); ps.setInt(2,
		 * p.getIdUniMedi()); ps.setInt(3, p.getIdPresent()); ps.setInt(4,
		 * p.getIdMarca()); ps.setInt(5, p.getStock()); ps.setInt(6, p.getStockMin());
		 * ps.setDouble(7, p.getCostoBase()); ps.setDouble(8, p.getPorcentMargen());
		 * ps.setDouble(9, p.getCantidadMedida()); ps.setDate(10, new
		 * java.sql.Date(p.getFechaFabricacion().getTime())); ps.setDate(11, new
		 * java.sql.Date(p.getFechaVencimiento().getTime())); ps.setString(12,
		 * p.getCodigoProducto()); ps.executeUpdate();
		 * System.out.println("✅ Producto actualizado"); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
	}

	public void eliminarProducto(String codigo) {
		String sql = "DELETE FROM productos WHERE codigo_producto=?";

		try (Connection con = conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, codigo);
			ps.executeUpdate();
			System.out.println("🗑️ Producto eliminado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
