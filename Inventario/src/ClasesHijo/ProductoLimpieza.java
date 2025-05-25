package ClasesHijo;

import ClasePadre.Producto;

public class ProductoLimpieza extends Producto{
private String tipoUso; //puede ser doméstico, industrial, eléctronico,etc
private double cantLitros;
public ProductoLimpieza(String id, int stock,  int stockMin, String nombre, String categoría, double precio, String tipoUso,
		double cantLitros) {
	super(id, nombre,precio, categoría,stock, stockMin);
	this.tipoUso = tipoUso;
	this.cantLitros = cantLitros;
}
public String getTipoUso() {
	return tipoUso;
}
public void setTipoUso(String tipoUso) {
	this.tipoUso = tipoUso;
}
public double getCantLitros() {
	return cantLitros;
}
public void setCantLitros(double cantLitros) {
	this.cantLitros = cantLitros;
}


}
