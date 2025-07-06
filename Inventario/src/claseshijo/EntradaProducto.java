package claseshijo;

public class EntradaProducto {
	private int id;
	private String proveedor;
	private String producto;
	private String codProd;
	private int cantidad;
	private double monto;
	private String createdAt;
	private String usuario;

	public EntradaProducto() {

	}

	public EntradaProducto(int id, String proveedor, String codProd , String producto, String usuario , int cantidad, double monto, String createdAt) {
		this.id = id;
		this.proveedor = proveedor;
		this.codProd = codProd;
		this.producto = producto;
		this.usuario = usuario;
		this.cantidad = cantidad;
		this.monto = monto;
		this.createdAt = createdAt;
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
	
	public String getCodProd() {
    	return codProd;
    }
    
    public void setCodProd(String codProd) {
    	this.codProd = codProd;
    }

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public String getUsuario() {
    	return usuario;
    }
    
    public void setUsuario(String usuario) {
    	this.usuario = usuario;
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
	
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
