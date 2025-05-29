package ClasesHijo;

import java.util.Date;

import ClasePadre.Producto;

public class ProductoLimpieza extends Producto{
private String tipoUso; //puede ser doméstico, industrial, eléctronico,etc
private Date fechaVencimiento;
public ProductoLimpieza(String id, String nombre, double precio, String categoría, int stock, int stockMin,
		String tipoUso, Date fechaVencimiento) {
	super(id, nombre, precio, categoría, stock, stockMin);
	this.tipoUso = tipoUso;
	this.fechaVencimiento = fechaVencimiento;
}

}
