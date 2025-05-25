package Arreglo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ClasePadre.Producto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;


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
    public Producto BuscarId(String id) {
    	for (int i = 0; i < Cant_Productos(); i++) {
			if (Obtener(i).getId()==id) 
			{
				  return Obtener(i);
			}
		}
    	return null;
    }
    public Producto BuscarNombre(String nombre) {
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
    public void GuardarCsv() {
    	File archivo=new File("productos.csv");
    	try (PrintWriter pw=new PrintWriter(new FileWriter(archivo))) {
			pw.println("ID;Nombre;Precio;Categoria;Stock");
			 for (int i = 0; i < Cant_Productos(); i++) {
		            Producto p =Obtener(i); 
		            
		        
		            pw.println(p.getId() + ";" + p.getNombre() + ";" + p.getPrecio() + ";" +
		                       p.getCategoría() + ";" + p.getStock());
		        }
			 JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en la carpeta del proyecto");
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
		}
    }
}
