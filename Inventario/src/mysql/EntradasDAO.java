package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import claseshijo.EntradaProducto;
import claseshijo.Proveedor;
import claseshijo.Singleton;

public class EntradasDAO {

	ConexionMySQL conexion = new ConexionMySQL();

	private static final String SQL_SELECT = "SELECT " +
            "e.id_entrada, " +
            "u.nombre_usuario AS usuario, " +
            "p.codigo_producto, " +
            "pg.nombre AS producto, " +
            "pv.nombre_empresa AS proveedor, " +
            "ep.cantidad, " +
            "ep.monto, " +
            "e.created_at " +
            "FROM entradas e " +
            "JOIN entradas_productos ep ON e.id_entrada = ep.id_entrada " +
            "JOIN usuarios u ON e.id_usuario = u.id " +
            "JOIN proveedores pv ON ep.id_proveedor = pv.id_proveedor " +
            "JOIN productos p ON ep.id_producto = p.id_producto " +
            "JOIN productos_generales pg ON p.id_prod_gen = pg.id_prod_gen " +
            "ORDER BY e.id_entrada DESC;";


	public Boolean createEntradas(ArrayList<EntradaProducto> entradas) {
		String sqlCreate = "INSERT INTO entradas (id_usuario) VALUES (?)";
		String sqlCreateMany = "INSERT INTO entradas_productos (id_entrada, id_producto, id_proveedor, cantidad, monto) VALUES (?,?,?,?,?)";
		
		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlCreate, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement psMany = con.prepareStatement(sqlCreateMany)) {
			
			ps.setInt(1, Singleton.getInstancia().getIdUsuario());
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
				psMany.setInt(3, Integer.parseInt(ep.getProveedor()));
				psMany.setInt(4, ep.getCantidad());
				psMany.setDouble(5, ep.getMonto());
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
				eP.setUsuario(rs.getString("usuario"));
				eP.setProveedor(rs.getString("proveedor"));
				eP.setCodProd(rs.getString("codigo_producto"));
				eP.setProducto(rs.getString("producto"));
				eP.setCantidad(rs.getInt("cantidad"));
				eP.setMonto(rs.getDouble("monto"));
				eP.setCreatedAt(rs.getString("created_at"));
				entradasProductos.add(eP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entradasProductos;
	}

	public ArrayList<Proveedor> readProvsByIdProd(int idProd) {
		String sqlSelect = "SELECT pr.id_proveedor, pr.ruc AS ruc, pr.nombre_empresa AS proveedor "
				+ "FROM proveedores pr "
				+ "JOIN proveedores_productos prp ON pr.id_proveedor = prp.id_proveedor "
				+ "WHERE prp.id_producto = ? AND estado = TRUE";
		
		ArrayList<Proveedor> proveedores = new ArrayList<>();

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlSelect)) {
			ps.setInt(1, idProd);
			
			try(ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
					Proveedor prv = new Proveedor();
					prv.setId(rs.getInt("id_proveedor"));
					prv.setRuc(rs.getString("ruc"));
					prv.setNombreEmpresa(rs.getString("proveedor"));
					proveedores.add(prv);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proveedores;
	}

}
