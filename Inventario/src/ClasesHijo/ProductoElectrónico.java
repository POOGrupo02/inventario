package ClasesHijo;

import java.util.Date;

import ClasePadre.Producto;

public class ProductoElectrónico extends Producto {

	private int mesesGarantía;
	public ProductoElectrónico(String codigo, String nombre, String categoría, String marca, String proveedor,
			String unidadVenta, String unidadMedida, double precio, double cantidadPorUnidad, int stock, int stockMin,
			Date fechaFabricacion, Date fechaVencimiento, String marca2, int mesesGarantía) {
		super(codigo, nombre, categoría, marca, proveedor, unidadVenta, unidadMedida, precio, cantidadPorUnidad, stock,
				stockMin, fechaFabricacion, fechaVencimiento);
		marca = marca2;
		this.mesesGarantía = mesesGarantía;
	}
}
