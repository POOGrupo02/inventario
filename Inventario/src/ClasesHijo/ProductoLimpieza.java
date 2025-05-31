package ClasesHijo;

import java.util.Date;

import ClasePadre.Producto;

public class ProductoLimpieza extends Producto {
	
	private String descripcion, instruciones;

	public ProductoLimpieza(
			String codigo, 
			String nombre, 
			String categoría, 
			String marca, 
			String proveedor,
			String unidadVenta, 
			String unidadMedida, 
			double precio, 
			double cantidadPorUnidad, 
			int stock, 
			int stockMin,
			Date fechaFabricacion, 
			Date fechaVencimiento, 
			String descripcion, 
			String instruciones) {
		super(codigo, nombre, categoría, marca, proveedor, unidadVenta, unidadMedida, precio, cantidadPorUnidad, stock,
				stockMin, fechaFabricacion, fechaVencimiento);
		this.descripcion = descripcion;
		this.instruciones = instruciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getInstruciones() {
		return instruciones;
	}

	public void setInstruciones(String instruciones) {
		this.instruciones = instruciones;
	}
	
	

}
