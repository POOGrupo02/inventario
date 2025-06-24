package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		    "JOIN productos_generales pg ON p.id_prod_gen = pg.id_prod_gen;";

	public List<SalidaProducto> readSalidas() {
		List<SalidaProducto> salidasProductos = new ArrayList<>();

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
