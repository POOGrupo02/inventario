package ClasesHijo;

import ClasePadre.Producto;

public class ProductoLimpieza extends Producto{
private String tipoUso; //puede ser doméstico, industrial,etc
private double contenidoLitros;
public ProductoLimpieza(int id, int stock, String nombre, String categoría, double precio, String tipoUso,
		double contenidoLitros) {
	super(id, stock, nombre, categoría, precio);
	this.tipoUso = tipoUso;
	this.contenidoLitros = contenidoLitros;
}
public String getTipoUso() {
	return tipoUso;
}
public void setTipoUso(String tipoUso) {
	this.tipoUso = tipoUso;
}
public double getContenidoLitros() {
	return contenidoLitros;
}
public void setContenidoLitros(double contenidoLitros) {
	this.contenidoLitros = contenidoLitros;
}

}
