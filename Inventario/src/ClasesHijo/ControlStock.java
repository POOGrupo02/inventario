package ClasesHijo;

public class ControlStock {
	private String idProducto, nombreProducto;
	private int existIni, stkMin, entradas, salidas, stkActual;
	public ControlStock(String idProducto, String nombreProducto, int existIni, int stkMin, int entradas, int salidas,
			int stkActual) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.existIni = existIni;
		this.stkMin = stkMin;
		this.entradas = entradas;
		this.salidas = salidas;
		this.stkActual = stkActual;
	}
	
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getExistIni() {
		return existIni;
	}
	public void setExistIni(int existIni) {
		this.existIni = existIni;
	}
	public int getStkMin() {
		return stkMin;
	}
	public void setStkMin(int stkMin) {
		this.stkMin = stkMin;
	}
	public int getEntradas() {
		return entradas;
	}
	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
	public int getSalidas() {
		return salidas;
	}
	public void setSalidas(int salidas) {
		this.salidas = salidas;
	}
	public int getStkActual() {
		return stkActual;
	}
	public void setStkActual(int stkActual) {
		this.stkActual = stkActual;
	}
	
	
	
}
