package ClasesHijo;

import ClasePadre.Producto;

public class ProductoLimpieza extends Producto{
private String tipoUso; //puede ser doméstico, industrial,etc

public ProductoLimpieza(int id, int stock, String nombre, String categoría, double precio, String tipoUso) {
	super(id, stock, nombre, categoría, precio);
	this.tipoUso = tipoUso;
}

}
