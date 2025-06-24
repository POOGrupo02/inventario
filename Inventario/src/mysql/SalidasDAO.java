package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import claseshijo.EntradaProducto;
import claseshijo.SalidaProducto;

public class SalidasDAO {

	ConexionMySQL conexion = new ConexionMySQL();

	private static final String SQL_SELECT = 
		    "SELECT " +
		    "s.id_salida, " +
		    "CONCAT(c.nombre, ' ', c.apellido) AS cliente, " +
		    "pg.nombre AS producto, " +
		    "sp.cantidad, " +
		    "sp.monto, " +
		    "fp.nombre AS forma_pago " +
		    "FROM salidas s " +
		    "JOIN clientes c ON s.id_cliente = c.id_cliente " +
		    "JOIN salidas_formas_pagos sfp ON s.id_salida = sfp.id_salida " +
		    "JOIN formas_pago fp ON sfp.id_form_pag = fp.id_form_pag " +
		    "JOIN salidas_productos sp ON s.id_salida = sp.id_salida " +
		    "JOIN productos p ON sp.id_producto = p.id_producto " +
		    "JOIN productos_generales pg ON p.id_prod_gen = pg.id_prod_gen "+
		    "ORDER BY s.id_salida;";
	
	public Boolean createSalidas(ArrayList<SalidaProducto> salidas) {
		String sqlCreate = "INSERT INTO entradas (id_cliente) VALUES (?)";
		String sqlCreateMany = "INSERT INTO entradas_productos (id_salida, id_producto, cantidad, monto) VALUES (?, ?, ?, ?)";

		try (Connection con = conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlCreate, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement psMany = con.prepareStatement(sqlCreateMany)) {
			ps.setInt(1, Integer.parseInt(salidas.get(0).getCliente()));
			ps.executeUpdate();
			
			int idEntrada = -1;
	        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                idEntrada = generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("No se pudo obtener el ID generado para la entrada.");
	            }
	        }

	        for (SalidaProducto sp : salidas) {
	            psMany.setInt(1, idEntrada);
	            psMany.setInt(2, Integer.parseInt(sp.getProducto()));
	            psMany.setInt(3, sp.getCantidad());
	            psMany.setDouble(4, sp.getMonto());
	            psMany.addBatch();
	        }

	        psMany.executeBatch();
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
                sP.setProducto(rs.getString("producto"));
                sP.setCantidad(rs.getInt("cantidad"));
                sP.setMonto(rs.getDouble("monto"));
                sP.setFormaPago(rs.getString("forma_pago"));   
				salidasProductos.add(sP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salidasProductos;
	}

}
