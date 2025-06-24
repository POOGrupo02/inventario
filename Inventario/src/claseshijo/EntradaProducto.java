package claseshijo;

public class EntradaProducto {
	private int id;
	private String proveedor;
	private String producto;
	private int cantidad;
	private double monto;

	public EntradaProducto() {

	}

	public EntradaProducto(int id, String proveedor, String producto, int cantidad, double monto) {
		this.id = id;
		this.proveedor = proveedor;
		this.producto = producto;
		this.cantidad = cantidad;
		this.monto = monto;
	}

	public int getId() {
		return id;
	}

	public void setIdEntrada(int id) {
		this.id = id;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
}
