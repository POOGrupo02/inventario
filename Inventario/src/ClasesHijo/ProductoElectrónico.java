package ClasesHijo;

import ClasePadre.Producto;

public class ProductoElectrónico extends Producto{
private int mesesGarantía;

public ProductoElectrónico(String id, String nombre, double precio, String categoría, int stock, int stockMin,
		int mesesGarantía) {
	super(id, nombre, precio, categoría, stock, stockMin);
	this.mesesGarantía = mesesGarantía;
}

public int getMesesGarantía() {
	return mesesGarantía;
}

public void setMesesGarantía(int mesesGarantía) {
	this.mesesGarantía = mesesGarantía;
}

}
