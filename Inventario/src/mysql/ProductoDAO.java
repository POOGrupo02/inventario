package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ClasePadre.Producto;

public class ProductoDAO {
	ConexionMySQL conexion = new ConexionMySQL();
	
	public void crearUsuario(Producto p) {
		java.util.Date fechaFab = p.getFechaFabricacion();
		java.util.Date fechaVenc = p.getFechaVencimiento();
		java.sql.Date fechaFabricacion = new java.sql.Date(fechaFab.getTime());
		java.sql.Date fechaVencimiento = new java.sql.Date(fechaVenc.getTime());
		
		String sql = "INSERT INTO productos (codigo, "
				+ "nombre, precio, marca, proveedor, unidad_venta, unidad_medida, "
				+ "categoria, cantidad_por_unidad, stock, stock_min, fecha_fabricacion, fecha_vencimiento) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try(Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getNombre());
			ps.setDouble(3, p.getPrecio());
			ps.setString(4, p.getMarca());
			ps.setString(5, p.getProveedor());
			ps.setString(6, p.getUnidadVenta());
			ps.setString(7, p.getUnidadMedida());
			ps.setString(8, p.getCategoría());
			ps.setDouble(9, p.getCantidadPorUnidad());
			ps.setInt(10, p.getStock());
			ps.setInt(11, p.getStockMin());
			ps.setDate(12, fechaFabricacion);
			ps.setDate(13,  fechaVencimiento);
			ps.executeUpdate();
			System.out.println("✅ Usuario creado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
