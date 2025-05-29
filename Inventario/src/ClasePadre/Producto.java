package ClasePadre;

public class Producto {
protected int stock,stockMin;
protected String id,nombre,categoría,marca;
protected double precio;
public Producto(int stock, int stockMin, String id, String nombre, String categoría, String marca, double precio) {
	super();
	this.stock = stock;
	this.stockMin = stockMin;
	this.id = id;
	this.nombre = nombre;
	this.categoría = categoría;
	this.marca = marca;
	this.precio = precio;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getStockMin() {
	return stockMin;
}
public void setStockMin(int stockMin) {
	this.stockMin = stockMin;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}



}
