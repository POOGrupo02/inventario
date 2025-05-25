package ClasesHijo;

import ClasePadre.Producto;

public class ProductoElectrónico extends Producto{
private String marca;
private int mesesGarantía;
public ProductoElectrónico(String id, int stock,  int stockMin, String nombre, String categoría, double precio, String marca,
		int mesesGarantía) {
	super(id, nombre,precio, categoría,stock, stockMin);
	this.marca = marca;
	this.mesesGarantía = mesesGarantía;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public int getMesesGarantía() {
	return mesesGarantía;
}
public void setMesesGarantía(int mesesGarantía) {
	this.mesesGarantía = mesesGarantía;
}

}
