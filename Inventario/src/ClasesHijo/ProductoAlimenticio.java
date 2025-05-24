package ClasesHijo;

import java.util.Date;

import ClasePadre.Producto;

public class ProductoAlimenticio extends Producto{
private Date fechaVencimiento;

public ProductoAlimenticio(int id, int stock, String nombre, String categoría, double precio, Date fechaVencimiento) {
	super(id, stock, nombre, categoría, precio);
	this.fechaVencimiento = fechaVencimiento;
}



}
