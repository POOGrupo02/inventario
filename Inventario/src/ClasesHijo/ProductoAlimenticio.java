package ClasesHijo;

import java.util.Date;

import ClasePadre.Producto;

public class ProductoAlimenticio extends Producto{
private Date fechaVencimiento;

public ProductoAlimenticio(String id, String nombre, double precio, String categoría, int stock, int stockMin,
		Date fechaVencimiento) {
	super(id, nombre, precio, categoría, stock, stockMin);
	this.fechaVencimiento = fechaVencimiento;
}

public Date getFechaVencimiento() {
	return fechaVencimiento;
}

public void setFechaVencimiento(Date fechaVencimiento) {
	this.fechaVencimiento = fechaVencimiento;
}

}
