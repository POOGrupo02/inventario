package ClasesHijo;

import java.util.Date;
import java.util.List;

import ClasePadre.Producto;

public class ProductoAlimenticio extends Producto {
	
	private List<InformacionNutricional> informacionNutricional;
	
	public ProductoAlimenticio(
			String codigo, 
			String nombre, 
			String categoría, 
			String marca, 
			String proveedor,
			String unidadVenta, 
			String unidadMedida, 
			double precio, 
			double cantidadPorUnidad, 
			int stock, 
			int stockMin,
			Date fechaFabricacion, 
			Date fechaVencimiento,
			List<InformacionNutricional> informacionNutricional
			) 
	{
		this.informacionNutricional = informacionNutricional;
	}

	public List<InformacionNutricional> getInformacionNutricional() {
		return informacionNutricional;
	}

	public void setInformacionNutricional(List<InformacionNutricional> informacionNutricional) {
		this.informacionNutricional = informacionNutricional;
	}
}
