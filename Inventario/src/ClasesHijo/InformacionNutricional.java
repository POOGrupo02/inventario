package ClasesHijo;

public class InformacionNutricional {
	
	private double calorias, grasas, proteinas, carbohidratos;

	public InformacionNutricional(double calorias, double grasas, double proteinas, double carbohidratos) {
		this.calorias = calorias;
		this.grasas = grasas;
		this.proteinas = proteinas;
		this.carbohidratos = carbohidratos;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public double getGrasas() {
		return grasas;
	}

	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}

	public double getProteinas() {
		return proteinas;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public double getCarbohidratos() {
		return carbohidratos;
	}

	public void setCarbohidratos(double carbohidratos) {
		this.carbohidratos = carbohidratos;
	}
	
	

}
