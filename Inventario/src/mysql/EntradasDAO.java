package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import claseshijo.EntradaProducto;

public class EntradasDAO {

	ConexionMySQL conexion = new ConexionMySQL();

	private static final String SQL_SELECT = "SELECT "
	        + "e.id_entrada, "
	        + "pv.nombre_empresa AS proveedor, "
	        + "p.codigo_producto, "
	        + "pg.nombre AS producto, "
	        + "ep.cantidad, "
	        + "ep.monto "
	        + "FROM entradas e "
	        + "JOIN proveedores pv ON e.id_proveedor = pv.id_proveedor "
	        + "JOIN entradas_productos ep ON e.id_entrada = ep.id_entrada "
	        + "JOIN productos p ON ep.id_producto = p.id_producto "
	        + "JOIN productos_generales pg ON p.id_prod_gen = pg.id_prod_gen "
	        + "ORDER BY e.id_entrada;";


	public Boolean createEntradas(ArrayList<EntradaProducto> entradas) {
		String sqlCreate = "INSERT INTO entradas (id_proveedor) VALUES (?)";
		String sqlCreateMany = "INSERT INTO entradas_productos (id_entrada, id_producto, cantidad, monto) VALUES (?, ?, ?, ?)";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlCreate, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement psMany = con.prepareStatement(sqlCreateMany)) {
			ps.setInt(1, Integer.parseInt(entradas.get(0).getProveedor()));
			ps.executeUpdate();
			
			int idEntrada = -1;
	        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                idEntrada = generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("No se pudo obtener el ID generado para la entrada.");
	            }
	        }

	        for (EntradaProducto ep : entradas) {
	            psMany.setInt(1, idEntrada);
	            psMany.setInt(2, Integer.parseInt(ep.getProducto()));
	            psMany.setInt(3, ep.getCantidad());
	            psMany.setDouble(4, ep.getMonto());
	            psMany.addBatch();
	        }

	        psMany.executeBatch();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public ArrayList<EntradaProducto> readEntradas() {
		ArrayList<EntradaProducto> entradasProductos = new ArrayList<>();

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				EntradaProducto eP = new EntradaProducto();
				eP.setIdEntrada(rs.getInt("id_entrada"));
				eP.setProveedor(rs.getString("proveedor"));
				eP.setCodProd(rs.getString("codigo_producto"));
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
