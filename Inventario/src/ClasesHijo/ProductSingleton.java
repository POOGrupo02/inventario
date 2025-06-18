package ClasesHijo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ClasePadre.Producto;

public class ProductSingleton {

	private static final ProductSingleton instancia = new ProductSingleton();

	private List<Producto> listProducts;

	private ProductSingleton() {
		listProducts = new ArrayList<>();
	}

	public static ProductSingleton getInstance() {
		return instancia;
	}

	public List<Producto> getListProducts() {
		return listProducts;
	}

	public void addProducto(Producto producto) {
		listProducts.add(producto);
	}

	public Producto getProducto(int index) {
		return listProducts.get(index);
	}

	public void eliminar(Producto p) {
		listProducts.remove(p);
	}

	public int getSize() {
		return listProducts.size();
	}

	
	public void guardarCsv() {
		/*File archivo = new File("productos.csv");
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(archivo), "UTF-8");
				PrintWriter pw = new PrintWriter(writer)) {

			writer.write('\uFEFF');

			pw.println("ID;Nombre;Precio;Categoria;Stock");

			for (int i = 0; i < getSize(); i++) {
				Producto p = getProducto(i);
				pw.println(p.getCodigo() + ";" + p.getNombre() + ";" + p.getPrecio() + ";" + p.getCategoría() + ";"
						+ p.getStock());
			}

			JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en la carpeta del proyecto");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
		}*/
	}
}
