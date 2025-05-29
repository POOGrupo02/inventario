package ClasesHijo;

import java.util.Date;

import ClasePadre.Producto;

public class ProductoAlimenticio extends Producto{
private Date fechaVencimiento;
private boolean esPerecible;
public ProductoAlimenticio(String id, String nombre, double precio, String categoría, int stock, int stockMin,
		Date fechaVencimiento, boolean esPerecible) {
	super(id, nombre, precio, categoría, stock, stockMin);
	this.fechaVencimiento = fechaVencimiento;
	this.esPerecible = esPerecible;
}
public Date getFechaVencimiento() {
	return fechaVencimiento;
}
public void setFechaVencimiento(Date fechaVencimiento) {
	this.fechaVencimiento = fechaVencimiento;
}
public boolean isEsPerecible() {
	return esPerecible;
}
public void setEsPerecible(boolean esPerecible) {
	this.esPerecible = esPerecible;
}


}
