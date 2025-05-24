package Arreglo;

import java.util.ArrayList;

import ClasePadre.Producto;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ArregloProducto {
	private ArrayList<Producto>produc;
    public ArregloProducto() {
    	produc=new ArrayList<Producto>();
    }
    public void Agregar(Producto p) {
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
    public Producto Buscar(String nombre) {
    	for (int i = 0; i < Cant_Productos(); i++) {
			if (Obtener(i).getNombre().equals(nombre)) 
			{
				  return Obtener(i);
			}
		}
    	return null;
    }
    public void Eliminar(Producto p){
    	produc.remove(p);
    }
    
}
