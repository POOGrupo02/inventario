package ClasesHijo;

import ClasePadre.Producto;

public class ProductoElectrónico extends Producto{
private String marca;

public ProductoElectrónico(int id, int stock, String nombre, String categoría, double precio, String marca) {
	super(id, stock, nombre, categoría, precio);
	this.marca = marca;
}

}
