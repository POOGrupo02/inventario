package ClasesHijo;

import ClasePadre.Producto;

public class ProductoLimpieza extends Producto{
private String tipoUso; //puede ser doméstico, industrial,etc
private double cantLitros;
public ProductoLimpieza(int id, int stock, String nombre, String categoría, double precio, String tipoUso,
		double cantLitros) {
	super(id, stock, nombre, categoría, precio);
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
