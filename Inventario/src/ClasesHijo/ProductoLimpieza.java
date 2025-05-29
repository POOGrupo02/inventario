package ClasesHijo;

import ClasePadre.Producto;

public class ProductoLimpieza extends Producto{
private String tipoUso; //puede ser doméstico, industrial, eléctronico,etc

public ProductoLimpieza(String id, String nombre, double precio, String categoría, int stock, int stockMin,
		String tipoUso) {
	super(id, nombre, precio, categoría, stock, stockMin);
	this.tipoUso = tipoUso;
}

public String getTipoUso() {
	return tipoUso;
}

public void setTipoUso(String tipoUso) {
	this.tipoUso = tipoUso;
}

}
