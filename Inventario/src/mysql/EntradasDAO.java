package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import claseshijo.EntradaProducto;

public class EntradasDAO {

	ConexionMySQL conexion = new ConexionMySQL();

	private static final String SQL_SELECT = "SELECT " + "e.id_entrada, " + "pv.nombre_empresa AS proveedor, "
			+ "pg.nombre AS producto, " + "ep.cantidad, " + "ep.monto " + "FROM entradas e "
			+ "JOIN proveedores pv ON e.id_proveedor = pv.id_proveedor "
			+ "JOIN entradas_productos ep ON e.id_entrada = ep.id_entrada "
			+ "JOIN productos p ON ep.id_producto = p.id_producto "
			+ "JOIN productos_generales pg ON p.id_prod_gen = pg.id_prod_gen;";

	public Boolean createEntradas(int idProveedor, List<EntradaProducto> entradas) {
		String sqlCreate = "INSERT INTO entradas (id_proveedor) VALUES (?)";
		String sqlCreateMany = "INSERT INTO entradas_productos (id_entrada, id_producto, cantidad, monto) VALUES (?, ?, ?, ?)";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlCreate);
				PreparedStatement psMany = con.prepareStatement(sqlCreateMany)) {
			ps.setInt(1, idProveedor);
			ps.executeUpdate();
			
			for (int i = 0; i < entradas.size(); i++) {
				
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<EntradaProducto> readEntradas() {
		List<EntradaProducto> entradasProductos = new ArrayList<>();

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				EntradaProducto eP = new EntradaProducto();
				eP.setIdEntrada(rs.getInt("id_entrada"));
				eP.setProveedor(rs.getString("proveedor"));
				eP.setProducto(rs.getString("producto"));
				eP.setCantidad(rs.getInt("cantidad"));
				eP.setMonto(rs.getDouble("monto"));
				entradasProductos.add(eP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entradasProductos;
	}

}
