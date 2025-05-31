package ClasesHijo;

public class Movimientos {
	private int id,  cantidad;
	private String idProducto,producto, movimiento, fecha;
	
	public Movimientos(int id, String codigoProducto, String producto, String movimiento, int cantidad, String fecha) {
		this.id = id;
		this.idProducto = codigoProducto;
		this.producto = producto;
		this.movimiento = movimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
