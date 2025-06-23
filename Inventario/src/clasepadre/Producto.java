package clasepadre;

import java.util.Date;

public class Producto {

    private int id;
    private String codigoProducto;
    private String producto;
    private String unidadMedida;
    private String presentacion;
    private String marca;
    private int stock;
    private int stockMin;
    private double costoBase;
    private double porcentMargen;
    private double cantidadMedida;
    private Date fechaFabricacion;
    private Date fechaVencimiento;
    private String createdAt;
    private String updatedAt;

    public Producto() {
    }

    public Producto(int id, String codigoProducto, String producto, String unidadMedida, String presentacion,
                    String marca, int stock, int stockMin, double costoBase, double porcentMargen, double cantidadMedida,
                    Date fechaFabricacion, Date fechaVencimiento) {
        this.id = id;
        this.codigoProducto = codigoProducto;
        this.producto = producto;
        this.unidadMedida = unidadMedida;
        this.presentacion = presentacion;
        this.marca = marca;
        this.stock = stock;
        this.stockMin = stockMin;
        this.costoBase = costoBase;
        this.porcentMargen = porcentMargen;
        this.cantidadMedida = cantidadMedida;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdProducto() {
        return id;
    }

    public void setIdProducto(int id) {
        this.id = id;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getProd() {
        return producto;
    }

    public void setProd(String nombreProdGen) {
        this.producto = nombreProdGen;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public double getPorcentMargen() {
        return porcentMargen;
    }

    public void setPorcentMargen(double porcentMargen) {
        this.porcentMargen = porcentMargen;
    }

    public double getCantidadMedida() {
        return cantidadMedida;
    }

    public void setCantidadMedida(double cantidadMedida) {
        this.cantidadMedida = cantidadMedida;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}