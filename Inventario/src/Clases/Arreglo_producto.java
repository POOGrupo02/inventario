package Clases;

import java.util.ArrayList;

public class Arreglo_producto {
	private ArrayList<Producto>produc;
    public Arreglo_producto() {
    	produc=new ArrayList<Producto>();
    }
    public void Adicionar(Producto p) {
    	produc.add(p);
    }
    public int Cant_Productos() {
    	return produc.size();
    }
    public Producto Obtener(int posicion){
    	return produc.get(posicion);
    }
    
    
}
