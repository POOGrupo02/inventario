package claseshijo;

public class ProvPorProd {
    private String proveedor;
    private String codigoProducto;
    private String producto;

    public ProvPorProd() {
    	
    }
    public ProvPorProd(String proveedor, String codigoProducto, String producto) {
        this.proveedor = proveedor;
        this.codigoProducto = codigoProducto;
        this.producto = producto;
    }

    // Getters y Setters
    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}

