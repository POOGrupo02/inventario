package ClasesHijo;

import java.util.Date;

import ClasePadre.Producto;

public class ProductoAlimenticio extends Producto{
private Date fechaVencimiento;
private double peso;
private boolean esPerecible;
public ProductoAlimenticio(String id, int stock, int stockMin, String nombre, String categoría, double precio, Date fechaVencimiento,
		double peso, boolean esPerecible) {
	super(id, nombre,precio, categoría,stock,stockMin);
	this.fechaVencimiento = fechaVencimiento;
	this.peso = peso;
	this.esPerecible = esPerecible;
}
public Date getFechaVencimiento() {
	return fechaVencimiento;
}
public void setFechaVencimiento(Date fechaVencimiento) {
	this.fechaVencimiento = fechaVencimiento;
}
public double getPeso() {
	return peso;
}
public void setPeso(double peso) {
	this.peso = peso;
}
public boolean isEsPerecible() {
	return esPerecible;
}
public void setEsPerecible(boolean esPerecible) {
	this.esPerecible = esPerecible;
}

}
