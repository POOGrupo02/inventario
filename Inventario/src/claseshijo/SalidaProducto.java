package claseshijo;

public class SalidaProducto {
    private int id;
    private String cliente;
    private String producto;
    private String codProd;
    private int cantidad;
    private double monto;
    private String formaPago;
    private String createdAt;

    public SalidaProducto() {
    	
    }
    public SalidaProducto(int id, String cliente, String codProd ,String producto, int cantidad, double monto, String formaPago, String createdAt) {
        this.id = id;
        this.cliente = cliente;
        this.codProd = codProd;
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto = monto;
        this.formaPago = formaPago;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    
    public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
