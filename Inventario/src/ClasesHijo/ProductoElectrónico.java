package ClasesHijo;

import ClasePadre.Producto;

public class ProductoElectrónico extends Producto{
private String marca;
private int mesesGarantía;
public ProductoElectrónico(int id, int stock, String nombre, String categoría, double precio, String marca,
		int mesesGarantía) {
	super(id, stock, nombre, categoría, precio);
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
