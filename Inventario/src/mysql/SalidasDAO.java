package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import claseshijo.Cliente;
import claseshijo.EntradaProducto;
import claseshijo.SalidaProducto;

public class SalidasDAO {

	ConexionMySQL conexion = new ConexionMySQL();

	private static final String SQL_SELECT = "SELECT "
	        + "s.id_salida, "
	        + "CONCAT(c.nombre, ' ', c.apellido) AS cliente, "
	        + "p.codigo_producto, "
	        + "pg.nombre AS producto, "
	        + "sp.cantidad, "
	        + "sp.monto, "
	        + "GROUP_CONCAT(fp.nombre SEPARATOR ', ') AS forma_pago, "
	        + "s.created_at "
	        + "FROM salidas s "
	        + "JOIN clientes c ON s.id_cliente = c.id_cliente "
	        + "JOIN salidas_formas_pagos sfp ON s.id_salida = sfp.id_salida "
	        + "JOIN formas_pago fp ON sfp.id_form_pag = fp.id_form_pag "
	        + "JOIN salidas_productos sp ON s.id_salida = sp.id_salida "
	        + "JOIN productos p ON sp.id_producto = p.id_producto "
	        + "JOIN productos_generales pg ON p.id_prod_gen = pg.id_prod_gen "
	        + "GROUP BY s.id_salida, p.codigo_producto, pg.nombre, sp.cantidad, sp.monto "
	        + "ORDER BY s.id_salida;";
	
	public Boolean createSalidas(ArrayList<SalidaProducto> listSalida, ArrayList<Integer> formasPago, Cliente cliente) {
		String sqlCreate = "INSERT INTO salidas (id_cliente) VALUES (?)";
		String sqlCreateMany = "INSERT INTO salidas_productos (id_salida, id_producto, cantidad, monto) VALUES (?, ?, ?, ?)";
		String sqlCreateFormPag = "INSERT INTO salidas_formas_pagos (id_salida, id_form_pag) VALUES (?,?)";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlCreate, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement psMany = con.prepareStatement(sqlCreateMany);
				PreparedStatement psFormPag = con.prepareStatement(sqlCreateFormPag)) {
			
			int idCliente = -1;
			
			ClienteDAO cDAO = new ClienteDAO();
			Cliente clienteExistente = cDAO.readClienteByDni(cliente.getDni());
			if(clienteExistente != null){
				cDAO.updateCliente(cliente);
				idCliente = clienteExistente.getId();
			}else {
				idCliente = cDAO.createCliente(cliente);
			}
			
			ps.setInt(1, idCliente);
			ps.executeUpdate();
			
			int idSalida = -1;
	        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                idSalida = generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("No se pudo obtener el ID generado para la salida.");
	            }
	        }

	        for (SalidaProducto sp : listSalida) {
	            psMany.setInt(1, idSalida);
	            psMany.setInt(2, Integer.parseInt(sp.getProducto()));
	            psMany.setInt(3, sp.getCantidad());
	            psMany.setDouble(4, sp.getMonto());
	            psMany.addBatch();
	        }
	        psMany.executeBatch();
	        
	        for(int fP : formasPago) {
	        	psFormPag.setInt(1, idSalida);
	        	psFormPag.setInt(2, fP);
	        	psFormPag.addBatch();
	        }
	        
	        psFormPag.executeBatch();
	        
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public ArrayList<SalidaProducto> readSalidas() {
		ArrayList<SalidaProducto> salidasProductos = new ArrayList<>();

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				SalidaProducto sP = new SalidaProducto();
				sP.setId(rs.getInt("id_salida"));
                sP.setCliente(rs.getString("cliente"));
                sP.setCodProd(rs.getString("codigo_producto"));
                sP.setProducto(rs.getString("producto"));
                sP.setCantidad(rs.getInt("cantidad"));
                sP.setMonto(rs.getDouble("monto"));
                sP.setFormaPago(rs.getString("forma_pago")); 
                sP.setCreatedAt(rs.getString("created_at"));
				salidasProductos.add(sP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salidasProductos;
	}

}
