package Clases;

public class Producto {
protected int id,stock;
protected String nombre,categoría;
protected double precio;
public Producto(int id, int stock, String nombre, String categoría, double precio) {
	super();
	this.id = id;
	this.stock = stock;
	this.nombre = nombre;
	this.categoría = categoría;
	this.precio = precio;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCategoría() {
	return categoría;
}
public void setCategoría(String categoría) {
	this.categoría = categoría;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public String MostrarInfo(int id, String nombre, String categoria,double precio) {
	return id+"\t"+nombre+"\t"+categoria+"\t"+precio;
}
}
