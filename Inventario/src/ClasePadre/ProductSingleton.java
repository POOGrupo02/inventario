package ClasePadre;

import java.util.ArrayList;
import java.util.List;

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
    
    public Producto BuscarId(String id) {
    	for (int i = 0; i < listProducts.size(); i++) {
			if (Obtener(i).getId().equals(id))
			{
				  return Obtener(i);
			}
		}
    	return null;
    }
    
    public Producto BuscarNombre(String nombre) {
    	for (int i = 0; i < listProducts.size(); i++) {
			if (Obtener(i).getNombre().equals(nombre)) 
			{
				  return Obtener(i);
			}
		}
    	return null;
    }
    
    public boolean eliminarProductoPorId(String id) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (id.equals(listProducts.get(i).getId())) {
                listProducts.remove(i);
                return true;
            }
        }
        return false;
    }


    public Producto getProducto(int index) {
        return listProducts.get(index);
    }
    
    public Producto Obtener(int posicion){
    	return listProducts.get(posicion);
    }
    
    public void Eliminar(Producto p){
    	listProducts.remove(p);
    }
    
    public int getSize() {
    	return listProducts.size();
    }
}
