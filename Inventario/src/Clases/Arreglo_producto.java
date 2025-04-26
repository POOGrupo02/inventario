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
    public Producto Buscar(int id) {
    	for (int i = 0; i < Cant_Productos(); i++) {
			if (Obtener(i).getId()==id) 
			{
				  return Obtener(i);
			}
		}
    	return null;
    }
    
}
