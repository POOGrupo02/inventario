package ClasePadre;

public class Producto {
protected int stock,stockMin;
protected String id,nombre,categoría;
protected double precio;
public Producto(String id, String nombre, double precio, String categoría, int stock, int stockMin) {
	super();
	this.id = id;
	this.stock = stock;
	this.nombre = nombre;
	this.categoría = categoría;
	this.precio = precio;
	this.stockMin = stockMin;
}
public String getId() {
	return id;
}
public void setId(String id) {
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


}
