package ClasePadre;

import java.util.Date;

public class Producto {
	private String codigo, nombre, categoría, marca, proveedor, unidadVenta, unidadMedida;
	private double precio, cantidadPorUnidad;
	private int stock, stockMin;
	private Date fechaFabricacion, fechaVencimiento;
	
	
	public Producto(String codigo, String nombre, String categoría, String marca, String proveedor, String unidadVenta,
			String unidadMedida, double precio, double cantidadPorUnidad, int stock, int stockMin,
			Date fechaFabricacion, Date fechaVencimiento) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoría = categoría;
		this.marca = marca;
		this.proveedor = proveedor;
		this.unidadVenta = unidadVenta;
		this.unidadMedida = unidadMedida;
		this.precio = precio;
		this.cantidadPorUnidad = cantidadPorUnidad;
		this.stock = stock;
		this.stockMin = stockMin;
		this.fechaFabricacion = fechaFabricacion;
		this.fechaVencimiento = fechaVencimiento;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCategoría() {
		return categoría;
	}


	public void setCategoría(String categoría) {
		this.categoría = categoría;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getProveedor() {
		return proveedor;
	}


	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public String getUnidadVenta() {
		return unidadVenta;
	}


	public void setUnidadVenta(String unidadVenta) {
		this.unidadVenta = unidadVenta;
	}


	public String getUnidadMedida() {
		return unidadMedida;
	}


	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getCantidadPorUnidad() {
		return cantidadPorUnidad;
	}


	public void setCantidadPorUnidad(double cantidadPorUnidad) {
		this.cantidadPorUnidad = cantidadPorUnidad;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getStockMin() {
		return stockMin;
	}


	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}


	public Date getFechaFabricacion() {
		return fechaFabricacion;
	}


	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}


	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
	
}
